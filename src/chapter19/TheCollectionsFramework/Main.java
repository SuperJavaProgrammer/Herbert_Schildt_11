package chapter19.TheCollectionsFramework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection collection; //interface Collection<E> extends Iterable<E>
        //void clear();
        //boolean isEmpty();
        //boolean add(E var1);
        //boolean addAll(Collection<? extends E> var1);
        //boolean contains(Object var1);
        //boolean containsAll(Collection<?> var1);
        //boolean remove(Object var1);
        //boolean removeAll(Collection<?> var1);
        //boolean retainAll(Collection<?> var1); - true, если вызывающая коллекция содержит в себе var1
        //int size();
        //Iterator<E> iterator();
        //Object[] toArray();
        //default <T> T[] toArray(T[] var1); возвращает массив элементов вызывающей К, заполняется var1 элементами
        //default <T> T[] toArray(IntFunction<T[]> generator); -
        //default boolean removeIf(Predicate<? super E> filter); удяляет из К элементы, удовлетворяющие условию
        //default Spliterator<E> spliterator();
        //default Stream<E> stream();
        //default Stream<E> parallelStream();
        AbstractCollection abstractCollection; //abstract class AbstractCollection<E> implements Collection<E>

        Queue queue; //interface Queue<E> extends Collection<E>
        //boolean add(E var1), E remove() - from Collection
        //boolean offer(E var1); пытается добавить var1 в очередь. true, если успешно
        //E peek(); возвращает элемент из головы очереди. null, если пусто
        //E element(); возвращает элемент из головы очереди. Исключение, если пусто
        //E poll(); возвращает элемент из головы очереди, удаляя его. null, если пусто
        AbstractQueue abstractQueue; //abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E>
        PriorityQueue priorityQueue; //class PriorityQueue<E> extends AbstractQueue<E> implements Serializable
            priorityQueue = new PriorityQueue(); //capacity=11. PriorityQueue(int capacity); PriorityQueue(Comparator<? super E> comp); PriorityQueue(int capacity, Comparator<? super E> comp); PriorityQueue(Collection<? extends E> c); PriorityQueue(PriorityQueue<? extends E> c); PriorityQueue(SortedSet<? extends E> c);

        Deque deque; //interface Deque<E> extends Queue<E>
        //boolean add(E var1); boolean addAll(Collection<? extends E> var1); boolean remove(Object var1); Iterator<E> iterator(); int size(); boolean contains(Object var1); - from Collection
        //boolean offer(E var1); E poll(); E element(); E peek() - from Queue
        //void addFirst(E var1);
        //void addLast(E var1);
        //void push(E var1); добавляет элемент в голову. Исключение, если нет места
        //boolean offerFirst(E var1);
        //boolean offerLast(E var1);
        //boolean removeFirstOccurrence(Object var1);
        //boolean removeLastOccurrence(Object var1);
        //E remove();
        //E removeFirst();
        //E removeLast();
        //E pollFirst();
        //E pollLast();
        //E getFirst();
        //E getLast();
        //E peekFirst();
        //E peekLast();
        //E pop(); возвращает элемент из головы очереди. Исключение, если пусто
        //Iterator<E> descendingIterator(); вернуть обратный итератор
        ArrayDeque arrayDeque; //class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable
            arrayDeque = new ArrayDeque(); //capacity=16. ArrayDeque(int size) ArrayDeque(Collection<? extends E> c)

        List list; //interface List<E> extends Collection<E>
        //int size(); boolean isEmpty(); boolean contains(Object var1); Iterator<E> iterator(); Object[] toArray(); <T> T[] toArray(T[] var1); - from Collection
        //boolean add(E var1); boolean remove(Object var1); containsAll(Collection<?> var1); boolean addAll(Collection<? extends E> var1); - from Collection
        //boolean removeAll(Collection<?> var1); boolean retainAll(Collection<?> var1); void clear(); default Spliterator<E> spliterator(); - from Collection
        //void add(int var1, E var2);
        //boolean addAll(int var1, Collection<? extends E> var2);
        //int indexOf(Object var1);
        //int lastIndexOf(Object var1);
        //E get(int var1);
        //E set(int var1, E var2);
        //E remove(int var1);
        //ListIterator<E> listIterator();
        //ListIterator<E> listIterator(int var1); вохвращает ListIterator, начинающийся с индекса var1
        //List<E> subList(int var1, int var2);
        //default void sort(Comparator<? super E> c);
        //default void replaceAll(UnaryOperator<E> operator); обновляет каждый элемент значением функции
        //static <E> List<E> of(E... elements);
        //static <E> List<E> copyOf(Collection<? extends E> coll)
        AbstractList abstractList; //abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>
        AbstractSequentialList abstractSequentialList; //abstract class AbstractSequentialList<E> extends AbstractList<E>
        LinkedList linkedList; //class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
            linkedList = new LinkedList(); //LinkedList(Collection<? extends E> c)
        ArrayList<String> arrayList; //class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
            arrayList = new ArrayList<>(); //ArrayList(); ArrayList(Collection<? extends E> c); ArrayList(int capacity);
            arrayList.ensureCapacity(100); arrayList.trimToSize();

        Set set; //interface Set<E> extends Collection<E>
        //int size(); boolean isEmpty(); boolean contains(Object var1); Iterator<E> iterator(); Object[] toArray(); <T> T[] toArray(T[] var1); - from Collection
        //boolean add(E var1); boolean remove(Object var1); containsAll(Collection<?> var1); boolean addAll(Collection<? extends E> var1); - from Collection
        //boolean removeAll(Collection<?> var1); boolean retainAll(Collection<?> var1); void clear(); default Spliterator<E> spliterator(); - from Collection
        //static <E> Set<E> of(E... elements);
        //static <E> Set<E> copyOf(Collection<? extends E> coll);
        AbstractSet abstractSet; //abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>
        EnumSet enumSet; //abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable
        HashSet hashSet; //class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable
            hashSet = new HashSet(); //LinkedHashSet the same: HashSet(Collection<? extends E> c); HashSet(int capacity); HashSet(int capacity, float fillRatio); //default capacity=16, load factor=0.75
        LinkedHashSet linkedHashSet; //class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
            linkedHashSet = new LinkedHashSet(); //like HashSet

        SortedSet sortedSet; //interface SortedSet<E> extends Set<E>
        //default Spliterator<E> spliterator() - from Collection
        //E first();
        //E last();
        //SortedSet<E> subSet(E var1, E var2);
        //SortedSet<E> headSet(E var1);
        //SortedSet<E> tailSet(E var1);
        //Comparator<? super E> comparator();

        NavigableSet navigableSet; //interface NavigableSet<E> extends SortedSet<E>
        //Iterator<E> iterator(); - from Collection
        //SortedSet<E> subSet(E var1, E var2); SortedSet<E> headSet(E var1); SortedSet<E> tailSet(E var1); - from SortedSet
        //E lower(E var1); возвращает самый большой элемент е<var1. Если не найден - null
        //E higher(E var1); возвращает самый маленький элемент е>var1
        //E floor(E var1); возвращает самый большой элемент е<=var1
        //E ceiling(E var1); возвращает самый маленький элемент е>=var1
        //E pollFirst(); возвращает первый самый маленький элемент, удаляя его. null, если пусто
        //E pollLast(); возвращает последний самый большой элемент, удаляя его
        //NavigableSet<E> descendingSet(); в обртаном порядке
        //NavigableSet<E> headSet(E var1, boolean var2); вернуть от начала и до var1 (var2 - включая/нет последний элемент)
        //NavigableSet<E> tailSet(E var1, boolean var2); вернуть от var1 и до конца (var2 - включая/нет первый элемент)
        //NavigableSet<E> subSet(E var1, boolean var2, E var3, boolean var4);
        //Iterator<E> descendingIterator();
        TreeSet<String> treeSet; //class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable
            treeSet = new TreeSet<>(); //TreeSet(Collection<? extends E> c); TreeSet(Comparator<? super E> comp); TreeSet(SortedSet<E> ss);

        Iterator<String> iterator; //interface Iterator<E>
        //boolean hasNext();
        //E next();
        //default void remove();
        //default void forEachRemaining(Consumer<? super E> action)

        ListIterator<String> listIterator; //interface ListIterator<E> extends Iterator<E>
        //boolean hasNext(); E next(); void remove(); - from Iterator
        //void set(E var1); присваивает var1 текущему элементу
        //void add(E var1); вставляет var1 в List в начало элемента, что будет возвращен при следующем вызове next
        //boolean hasPrevious();
        //int nextIndex();
        //int previousIndex();
        //E previous();

        arrayList = new ArrayList(List.of("One", "Two", "Three", "Four", "Five"));
        System.out.println("\tInitial with iterator:");
        iterator = arrayList.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println("\n\tInitial with for each:"); //One Two Three Four Five
        for (String s : arrayList)
            System.out.print(s + " ");
        listIterator = arrayList.listIterator(); //One Two Three Four Five
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            listIterator.set(element + "New"); //установить новое значение в последний извлеченный элемент
        }
        System.out.println("\n\tUpdate:");
        iterator = arrayList.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()  + " "); //OneNew TwoNew ThreeNew FourNew FiveNew
        System.out.println("\n\tReverse:");
        while (listIterator.hasPrevious())
            System.out.print(listIterator.previous()  + " "); //FiveNew FourNew ThreeNew TwoNew OneNew

        Spliterator spliterator; //interface Spliterator<T>
        //boolean tryAdvance(Consumer<? super T> var1);
        //int characteristics(); характеристики Spliterator, закодированные в int
        //long estimateSize(); сколько элементов еще осталось перебрать.
        //default void forEachRemaining(Consumer<? super T> action);
        //default Comparator<? super T> getComparator();
        //default long getExactSizeIfKnown(); Spliterator<T> trySplit(); -
        //default boolean hasCharacteristics(int characteristics); true, если у С есть характеристика, переданная по characteristics

        System.out.println("\n\tSpliterator tryAdvance test:");
        spliterator = arrayList.spliterator();
        while (spliterator.tryAdvance(System.out::print)); //(n) -> System.out.print(n) //OneNewTwoNewThreeNewFourNewFiveNew
        System.out.println("\n\tSpliterator forEachRemaining test:");
        spliterator = arrayList.spliterator(); //from the start
        spliterator.forEachRemaining(n -> System.out.print(((String) n).replace("New", "Old") + " ")); //OneOld TwoOld ThreeOld FourOld FiveOld

        RandomAccess randomAccess; //interface RandomAccess. A collection signals that it supports efficient random access to its elements(is implemented by ArrayList)

        Map map; //interface Map<K, V>
        //void clear();
        //void putAll(Map<? extends K, ? extends V> var1);
        //boolean isEmpty();
        //boolean containsKey(Object var1);
        //boolean containsValue(Object var1);
        //int size();
        //V get(Object var1);
        //V put(K var1, V var2);
        //V remove(Object var1);
        //Set<K> keySet();
        //Collection<V> values();
        //Set<Map.Entry<K, V>> entrySet();
        //default void forEach(BiConsumer<? super K, ? super V> action);
        //default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);
        //default boolean remove(Object key, Object value);
        //default boolean replace(K key, V oldValue, V newValue);
        //default V replace(K key, V value);
        //default V putIfAbsent(K key, V value);
        //default V getOrDefault(Object key, V defaultValue);
        //default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction); вызывается remappingFunction, чтобы получить новое значение. Добавляется новая пара К-Ч, если не null, а прошлая пара удаляется. Если null - прошлая пара удаляется, возврат null
        //default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction);
        //default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction);
        //default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction); -
        //static <K, V> Map<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries);
        //static <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map);
        //static <K, V> Map.Entry<K, V> entry(K k, V v);
        AbstractMap abstractMap; //abstract class AbstractMap<K, V> implements Map<K, V> implements most of Map
        EnumMap enumMap; //class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable
            //enumMap = new EnumMap(Class<K> kType); EnumMap(Map<K, ? extends V> m); EnumMap(EnumMap<K, ? extends V> em);
        WeakHashMap weakHashMap; //WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>
        IdentityHashMap identityHashMap; //class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable
            //uses reference equality when comparing elements. is not for general use
        HashMap<String, String> hashMap; //class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable
            hashMap = new HashMap<>(); //capacity 16, fill ratio 0.75. HashMap(Map<? extends K, ? extends V> m); HashMap(int capacity); HashMap(int capacity, float fillRatio)
        LinkedHashMap linkedHashMap; //class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V>
            linkedHashMap = new LinkedHashMap(); //LinkedHashMap(Map<? extends K, ? extends V> m); LinkedHashMap(int capacity); LinkedHashMap(int capacity, float fillRatio); LinkedHashMap(int capacity, float fillRatio, boolean Order);
            //protected boolean removeEldestEntry(Map.Entry<K, V> e)

        Map.Entry mapEntry; //interface Entry<K, V>
        //K getKey();
        //V getValue();
        //V setValue(V var1);
        //static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K, V>> comparingByKey(); -
        //static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K, V>> comparingByValue(); -
        //static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp);
        //static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp);

        SortedMap sortedMap; //interface SortedMap<K, V> extends Map<K, V>
        //Set<K> keySet(); Collection<V> values(); Set<Map.Entry<K, V>> entrySet(); - from Map
        //K firstKey();
        //K lastKey();
        //SortedMap<K, V> headMap(K var1);
        //SortedMap<K, V> tailMap(K var1);
        //SortedMap<K, V> subMap(K var1, K var2);
        //Comparator<? super K> comparator();

        NavigableMap navigableMap; //interface NavigableMap<K, V> extends SortedMap<K, V>
        //SortedMap<K, V> subMap(K var1, K var2); SortedMap<K, V> headMap(K var1); SortedMap<K, V> tailMap(K var1); - from SortedMap
        //K lowerKey(K var1);
        //K higherKey(K var1);
        //K floorKey(K var1);
        //K ceilingKey(K var1);
        //NavigableSet<K> navigableKeySet();
        //NavigableSet<K> descendingKeySet();
        //Map.Entry<K, V> lowerEntry(K var1);
        //Map.Entry<K, V> higherEntry(K var1);
        //Map.Entry<K, V> floorEntry(K var1);
        //Map.Entry<K, V> ceilingEntry(K var1);
        //Map.Entry<K, V> firstEntry();
        //Map.Entry<K, V> lastEntry();
        //Map.Entry<K, V> pollFirstEntry();
        //Map.Entry<K, V> pollLastEntry();
        //NavigableMap<K, V> descendingMap();
        //NavigableMap<K, V> headMap(K var1, boolean var2);
        //NavigableMap<K, V> tailMap(K var1, boolean var2);
        //NavigableMap<K, V> subMap(K var1, boolean var2, K var3, boolean var4);
        TreeMap treeMap; //TreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable
            treeMap = new TreeMap(); //TreeMap(Comparator<? super K> comp); TreeMap(Map<? extends K, ? extends V> m); TreeMap(SortedMap<K, ? extends V> sm);

        hashMap = new HashMap(Map.of("OneK", "OneV", "TwoK", "TwoV", "ThreeK", "ThreeV", "FourK", "FourV", "FiveK", "FiveV"));
        System.out.println("\n\tentrySet");
        for (Map.Entry me : hashMap.entrySet()) //извлечь все пары К-З
            System.out.print("K=" + me.getKey() + ",V=" + me.getValue() + "; "); //K=TwoK,V=TwoV; K=OneK,V=OneV; K=ThreeK,V=ThreeV; K=FiveK,V=FiveV; K=FourK,V=FourV;
        System.out.println("\n\tkeySet");
        for (String k : hashMap.keySet()) //извлечь все Ключи
            System.out.print(k + " "); //TwoK OneK ThreeK FiveK FourK
        System.out.println("\n\tvalues");
        for (String v : hashMap.values()) //извлечь все Значения
            System.out.print(v + " "); //TwoV OneV ThreeV FiveV FourV

        Comparator comparator; //interface Comparator<T>
        //boolean equals(Object var1);
        //int compare(T var1, T var2); -
        //default Comparator<T> reversed();
        //default Comparator<T> thenComparing(Comparator<? super T> other)
        //default Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) //and for Long, Double -
        //default <U> Comparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, Comparator<? super U> keyComparator) -
        //static <T> Comparator<T> nullsFirst(Comparator<? super T> comp);
        //static <T> Comparator<T> nullsLast(Comparator<? super T> comp)
        //static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) //and for Long, Double -
        //static <T extends Comparable<? super T>> Comparator<T> reverseOrder(); -
        //static <T extends Comparable<? super T>> Comparator<T> naturalOrder(); -

        treeSet = new TreeSet<>(new MyComparator()); //создание treeSet с сортировкой по MyComparator
//        treeSet = new TreeSet<>(new MyComparator().reversed().thenComparing((s, t) -> (s.charAt(1) + "").compareTo(t.charAt(1) + "")));
        treeSet.add("adfg");
        treeSet.add("bbfg");
        treeSet.add("cafg");
        treeSet.add("dcfg");
        treeSet.add("eefg");
        System.out.println("\n\tUse my comparator:");
        for (String s : treeSet)
            System.out.print(s + " "); //cafg bbfg dcfg adfg eefg

        Collections collections; //class Collections
        //void reverse(List<?> list)
        //void shuffle(List<?> list)
        //void swap(List<?> list, int i, int j) меняет элементы местами
        //boolean disjoint(Collection<?> c1, Collection<?> c2) true, если c1 и c2 не содержат одинаковых элементов
        //int frequency(Collection<?> c, Object o) число совпадений o в c
        //<T> void sort(List<T> list, Comparator<? super T> c)
        //<T> void fill(List<? super T> list, T obj)
        //<T> void copy(List<? super T> dest, List<? extends T> src)
        //<T> boolean addAll(Collection<? super T> c, T... elements)
        //<T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
        //<T> Collection<T> synchronizedCollection(Collection<T> c) //All возвращает потокобезопасную К
        //<T> Collection<T> unmodifiableCollection(Collection<? extends T> c) //All возвращает неизменяемую К
        //<E> Collection<E> checkedCollection(Collection<E> c, Class<E> type) //checkedList/Map/Queue возвращает типобезопасную коллекцию. Исключение, если вставить несовместимый элемент
        //<T> List<T> emptyList() //And other возвращает неизменяемый, пустой List<T>
        //<T> Set<T> singleton(T o) //+Map/List возвращает o как неизменяемый Set. Простой способ превратить один объект в Set
        //<T> Enumeration<T> enumeration(final Collection<T> c)
        //<T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
        //<T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)

        Arrays arrays; //class Arrays
        //void fill(int[] a, int val);
        //void sort(int[] a);
        //void parallelSort(int[] a);
        //void parallelPrefix(int[] array, IntBinaryOperator op); -
        //void setAll(int[] array, IntUnaryOperator generator); -
        //void parallelSetAll(int[] array, IntUnaryOperator generator) -
        //boolean deepEquals(Object[] a1, Object[] a2)
        //String deepToString(Object[] a)
        //int compare(int[] a, int[] b); -
        //int compareUnsigned(int[] a, int[] b); -
        //int mismatch(int[] a, int[] b); -
        //int binarySearch(long[] a, long key);
        //int[] copyOf(int[] original, int newLength) -
        //int[] copyOfRange(int[] original, int from, int to);
        //OfInt spliterator(int[] array) -
        //IntStream stream(int[] array);
        //<T> List<T> asList(T... a);

        Enumeration enumeration; //interface Enumeration<E> //superseded by Iterator
        //boolean hasMoreElements();
        //E nextElement();
        //default Iterator<E> asIterator()

        Dictionary dictionary; //abstract class Dictionary<K, V> //similar to Map
        //boolean isEmpty();
        //int size();
        //V get(Object var1);
        //V put(K var1, V var2);
        //V remove(Object var1);
        //Enumeration<K> keys();
        //Enumeration<V> elements();
        Hashtable hashtable; //class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable //similar to HashMap
            hashtable = new Hashtable(); //size 11, fill ratio 0.75. Hashtable(int size); Hashtable(int size, float fillRatio); Hashtable(Map<? extends K, ? extends V> m);
        Properties properties; //class Properties extends Hashtable<Object, Object>
            properties = new Properties(); //Properties(Properties propDefault); Properties(int capacity);

        Vector vector; //class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable //similar to ArrayList
            vector = new Vector(); //size 10. Vector(int size); Vector(int size, int incr); Vector(Collection<? extends E> c);
        Stack stack; //class Stack<E> extends Vector<E> //similar to ArrayDeque
            stack = new Stack();
    }
}