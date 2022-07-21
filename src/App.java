import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Extratores

        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // ExtratorConteudo extrator = new ExtratorConteudoIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-15&end_date=2022-06-19";
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var maker = new StickerMaker();
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "stickers/" + conteudo.getTitulo() + ".png";
            maker.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
