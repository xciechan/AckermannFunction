package pl.interview.tasks;

import java.math.*;
import java.util.Stack;

public class Main {

    /**
     Created by xciechan
     on 2022-05-09

     The application finds sum of Ackermann Function A(n,n) divided 14^8

     A(m,n) = | n+1                 if m=0          |
              | A(m-1, 1)           if m>0 and n=0  |
              | A(m-1, A(m, n-1))   if m>0 and n>0  |
     */

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Sum of A(n,n) for n <0;6> divided 14^8= " + resultOfAckermannFunction(n));

    }

    public static BigDecimal resultOfAckermannFunction(int n){
        int sumOfAckermannFunction = 0;

        for (int i=0; i<=n; i++){
            sumOfAckermannFunction += AckermannFunction(i,i);
        }

        return resultDivided(sumOfAckermannFunction);
    }

    public static BigDecimal resultDivided(int sumOfAckermannFunction){
        BigDecimal divisor = new BigDecimal("14").pow(8);
        MathContext mathContext = new MathContext(20);

        return BigDecimal.valueOf(sumOfAckermannFunction).divide(divisor,mathContext);
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
