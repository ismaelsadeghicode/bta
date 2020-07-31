package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    static Annotation[] annotations;

    /**
     * Does not show Annotation because Annotations are to be discarded by the compiler
     */
    public static void showAnnotationWhenCompile() {
        try {
            annotations = Child.class.getMethod("method3", Integer.class).getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        } catch (NoSuchMethodException e) {
            System.err.println(e);
        }

        try {
            annotations = Child.class.getMethod("method5").getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        } catch (NoSuchMethodException e) {
            System.err.println(e);
        }
        try {
            annotations = Child.class.getMethod("method1").getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        } catch (NoSuchMethodException e) {
            System.err.println(e);
        }
    }

    /**
     * show Annotation because Annotations are to be recorded in the class file by the compiler and retained by the JVM at run time
     */
    public static void showAnnotationRunning() {
        annotations = Parent.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
        try {
            annotations = Child.class.getMethod("method6").getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        } catch (NoSuchMethodException e) {
            System.err.println(e);
        }
    }

    public static void RunMethod() {

        Parent runner = new Parent();
        Method[] methods = runner.getClass().getMethods();
        for (Method method : methods) {
            AnnotationRuntime annos = method.getAnnotation(AnnotationRuntime.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-------Show Annotation source & class------");
        showAnnotationWhenCompile();
        System.out.println("----------Show Annotation runtime----------");
        showAnnotationRunning();
        System.out.println("----------invoke method RunMethod----------");
        RunMethod();
    }
}
