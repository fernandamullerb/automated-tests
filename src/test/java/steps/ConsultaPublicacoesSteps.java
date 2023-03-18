package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static steps.BDDConsultaPublicacoes.consultaPublicacao;
import static steps.BDDConsultaPublicacoes.consultaPublicacoes;


public class ConsultaPublicacoesSteps {

    @Dado("que eu faça uma consulta na publicação número {string}")
    public void queEuFacaUmaConsultaNaPublicacaoNumero(String idPublicacao) {
        consultaPublicacao(idPublicacao);
    }

    @Então("o nome do autor da publicação deverá ser {string}")
    public void oNomeDoAutorDaPublicacaoDeveraSer(String nomeAutor) {
    }

    @Dado("que eu faça uma consulta na lista de publicações")
    public void queEuFacaUmaConsultaNaListaDePublicacoes() {
        consultaPublicacoes();
    }

    @Então("alguma publicação deverá ser do autor {string}")
    public void algumaPublicacaoDeveraSerDoAutor(String nomeAutor) {
    }
}
