package Feb22;

class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

public class api {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();  // This will show a warning
        api.newFeature();
    }
}
