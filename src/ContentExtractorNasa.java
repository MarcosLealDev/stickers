import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorNasa implements ContentExtractor {
  public List<Content> contentExtract(String json) {
    // extrair só os dados que interessam (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Content> contents = new ArrayList<>();

    // fill list of contents
    for (Map<String, String> attributos : listaDeAtributos) {
      String title = attributos.get("title");
      String urlImagem = attributos.get("url");

      var content = new Content(title, urlImagem);
      contents.add(content);
    }

    return contents;
  }
}
