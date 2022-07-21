import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
  public List<Conteudo> extraiConteudos(String json) {

    // Extrair os dados que interessam (título, poster, classificação)

    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    // Popular a lista de conteúdos
    for (Map<String, String> atributos : listaDeAtributos) {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("url");
      var conteudo = new Conteudo(titulo, urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
