package test.framework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskTest {

	public WebDriver acessarAplicacao() throws MalformedURLException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://front.serverest.dev/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	@Test
	public void deveCadastrarPrimeiroUser() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();

		try {

			// clicar em Cadastre-se
			driver.findElement(By.xpath("/html/body/div/div/div/form/small/a")).click();

			// escrever Nome
			driver.findElement(By.id("nome")).sendKeys("Leticia almeida");

			// escrever Email
			driver.findElement(By.id("email")).sendKeys("leticiaalmeida@gmail.com");

			// escrever Senha
			driver.findElement(By.id("password")).sendKeys("123456789");

			// clicar em Cadastrar Como Administrador
			driver.findElement(By.xpath("/html/body/div/div/div/form/div[4]/div/input")).click();

			// clicar em Cadastrar
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/div[5]/button")).click();

			// validar mensagem de sucesso
			// String message = driver.findElement(By.id("message")).getText();
			// Assert.assertEquals("Cadastro realizado com sucesso", message);

		} finally {
			// fechar o browser
			// driver.quit();
		}
	}

	@Test
	public void deveLogar() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();

		try {

			// escrever Email
			driver.findElement(By.id("email")).sendKeys("beltrano@qa.com.br");

			// escrever Senha
			driver.findElement(By.id("password")).sendKeys("teste12345");

			// clicar em Entrar
			driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

		} finally {
			// fechar o browser
			// driver.quit();
		}
	}

	@Test
	public void deveCadastrarNovoUser() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();

		try {

			// escrever Email
			driver.findElement(By.id("email")).sendKeys("beltrano@qa.com.br");

			// escrever Senha
			driver.findElement(By.id("password")).sendKeys("teste12345");

			// clicar em Entrar
			driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

			// clicar em Cadastrar Usuários
			driver.findElement(By.xpath("/html/body/div/div/div/p[2]/div[2]/div/div/a")).click();

			// escrever Nome
			driver.findElement(By.id("nome")).sendKeys("Leticia Silveira");

			// escrever Email
			driver.findElement(By.id("email")).sendKeys("leticia546@gmail.com");

			// escrever Senha
			driver.findElement(By.id("password")).sendKeys("123456789");

			// clicar em Cadastrar Como Administrador
			driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[4]/div/div/input")).click();

			// clicar em Cadastrar
			driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[5]/div/button")).click();

		} finally {
			// fechar o browser
			// driver.quit();
		}
	}

	@Test
	public void deveListarUsers() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();

		// escrever Email
		driver.findElement(By.id("email")).sendKeys("beltrano@qa.com.br");

		// escrever Senha
		driver.findElement(By.id("password")).sendKeys("teste12345");

		// clicar em Entrar
		driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

		// clicar em Listar Usuários
		driver.findElement(By.xpath("/html/body/div/div/div/p[2]/div[3]/div/div/a")).click();

		// clicar em Sair
		// driver.findElement(By.xpath("/html/body/div/div/nav/div/form/button")).click();

	}

}
