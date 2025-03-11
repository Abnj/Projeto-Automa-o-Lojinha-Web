package modulos.produtos;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    // Preparação do Ambiente Web para Iniciar a Automação
    public void beforEach(){

        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver.exe");
         this.navegador = new ChromeDriver();

         // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Navegar para a página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Registrar Produto com Sucessso")
    public void testRegistrarProdutoComSucesso() {

        String mensagemsucesso = new LoginPage(navegador)
                .informaUsuario("admin")
                .informaSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeProdutos()
                .informaNomeDoProduto("PS5")
                .informaValorDoProduto("4.500,00")
                .informaCorDoProduto("Preto")
                .salvarProduto()
                .capturarMensagemDeApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemsucesso);
    }

    @Test
    @DisplayName("Registrar Produto com Valor Maior que 7.000,00")
    public void testNaoEPermitidoRegistrarProdutoComValorMaiorQueSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informaUsuario("admin")
                .informaSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeProdutos()
                .informaNomeDoProduto("TV")
                .informaValorDoProduto("7.500,00")
                .informaCorDoProduto("Preto")
                .salvarProduto()
                .apresentarMensagemDeErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Registrar Produto e Adicionar Componente")
    public void testRegistrarProdutoEAdicionarComponente(){
            new LoginPage(navegador)
                .informaUsuario("admin")
                .informaSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeProdutos()
                .informaNomeDoProduto("TV Sony")
                .informaValorDoProduto("5.500,00")
                .informaCorDoProduto("Preto")
                .salvarProduto()
                .adicionarComponente()
                .nomeDoComponenteDoproduto("Cabo")
                .quantidadeDoComponenteDoProduto("1")
                .salvarComponente();

    }

    @AfterEach
    public void afterEach() {
        // Fechar o navegador
        navegador.quit();
    }
}
