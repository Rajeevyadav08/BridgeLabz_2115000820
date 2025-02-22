package Feb21;

public class HexColorValidator1 {
    public boolean isValidHexColor(String color) {
        if (color == null) return false;
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }
}
