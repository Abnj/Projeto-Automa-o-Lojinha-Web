package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {
    private WebDriver navegador;

    public ListaDeProdutosPage(WebDriver navegador){
        this.navegador = navegador;

    }

    public FormularioDeAdicaoDeProdutoPage acessarFormularioDeAdicaoDeProdutos(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }

    public String apresentarMensagemLoginInvalido(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();

    }
}