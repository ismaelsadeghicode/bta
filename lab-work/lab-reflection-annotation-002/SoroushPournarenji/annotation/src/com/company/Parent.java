package com.company;

@Deprecated
public class Parent {

    @AnnotaionClass
    public void method1(){
        System.out.println("invoke method1");
    }

    @AnnotationRuntime
    public void method2(){
        System.out.println("invoke method2");
    }


    public void method3(Integer i){
        System.out.println("invoke method3");
    }

    @AnnotationRuntime
    public void method4(){
        System.out.println("invoke method4");
    }

    @AnnotaionSource
    public void method5(){
        System.out.println("invoke method5");
    }

    @AnnotationRuntime
    public void method6(){
        System.out.println("invoke method6");
    }

}
