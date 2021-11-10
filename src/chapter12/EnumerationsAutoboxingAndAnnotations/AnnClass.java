package chapter12.EnumerationsAutoboxingAndAnnotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnotation(str = "ClassStr", val = 100) //аннотация с 2 параметрами
@SecondAnnotation(value = 5000) //вторая аннотация, полная форма
public class AnnClass {

    @MyAnnotation(str = "Str1", val = 10)
    public static void noParam() throws NoSuchMethodException {
        AnnClass annClass = new AnnClass();
        Class<?> cl = annClass.getClass(); //получить класс
        Method method = cl.getMethod("noParam"); //получить метод, может бросить исключение NoSuchMethodException
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class); //получить аннотацию у метода
        System.out.println(myAnnotation.str() + " " + myAnnotation.val()); //Str1 10
    }

    @MyAnnotation(str = "Str2", val = 20)
    public static void haveParam(String s, int i) throws NoSuchMethodException {
        Class<?> cl = AnnClass.class;
        Method method = cl.getMethod("haveParam", String.class, int.class); //получить метод, указать его параметры
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.str() + " " + myAnnotation.val()); //Str2 20
    }

    @SecondAnnotation(500) //которкая форма, если полностью, то value=500
    @SecondAnnotation(1000) //аннотация может повторяться несколько раз
    @MyAnnotation(str = "MethodStr", val = 50)
    public static void twoAnn() throws @MyAnnotation(str = "AnnToException", val = 30) NoSuchMethodException { //аннотация к исключению
        System.out.println("Class Annotations");
        for (Annotation annotation : AnnClass.class.getAnnotations()) //для всех аннотаций класса AnnClass
            System.out.println(annotation); //вывести их
//        @chapter12.EnumerationsAutoboxingAndAnnotations.MyAnnotation(val=100, str="ClassStr")
//        @chapter12.EnumerationsAutoboxingAndAnnotations.SecondAnnotation(value=5000)
        System.out.println("Method Annotations");
        for (Annotation annotation : AnnClass.class.getMethod("twoAnn").getAnnotations()) //для всех аннотаций метода twoAnn
            System.out.println(annotation); //вывести их
//        @chapter12.EnumerationsAutoboxingAndAnnotations.MyAnnotationRpt(value={@chapter12.EnumerationsAutoboxingAndAnnotations.SecondAnnotation(value=500), @chapter12.EnumerationsAutoboxingAndAnnotations.SecondAnnotation(value=1000)})
//        @chapter12.EnumerationsAutoboxingAndAnnotations.MyAnnotation(val=50, str="MethodStr")
    }

    @MarkerAnnotation //маркерная аннотация, без параметров
    public static void markerAnn() throws NoSuchMethodException {
        if (AnnClass.class.getMethod("markerAnn").isAnnotationPresent(MarkerAnnotation.class)) //проверка, присутствует ли у метода markerAnn аннотация MarkerAnnotation
            System.out.println("Have MarkerAnnotation in markerAnn"); //Have MarkerAnnotation in markerAnn
        else
            System.out.println("Don't have MarkerAnnotation in markerAnn");
        if (AnnClass.class.getMethod("noMarkerAnn").isAnnotationPresent(MarkerAnnotation.class))
            System.out.println("Have MarkerAnnotation in noMarkerAnn");
        else
            System.out.println("Don't have MarkerAnnotation in noMarkerAnn"); //Don't have MarkerAnnotation in noMarkerAnn
    }

    public static void noMarkerAnn() {}

}
