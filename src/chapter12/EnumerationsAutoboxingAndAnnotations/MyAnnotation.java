package chapter12.EnumerationsAutoboxingAndAnnotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //specifies the retention policy: SOURCE, CLASS(default), RUNTIME
@Documented //an annotation is to be documented
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER}) //specifies the types of items to which an annotation can be applied. If no - any
@Inherited //causes the annotation for a superclass to be inherited by a subclass
//@Override @Deprecated @FunctionalInterface @SafeVarargs @SuppressWarnings
public @interface MyAnnotation {
    String str() default "Hello world";
    int val() default -1;
}
