package chapter12.EnumerationsAutoboxingAndAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MarkerAnnotation { //маркерная аннотация, ничего в себе не содержит, просто как маркер
}
