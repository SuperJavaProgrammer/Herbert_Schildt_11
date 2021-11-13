package chapter15.LambdaExpressions;

public interface FuncIntGeneric<T> { //конструктор с обобщенным параметром
    T getNum(T param) throws Exception; //метод может выбросить исключение
}
