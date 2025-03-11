package modulo.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

@DisplayName("Testes Web do Módulo de Login")
public class LoginTest {

    private WebDriver navegador;

    @BeforeEach
    // Preparação do Ambiente Web para Iniciar a Automação
    public void beforEach() {

        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Navegar para a página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Teste de Login Válido")
    public void testLoginValido(){
        new LoginPage(navegador)
        .informaUsuario("admin")
        .informaSenha("admin")
        .submeterFormularioDeLogin()
        .acessarFormularioDeAdicaoDeProdutos();
    }

    @Test
    @DisplayName("Teste de Login Usuário Inválido")
    public void testLoginUsuarioInvalido(){
        String apresentarMensagemLoginInvalido = new LoginPage(navegador)
        .informaUsuarioInvalido("add")
        .informaSenha("admin")
        .submeterFormularioDeLogin()
        .apresentarMensagemLoginInvalido();

    Assertions.assertEquals("Falha ao fazer o login", apresentarMensagemLoginInvalido);
    }

    @Test
    @DisplayName("Teste de Login Senha Inválida")
    public void testLoginSenhaInvalida(){
        String apresentarMensagemLoginInvalido = new LoginPage(navegador)
        .informaUsuario("admin")
        .informaSenhaInvalida("ADD")
        .submeterFormularioDeLogin()
        .apresentarMensagemLoginInvalido();


    Assertions.assertEquals("Falha ao fazer o login", apresentarMensagemLoginInvalido);
    }

    @AfterEach
    public void afterEach() {
        // Fechar o Navegador
        navegador.quit();
    }

}
