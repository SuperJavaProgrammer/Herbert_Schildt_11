package chapter29.TheStreamAPI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BaseStream baseStream; //interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable
        //void close();
        //boolean isParallel();
        //S parallel();
        //S sequential();
        //S unordered();
        //S onClose(Runnable var1);
        //Iterator<T> iterator();
        //Spliterator<T> spliterator();

        Stream stream; //interface Stream<T> extends BaseStream<T, Stream<T>>
        //void forEach(Consumer<? super T> var1);
        //boolean allMatch(Predicate<? super T> var1); boolean anyMatch(Predicate<? super T> var1); boolean noneMatch(Predicate<? super T> var1);
        //long count();
        //Stream<T> sorted(); Stream<T> sorted(Comparator<? super T> var1);
        //Stream<T> filter(Predicate<? super T> var1);
        //Stream<T> distinct();
        //Stream<T> peek(Consumer<? super T> var1);
        //Stream<T> limit(long var1);
        //Stream<T> skip(long var1);
        //Optional<T> min(Comparator<? super T> var1); Optional<T> max(Comparator<? super T> var1);
        //Optional<T> findFirst(); Optional<T> findAny();
        //<T> Stream<T> ofNullable(T t)
        //Object[] toArray(); <A> A[] toArray(IntFunction<A[]> var1);
        //<R> R collect(Supplier<R> var1, BiConsumer<R, ? super T> var2, BiConsumer<R, R> var3); <R, A> R collect(Collector<? super T, A, R> var1);
        //T reduce(T var1, BinaryOperator<T> var2); Optional<T> reduce(BinaryOperator<T> var1); <U> U reduce(U var1, BiFunction<U, ? super T, U> var2, BinaryOperator<U> var3);
        //<R> Stream<R> map(Function<? super T, ? extends R> var1); IntStream mapToInt(ToIntFunction<? super T> var1); LongStream mapToLong(ToLongFunction<? super T> var1); DoubleStream mapToDouble(ToDoubleFunction<? super T> var1);
        //<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> var1); IntStream flatMapToInt(Function<? super T, ? extends IntStream> var1);
        //default Stream<T> takeWhile(Predicate<? super T> predicate); default Stream<T> dropWhile(Predicate<? super T> predicate)
        //static <T> Stream<T> of(T t);
        //static <T> Stream<T> of(T... values);
        //static <T> Stream<T> empty();
        //static <T> Stream<T> generate(Supplier<? extends T> s);
        //static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b);
        //static <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f);

        DoubleStream doubleStream; //interface DoubleStream extends BaseStream<Double, DoubleStream>
        IntStream intStream; //interface IntStream extends BaseStream<Integer, IntStream>
        LongStream longStream; //interface LongStream extends BaseStream<Long, LongStream>

        List<String> al = List.of("One", "two", "Three", "four", "Five", "six", "Seven", "eight", "Nine", "ten");
        System.out.println("Original al=" + al); //Original al=[One, two, Three, four, Five, six, Seven, eight, Nine, ten]
        System.out.print("Min=");
        Stream<String> sal = al.stream(); //Stream<String> sal = al.stream().sequential().unordered(); //получить поток из List
        Optional<String> min = sal.min(String::compareTo); //минимальное значение в потоке на основе компаратора
        if (min.isPresent()) System.out.print(min.get()); //если есть, то вывести его //Min=Five
        System.out.print("\nMax=");
        Optional<String> max = al.stream().max(String::compareTo);
        max.ifPresent(s -> System.out.print(s + "!")); //аналог как выше //Max=two!
        System.out.print("\nSorted:");
        sal = al.stream().sorted(); //отсортировать
        sal.forEach(System.out::print); //sal.forEachOrdered(System.out::print); //Sorted:FiveNineOneSevenThreeeightfoursixtentwo
        System.out.print("\nLength > 3:");
        sal = al.stream().filter(s -> s.length() > 3); //отфильтровать по длине > 3
        sal.forEach(System.out::print); //ThreefourFiveSeveneightNine
        System.out.print("\nLength > 3 and First letter is big:");
        sal = al.stream().filter(s -> s.length() > 3).filter(s -> Character.isUpperCase(s.charAt(0))); //еще 1 фильтр
        sal.forEach(System.out::print); //ThreeFiveSevenNine
        System.out.print("\nUse reduce 1:");
        Optional<String> red1 = al.stream().reduce((a, b) -> a + a.length() + "," + b); //выполнить действия над объектами потока
        red1.ifPresent(System.out::print); //One3,two8,Three15,four22,Five29,six35,Seven43,eight51,Nine58,ten
        System.out.print("\nUse reduce 2:");
        String red2 = al.stream().reduce("Initial", (a, b) -> a + a.length() + (a.length() % 2 == 0 ? "," : "+") + b.toLowerCase()); //применить изначальное значение
        System.out.println(red2); //Initial7+one12,two18,three26,four33+five40,six46,seven54,eight62,nine69+ten
        System.out.print("\nUse reduce 3:");
        String red3 = al.parallelStream().reduce("A", (a, b) -> a + a.length() + "-" + b, (a, b) -> a + " ! " + b); //
        System.out.println(red3); //A1-One ! A1-two ! A1-Three ! A1-four ! A1-Five ! A1-six ! A1-Seven ! A1-eight ! A1-Nine ! A1-ten
        System.out.print("\nUse map 1:");
        Stream<Integer> si = al.stream().map(String::length); //получить другой поток на основании выполненных действий над объектами потока
        si.forEach(System.out::print); //3354435543
        System.out.print("\nUse map 2:");
        LongStream ls = al.stream().mapToLong(a -> a.charAt(0));
        ls.forEach(a -> System.out.print(a + ", ")); //79, 116, 84, 102, 70, 115, 83, 101, 78, 116,
        System.out.print("\nUse collect to list:");
        Stream<String> str = al.stream();
        List<String> listCol = str.collect(Collectors.toList()); //получить List из потока
        for (String s : listCol)
            System.out.print(s + ", "); //One, two, Three, four, Five, six, Seven, eight, Nine, ten,
        System.out.print("\nUse collect to set:");
        str = al.stream();
        Set<String> setCol = str.collect(Collectors.toSet()); //получить Set из потока
        for (String s : setCol)
            System.out.print(s + ", "); //Five, six, four, One, Nine, Seven, ten, two, Three, eight,
        System.out.print("\nUse iterator:");
        Iterator<String> it = al.stream().iterator(); //получить Iterator из потока
        while (it.hasNext())
            System.out.print(it.next() + ", "); //One, two, Three, four, Five, six, Seven, eight, Nine, ten,
        System.out.print("\nUse spliterator 1:");
        Spliterator<String> spl = al.stream().spliterator(); //получить Spliterator из потока
        while (spl.tryAdvance(a -> System.out.print(a + ", "))); //выполнить действия над объектами в потоке, пока они там есть //One, two, Three, four, Five, six, Seven, eight, Nine, ten,
        System.out.print("\nUse spliterator 2:");
        spl = al.stream().spliterator();
        spl.forEachRemaining(a -> System.out.print(a + ", ")); //выполнить действия над всеми объектами в потоке //One, two, Three, four, Five, six, Seven, eight, Nine, ten,
        System.out.print("\nUse spliterator 3:");
        spl = al.stream().spliterator();
        Spliterator<String> spl2 = spl.trySplit(); //разделить сплитератор на 2 части, чтобы каждый обработал свой объем данных
        if (spl2 != null) {
            System.out.println("\nSpl2:");
            spl2.forEachRemaining(a -> System.out.print(a + ", ")); //One, two, Three, four, Five,
        }
        System.out.println("\nSpl1:");
        spl.forEachRemaining(a -> System.out.print(a + ", ")); //six, Seven, eight, Nine, ten,

        Stream<String> strPar = Arrays.stream(new String[10]); //поток из массива
        Stream<String> strPar1 = new BufferedReader(new FileReader("src/chapter13/IOTryWithResourcesAndOtherTopics/in")).lines(); //поток из потока ввода

    }
}