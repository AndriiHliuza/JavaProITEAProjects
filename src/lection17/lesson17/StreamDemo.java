package lection17.lesson17;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.*;

public class StreamDemo {


    static List<Integer> ints = new ArrayList<>();
    public static void main(String[] args) {
        var list = Arrays.stream(args)
                .filter(s -> s.length() <= 2)
                .collect(Collectors.toList());

        System.out.println(list);

        Arrays.stream(args)
                .filter(s -> s.length() <= 2)
                .forEach(System.out::println);

        System.out.println("-------------");

        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(StreamDemo::hello);


        List<Integer> integers = List.of(2, 4, 5, 6, 7);


        Stream<Integer> stream = integers.stream();
        stream.forEach(System.out::println);
        System.out.println("------------");
        System.out.println(IntStream.range(0, 5)
                .parallel()
                .map(x -> x * 10)
                .sum());


        System.out.println("----------------------------------");


        Collection<Integer> collection = Collections.synchronizedCollection(ints);

        IntStream.range(0, 1_000_000)
                .parallel()
                .forEach(i -> collection.add(i));
        System.out.println(collection.size());

        System.out.println(ints.get(0));
        System.out.println(ints.get(1));
        System.out.println(ints.get(2));
        System.out.println(ints.get(3));

        var empty = Stream.empty();

        Stream<String> stream1 = Stream.empty();

        Arrays.asList(1, 2, 3).stream().forEach(System.out::println);

        String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        Stream.ofNullable(null).forEach(System.out::println);

        Stream.generate(() -> 6)
                .limit(6)
                .forEach(System.out::println);

        System.out.println("-------------");
        Stream.iterate(2, x -> x < 25, x -> x + 6)
                .forEach(System.out::println);

        System.out.println("-------------");
        Stream<Integer> streamBuilder = Stream.<Integer>builder()
                .add(0)
                .add(1)
                .build();
        streamBuilder.forEach(System.out::println);

        final int[] b = new int[1_000_000];

        System.out.println("------------------");

        IntStream.range(0, 1_000_000).parallel().forEach(i -> b[i] = i);
        System.out.println(b.length);

        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);

        System.out.println("-----------------");

        Stream.of(0, 3, 1, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d\n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d\n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d\n", x));

        System.out.println("-------------------");


        DoubleStream.of(0.1, Math.PI)
                .boxed()
                .map(Object::getClass)
                .forEach(System.out::println);

        System.out.println("------------");

        IntStream.of(3, 1, 7, 5, 9, 23, 65, 12, 4)
                .parallel()
                .sorted()
                .forEachOrdered(System.out::println);

        System.out.println("-------------");
        System.out.println(Stream.of(0, 2, 9, 13, 5, 11)
                .map(x -> x * 2)
                .filter(x -> x % 2 == 1)
                .count());

        System.out.println("--------------");
        int a = 0;
        System.out.println("a = " + (a++ % 4));
        IntStream.range(0, 10)
                .filter(x -> x++ % 4 == 0)
                .forEach(System.out::println);

        System.out.println("-------------");

        Map<Character, String> map2 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println(map2);

        List<Integer> list2 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));

        System.out.println(list2.getClass());
        System.out.println(new ArrayList<>().getClass());

        System.out.println("---------------");

        Stream<Map.Entry<String, String>> list3 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), s -> s + s),
                        map -> map.entrySet().stream()
                ));

//        list3.map(e -> e.toString()).forEach(System.out::println);
        List<String> list4 = list3.map(e -> e.toString())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        list4.forEach(System.out::println);
        System.out.println(list4);
        String str2 = list4.get(1);
        System.out.println(str2);
//                .map(e -> e.toString())
//                .collect(Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        Collections::unmodifiableList
//                ));
        System.out.println("----------------");
        String s1 = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(Collectors.filtering(
                        x -> x % 2 == 0,
                        Collectors.mapping(
                                x -> Integer.toString(x),
                                Collectors.joining("-")
                        )
                ));
        System.out.println(s1);


        System.out.println("---------------");

        final Set<Integer> elements = new HashSet<>();
        Map<Boolean, List<Integer>> k = Stream.of(1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2)
                .collect(Collectors.partitioningBy(elements::add));

        System.out.println(elements);

        System.out.println(k);

        System.out.println("<---------------------->");
        Map<Boolean, List<Integer>> map;
        map = Stream.of(2, 1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2)
                .parallel()
                .collect(partitioningByUniqueness());
        System.out.println(map);

        System.out.println("<<---------------------->>");
        Stream.of(1, 2, 3, 1, 9, 2, 5, 3, 4, 8, 2)
                .map(String::valueOf)
                .collect(partitioningByUniqueness2(Collectors.joining("-")))
                .forEach((isUnique, str1) -> System.out.format("%s: %s\n", isUnique ? "unique" : "repetitive", str1));
    }

    public static void hello(int myValue) {
        System.out.println(myValue);
    }


    public static <T> Collector<T, ?, Map<Boolean, List<T>>> partitioningByUniqueness() {
        return Collector.<T, Map.Entry<List<T>, Set<T>>, Map<Boolean, List<T>>>of(
                () -> new AbstractMap.SimpleImmutableEntry<>(
                        new ArrayList<T>(), new LinkedHashSet<>()
                ),
                (c, e) -> {
                    if (!c.getValue().add(e)) {
                        c.getKey().add(e);
                    }
                },
                (c1, c2) -> {
                    c1.getKey().addAll(c2.getKey());
                    for (T e : c2.getValue()) {
                        if (!c1.getValue().add(e)) {
                            c1.getKey().add(e);
                        }
                    }
                    return c1;
                },
                c -> {
                    Map<Boolean, List<T>> result = new HashMap<>(2);
                    result.put(Boolean.FALSE, c.getKey());
                    result.put(Boolean.TRUE, new ArrayList<>(c.getValue()));
                    return result;
                }
        );
    }

    public static <T, D, A> Collector<T, ?, Map<Boolean, D>> partitioningByUniqueness2(
            Collector<? super T, A, D> downstream
    ) {
        class Holder<A, B> {
            final A unique, repetitive;
            final B set;
            Holder(A unique, A repetitive, B set) {
                this.unique = unique;
                this.repetitive = repetitive;
                this.set = set;
            }
        }

        BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
        BinaryOperator<A> downstreamCombiner = downstream.combiner();
        BiConsumer<Holder<A, Set<T>>, T> accumulator = (t, element) -> {
            A container = t.set.add(element) ? t.unique : t.repetitive;
            downstreamAccumulator.accept(container, element);
        };

        return Collector.<T, Holder<A, Set<T>>, Map<Boolean, D>>of(
                () -> new Holder<>(
                        downstream.supplier().get(),
                        downstream.supplier().get(),
                        new HashSet<>()
                ),
                accumulator,
                (t1, t2) -> {
                    downstreamCombiner.apply(t1.repetitive, t2.repetitive);
                    t2.set.forEach(e -> accumulator.accept(t1, e));
                    return t1;
                },
                t -> {
                    Map<Boolean, D> result = new HashMap<>(2);
                    result.put(Boolean.FALSE, downstream.finisher().apply(t.repetitive));
                    result.put(Boolean.TRUE, downstream.finisher().apply(t.unique));
                    t.set.clear();
                    return result;
                }
        );
    }
}
