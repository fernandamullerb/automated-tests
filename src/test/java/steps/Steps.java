package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import models.Publicacao;

import java.util.Arrays;
import java.util.HashMap;

import static helper.PostHelper.publica;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static helper.GetHelper.*;

public class Steps {

    ResponseOptions<Response> response;

    @Dado("que eu faça uma operação do tipo GET na publicação número {string}")
    public void queEuFacaUmaOperacaoDoTipoGETNaPublicacaoNumero(String idPublicacao) {
        consultaPublicacao(idPublicacao);
    }

    @Então("o nome do autor da publicação deverá ser {string}")
    public void oNomeDoAutorDaPublicacaoDeveraSer(String nomeAutor) {
    }

    @Dado("que eu faça uma operação do tipo GET no endpoint {string}")
    public void queEuFacaUmaOperacaoDoTipoGETNoEndpoint(String url) throws Throwable {
        response = consultaPublicacoes(url);
    }

    @Então("alguma publicação deverá ser do autor {string}")
    public void algumaPublicacaoDeveraSerDoAutor(String nomeAutor) {
        var todasAsPublicacoes = Arrays.stream(response.getBody().as(Publicacao[].class)).toList();
        var publicacaoFiltrada = todasAsPublicacoes.stream()
                .filter(publicacao -> publicacao.getAuthor().equalsIgnoreCase(nomeAutor))
                .findFirst()
                .orElse(null);

        assertThat(publicacaoFiltrada.getAuthor(), is(nomeAutor));
    }

    @Dado("que eu faça uma operação do tipo POST no endpoint de publicações")
    public void queEuFacaUmaOperacaoDoTipoPOSTNoEndpointDePublicacoes() {
        publica();
    }

    @Então("o nome do autor da nova publicação deverá ser {string}")
    public void oNomeDoAutorDaNovaPublicacaoDeveraSer(String nomeAutor) {
    }

    @Dado("que eu faça uma operação do tipo POST no endpoint {string} com o body")
    public void queEuFacaUmaOperacaoDoTipoPOSTNoEndpointComOBody(String url, DataTable table) throws Throwable {
        HashMap<String, String> body = new HashMap<>();
        body.put(table.row(0).get(0), table.row(1).get(0));

        HashMap<String, String> pathParam = new HashMap<>();
        pathParam.put(table.row(0).get(1), table.row(1).get(1));

        response = publica(url, body, pathParam);
    }

    @Então("o nome do novo perfil deverá ser {string}")
    public void oNomeDoNovoPerfilDeveraSer(String nomePerfil) {
        assertThat(response.getBody().jsonPath().get("name"), is(nomePerfil));
    }

}
