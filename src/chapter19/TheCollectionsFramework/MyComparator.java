package chapter19.TheCollectionsFramework;

import java.util.Comparator;

public class MyComparator implements Comparator<String> { //своя реализация компаратора
    @Override
    public int compare(String s, String t1) {
        return (s.charAt(1) + "").compareTo(t1.charAt(1) + ""); //сравнивание по размеру второго символа
    }
}
