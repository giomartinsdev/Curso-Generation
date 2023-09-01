import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;

public class ForTest {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add("Mazda");

        for (int i = 0; i < cars.toArray().length; i++) {
            System.out.println(i + "-" + cars.get(i));
        }
    }
}
