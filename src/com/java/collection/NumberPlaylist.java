package com.java.collection;

import java.io.LineNumberInputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlaylist {
    public static void main(String[] args) {
        //creating collection
        List<Integer> myNumberList = new ArrayList<>();
        for(int i=0; i<5;i++) myNumberList.add(i);

        //traverse
        Iterator itr=myNumberList.iterator();                  //getting the Iterator
        while(itr.hasNext()){
            Integer i = (Integer) itr.next();  //check if iterator has the elements
            System.out.println("mth1: iterator value : "+i);            //printing the element and move to next
        }
        //method2
        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t ){
                System.out.println("mth2: Consume impl Value" +t);
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);
        //method3
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("mthd3: For each anonymus clas value"+ t);
            }
        });
        //method4
        Consumer<Integer> myListAction = n ->{
            System.out.println("mthd4 for eac lamda impl value "+n);
        };
        myNumberList.forEach(myListAction);

        //method5
        myNumberList.forEach(n -> {
            System.out.println("methd5: for each lamda value:"+n);
            });

        //method 6
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n->{
                    System.out.println("mthd6: for each lamda double value::"+
                            toDoubleFunction.apply(n));
                }
                );
        //method7
        Predicate<Integer> isEvenFunction = n -> n>0 && n%2  == 0;
        myNumberList.forEach(n->{
                    System.out.println("mthd7: for each lamda double value::"+n+"check for me "+
                           isEvenFunction.test(n));
                }
        );
        //method 8
        myNumberList.stream().forEach( n -> {
            System.out.println("mthd 8 :stream for each value :: " + n);
        });
        //method 9: process the stream , apply operations and store in result
        List<Double> streamList = myNumberList.stream()
                                   .filter(isEvenFunction)
                                    .map(toDoubleFunction)
                                    .collect(Collectors.toList());
        System.out.println("mthd 9 :Printing double values :: " + streamList);
        //method 10: find first element
        Integer first = myNumberList.stream()
                .filter(isEvenFunction)
                .peek(n -> System.out.println("Peak number is "+ n))
                .findFirst()
               .orElse(null);
        System.out.println("mthd 10 :first even :: " + first);
        //method 11: minimun even number
        Integer min = myNumberList.stream()
                .filter(isEvenFunction)
                .min((n1 , n2) -> n1-n2)
                .orElse(null);
        System.out.println("method 11 :min value  "+ min);
        //method 12
        Integer max = myNumberList.stream()
                .filter(isEvenFunction)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println("mthd12: Max values "+ max);
        //method 13 avg sum
        Integer sum =myNumberList.stream()
                    .reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("mthd13: Avg of " + sum + "/"+count+"="+sum/count);
        //mthd 14 find all even ,singl even or none are divisible by 6
        boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean noneMulofSix = myNumberList.stream().noneMatch();

    }
}