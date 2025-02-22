package Feb21;

public class IPv4Validator {
    public boolean isValidIPv4(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        
        for (String part : parts) {
            if (!part.matches("\\d+")) return false; // Ensure it's numeric
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false; // Must be in range 0-255
            if (part.length() > 1 && part.startsWith("0")) return false; // No leading zeros
        }
        
        return true;
    }
}
