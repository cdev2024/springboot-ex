import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = list.stream();

        Stream<String> builderSream = Stream.<String>builder()
                .add("a").add("b").add("c")
                .build();

        Stream<String> stream2 = Stream.generate(()->"a").limit(3);

        Stream<Integer> stream3 = Stream.iterate(0, n->n+2).limit(5); // 0, 2, 4, 6, 8

        // 스트림 생성 후 각 요소를 콘솔에 출력
        stream1.forEach(System.out::print);
        list.stream().map(String::toUpperCase)
                .forEach(System.out::print);

        List<String> members = Arrays.asList("Lee", "Park", "Hwang");

        //matching
        boolean result = members.stream()
                        .anyMatch(member->member.contains("w"));
        System.out.println(result);

        result = members.stream()
                        .allMatch(member->member.length() >= 4);
        System.out.println(result);

        members.stream()
                .findAny(); // 먼저 찾은 요소하나
             //   .findFirst() // 첫번째 요소 반환

    }
}
