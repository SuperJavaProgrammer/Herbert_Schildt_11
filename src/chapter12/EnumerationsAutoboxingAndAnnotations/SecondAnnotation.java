package chapter12.EnumerationsAutoboxingAndAnnotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotationRpt.class)
public @interface SecondAnnotation {
    long value() default 999; //можно устанавливать значение, а можно и нет, тогда будет по умолчанию
}
