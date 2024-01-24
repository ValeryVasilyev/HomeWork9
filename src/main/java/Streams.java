import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Streams<T>{
    private Stream<T> stream;

    public Streams(Stream<T> stream){
        this.stream = stream;
    }

    public static <T> Streams of(List<T> list) {
            return new Streams(list.stream());
    }

    public Streams filter(Predicate<? super T> predicate) {
        return new Streams(stream.filter(predicate));
    }

    public Streams transform(Function<? super T, ? extends T> mapper) {
        return new Streams(stream.map(mapper));
    }

    public Map toMap(Function<? super T, ? extends T> keyMapper,
                     Function<? super T, ? extends T> valueMapper) {
        return new HashMap(stream.collect(Collectors.toMap(keyMapper, valueMapper)));
    }

}
