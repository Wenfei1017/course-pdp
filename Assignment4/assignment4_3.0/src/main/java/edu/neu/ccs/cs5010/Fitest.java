package edu.neu.ccs.cs5010;

public class Fitest {
    public static int getFi(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        } else {
            return getFi(n-1) + getFi(n-2);
        }
    }

    public static void main(String[] args) {
        //Fitest test = new Fitest();
        for (int i = 1; i < 10; i++) {
            System.out.println(getFi(i));
        }
    }
}
