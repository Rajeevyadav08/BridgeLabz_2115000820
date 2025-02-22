package Feb21;

public class StringFormatter {
    public String removeExtraSpaces(String text) {
        if (text == null) return null;
        return text.replaceAll("\\s+", " ").trim();
    }
}
