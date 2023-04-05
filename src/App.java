import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {

    private static List<Content> contents;

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 contents
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://imdb-api.com/en/API/Top250Movies/k_lu8ycn8k";
        ContentExtractor extractor = new ContentExtractorImdb();

        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-20&end_date=2022-06-25";
        // ContentExtractorNasa extractor = new ContentExtractorNasa();

        var http = new ClienteHttp();
        String json = http.getData(url);

        // exibir e manipular os dados 
        List<Content> contents = extractor.contentExtract(json);

        var generator = new PicGenerator();
        // for (Map<String,String> content : contentList) {
        for (int i=0; i<3; i++) {
            Content content = contents.get(i);
            
            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            String fileName = "output/" + content.getTitle() + ".png";

            generator.cria(inputStream,fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}