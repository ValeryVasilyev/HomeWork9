
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 18));
        list.add(new Person("Jane", 20));
        list.add(new Person("Mike", 11));

        Map m = Streams.of(list)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getAge() + 30))
                                      .toMap(p -> p.getName(), p -> p);

    }
}
