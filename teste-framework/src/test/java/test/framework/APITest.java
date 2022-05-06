package test.framework;

import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://serverest.dev";
	}

	@Test
	public void deveLogarComSucesso() {
		RestAssured.given().body("{\r\n" + 
				"  \"email\": \"beltrano@qa.com.br\",\r\n" + 
				"  \"password\": \"teste12345\"\r\n" + 
				"}")
				.contentType(ContentType.JSON)
				.when()
					.post("/login")
				.then()
					.statusCode(200)
				.body("message", CoreMatchers.is("Login realizado com sucesso"));
	}

	@Test
	public void deveRetornarListaUsers() {
		RestAssured.given()
		.when()
			.get("/usuarios")
		.then()
			.statusCode(200)
			.log().all();
		;
	}

	@Test
	public void deveRetornarUserEspecifico() {
		RestAssured.given()
		.when()
			.get("/usuarios/0uxuPY0cbmQhpEz1")
		.then()
			.statusCode(200)
			.log().all();
		;
	}

	@Test
	public void deveCadastrarUserComSucesso() {
		RestAssured.given()
				.body("{\r\n" + "  \"nome\": \"Lucelia Santos\",\r\n" + "  \"email\": \"lust@qa.com.br\",\r\n"
						+ "  \"password\": \"teste\",\r\n" + "  \"administrador\": \"true\"\r\n" + "}")
				.contentType(ContentType.JSON)
				.when()
					.post("/usuarios")
				.then()
					.statusCode(201)
				.body("message", CoreMatchers.is("Cadastro realizado com sucesso"))
				.log().all();
	}
	
	@Test
	public void deveExcluirUserComSucesso() {
		RestAssured.given()
				.when()
					.delete("/usuarios/BKqkDJZG4Qwg0jpj")
				.then()
					.statusCode(200)
				.body("message", CoreMatchers.is("Registro excluído com sucesso"))
				.log().all();
	}
	
	@Test
	public void naodeveExcluirUserComSucesso() {
		RestAssured.given()
				.when()
					.delete("/usuarios/qPvnmsvlfdsUYUbq")
				.then()
					.statusCode(200)
				.body("message", CoreMatchers.is("Nenhum registro excluído"))
				.log().all();
	}
	
	@Test
	public void deveEditarUserComSucesso() {
		RestAssured.given()
				.body("{\r\n" + 
						"  \"nome\": \"Fulano da Silva\",\r\n" + 
						"  \"email\": \"beltrano@qa.com.br\",\r\n" + 
						"  \"password\": \"teste12345\",\r\n" + 
						"  \"administrador\": \"true\"\r\n" + 
						"}")
				.contentType(ContentType.JSON)
				.when()
					.put("/usuarios/0uxuPY0cbmQhpEz1")
				.then()
					.statusCode(200)
				.body("message", CoreMatchers.is("Registro alterado com sucesso"))
				.log().all();
	}

	@Test
	public void deveRetornarListaProdutos() {
		RestAssured.given()
		.when()
			.get("/produtos")
		.then()
			.statusCode(200)
			.log().all();
		;
	}

	@Test
	public void deveCadastrarProdutoComSucesso() {
		RestAssured.given()
				.body("{\r\n" + 
						"  \"nome\": \"Mouse\",\r\n" + 
						"  \"preco\": 30,\r\n" + 
						"  \"descricao\": \"Teste\",\r\n" + 
						"  \"quantidade\": 25\r\n" + 
						"}")
				.contentType(ContentType.JSON)
				.when()
					.post("/produtos")
				.then()
					.statusCode(201)
				.body("message", CoreMatchers.is("Cadastro realizado com sucesso"))
				.log().all();
	}

	@Test
	public void deveRetornarProdutoEspecifico() {
		RestAssured.given()
		.when()
			.get("/produtos/K6leHdftCeOJj8BJ")
		.then()
			.statusCode(200)
			.log().all();
		;
	}

	@Test
	public void deveEditarProdutoComSucesso() {
		RestAssured.given()
				.body("{\r\n" + 
						"    \"nome\": \"Samsung 60 polegadas Teste\",\r\n" + 
						"    \"preco\": 5240,\r\n" + 
						"    \"descricao\": \"TV\",\r\n" + 
						"    \"quantidade\": 49977,\r\n" + 
						"    \"_id\": \"K6leHdftCeOJj8BJ\"\r\n" + 
						"}")
				.contentType(ContentType.JSON)
				.when()
					.put("/produtos/K6leHdftCeOJj8BJ")
				.then()
					.statusCode(200)
				.body("message", CoreMatchers.is("Registro alterado com sucesso"))
				.log().all();
	}
}
