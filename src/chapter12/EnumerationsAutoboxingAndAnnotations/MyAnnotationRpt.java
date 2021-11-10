package chapter12.EnumerationsAutoboxingAndAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationRpt { //container annotation
    SecondAnnotation[] value();
}
