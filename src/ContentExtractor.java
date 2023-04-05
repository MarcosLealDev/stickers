import java.util.List;

public interface ContentExtractor {
  List<Content> contentExtract(String json);
}
