package Feb22;

import java.util.ArrayList;

public class Suppress{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics used
        list.add("Hello");
        list.add(123); 

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
