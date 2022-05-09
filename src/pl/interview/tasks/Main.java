package pl.interview.tasks;

public class Main {

    /**
     Created by xciechan
     on 2022-05-08

     The application finds sum of A(n,n) mod 14^8

     A(m,n) = | n+1                 if m=0
              | A(m-1, 1)           if m>0 and n=0
              | A(m-1, A(m, n-1))   if m>0 and n>0
     */

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Sum of A(n,n) for n <0;6> = " + sumOfAckermannFunction(n));

    }

    public static int sumOfAckermannFunction(int n){
        int sumOfAckermannFunction = 0;

        for (int i=0; i<=n; i++){
            sumOfAckermannFunction += AckermannFunction(i, i);
            System.out.println(AckermannFunction(i, i));
        }

        return sumOfAckermannFunction;
    }


    public static int AckermannFunction(int m, int n){
        int resultAckermannFunction = 0;

        if (m == 0) {
            resultAckermannFunction = n + 1;
        } else if (m > 0 && n == 0) {
            resultAckermannFunction = AckermannFunction(m - 1, 1);
        } else {
            resultAckermannFunction = AckermannFunction(m - 1, AckermannFunction(m, n - 1));
        }

        return resultAckermannFunction;
    }

}
