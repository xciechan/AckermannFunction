package pl.interview.tasks;

import java.util.Stack;

public class Main {

    /**
     Created by xciechan
     on 2022-05-09

     The application finds sum of A(n,n) mod 14^8

     A(m,n) = | n+1                 if m=0
              | A(m-1, 1)           if m>0 and n=0
              | A(m-1, A(m, n-1))   if m>0 and n>0
     */

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Sum of A(n,n) for n <0;6> = " + sumOfAckermannFunction(n));

    }

    public static int sumOfAckermannFunction(int n){
        int sumOfAckermannFunction = 0;

        for (int i=0; i<=n; i++){
            sumOfAckermannFunction += AckermannFunction(i,i);
        }

        return sumOfAckermannFunction;
    }

    public static int AckermannFunction(int m, int n){
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(m);
        while(!stack.isEmpty()){
            m = stack.pop();

            if(m==0) {
                n += 1;
            }
            else if(n==0) {
                n += 1;
                stack.add(--m);
            }
            else {
                stack.add(--m);
                stack.add(++m);
                n--;
            }
        }
        return n;
    }

}
