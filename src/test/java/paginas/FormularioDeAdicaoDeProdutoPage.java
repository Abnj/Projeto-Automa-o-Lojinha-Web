package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;
    private WebDriverWait Driver;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;

    }

    public FormularioDeAdicaoDeProdutoPage informaNomeDoProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informaValorDoProduto(String valorProduto){
        navegador.findElement(By.id("produtovalor")).sendKeys(valorProduto);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informaCorDoProduto(String corProduto){
        navegador.findElement(By.id("produtocores")).sendKeys(corProduto);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage salvarProduto(){
        navegador.findElement(By.id("btn-salvar")).click();

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage adicionarComponente(){
        navegador.findElement(By.linkText("ADICIONAR COMPONENTE")).click();
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage nomeDoComponenteDoproduto(String nomeComponente){
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(2));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("componentenomeadicionar")));
        element.sendKeys(nomeComponente);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage quantidadeDoComponenteDoProduto(String quantidadeComponente){
        navegador.findElement(By.id("componentequantidadeadicionar")).sendKeys(quantidadeComponente);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage salvarComponente(){
        navegador.findElement(By.linkText("SALVAR COMPONENTE")).click();

        return this;
    }

    public String capturarMensagemDeApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }

    public String apresentarMensagemDeErro(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }

}
