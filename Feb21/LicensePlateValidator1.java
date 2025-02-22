package Feb21;

public class LicensePlateValidator1 {
    public boolean isValidLicensePlate(String plate) {
        if (plate == null) return false;
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }
}
