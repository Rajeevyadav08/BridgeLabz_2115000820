package Feb21;

public class SpaceNormalizer {
    public String normalizeSpaces(String text) {
        if (text == null) {
            return null;
        }
        return text.replaceAll("\\s+", " ").trim();
    }
}
