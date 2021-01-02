package com.java.collection;

public class MathOperation {
    @FunctionalInterface
    interface IMathFunction{
        int calculate(int a,int b);
        //use case 2
        static void printResult(int a , int b ,String function,IMathFunction fobj){
            System.out.println("Result of "+function+ " is "+fobj.calculate(a,b));
        }
    }

    public static void main(String[] args) {
        IMathFunction add = (int a,int b)->a+b;
        IMathFunction subtract = (int a,int b)->a-b;
        IMathFunction multiply = (int a,int b)->a*b;
        IMathFunction divison = (int a,int b)->a/b;

        //use case 2 output
        IMathFunction.printResult(6,3,"Addition",add);
        IMathFunction.printResult(6,3,"Subtract",subtract);
        IMathFunction.printResult(6,3,"Multiply",multiply);
        IMathFunction.printResult(6,3,"Division",divison);
    }

}
