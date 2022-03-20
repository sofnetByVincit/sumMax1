package com.company;

import java.util.Scanner;

public class Main {


    static int topToDown(int[][] tri) {
        int length = tri.length;

        int res = -1;
        for (int i = 0; i < length - 2; i++)
            res = Math.max(res, tri[0][i]);

        for (int i = 1; i < length; i++) {
            res = -1;
            for (int j = 0; j < length; j++) {
                if (j == 0 && tri[i][j] != -1) {
                    if (tri[i - 1][j] != -1)
                        tri[i][j] += tri[i - 1][j];
                    else
                        tri[i][j] = -1;
                } else if (j > 0 && j < length - 1 && tri[i][j] != -1) {
                    int tmp = calculatedValue(tri[i - 1][j],
                            tri[i - 1][j - 1]);
                    if (tmp == -1) {
                        tri[i][j] = -1;
                    } else
                        tri[i][j] += tmp;
                } else if (j > 0 && tri[i][j] != -1) {
                    int tmp = calculatedValue(tri[i - 1][j],
                            tri[i - 1][j - 1]);
                    if (tmp == -1) {
                        tri[i][j] = -1;
                    } else
                        tri[i][j] += tmp;
                } else if (j != 0 && j < length - 1 && tri[i][j] != -1) {
                    int tmp = calculatedValue(tri[i - 1][j],
                            tri[i - 1][j - 1]);
                    if (tmp == -1) {
                        tri[i][j] = -1;
                    } else
                        tri[i][j] += tmp;
                }
                res = Math.max(tri[i][j], res);
            }
        }
        return res;
    }

    static int calculatedValue(int input1, int input2)  
    {
        if (input1 == -1 && input2 == -1 || input1 == 0 && input2 == 0)
            return -1;
        else
            return Math.max(input1, input2);
    }

    private static Boolean checkPrime(int number) {
        if ((number & 1) == 0) {
            if (number == 2) {
                return true;
            }
            return false;
        }
        for (var i = 3; (i * i) <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return number != 1;
    }

    private static int[][] deletePrimes(int[][] tri) {
        int length = tri.length;
        for (var i = 0; i < length; i++) {
            for (var j = 0; j < length; j++) {
                if (tri[i][j] == 0) {
                    continue;
                } else if (checkPrime(tri[i][j]))    
                {
                    tri[i][j] = -1;
                }
            }
        }
        return tri;
    }



    public static void main(String[] args) {

        int tri[][] = {{1, 0, 0, 0},
                {8, 4, 0, 0},
                {2, 6, 9, 0},
                {8, 5, 9, 3}};

        System.out.println(" the triangle example");
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j <= i; j++) {

                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }

        int maxSum1 = topToDown(deletePrimes(tri));



        int r = 0;
        int s = 0;
        Scanner scan= new Scanner(System.in);
        System.out.println("the result is "+ maxSum1);
        System.out.println("if you want to enter your own matrix write 1");
         r= scan.nextInt();

        while (s<=0) {
        System.out.println("type the size of matrix 'must be greater than 0'");
        s= scan.nextInt();}
        int tri1 [][] = new int[s][s];

        if (r == 1){
            System.out.println("enter your triangle values");
            for (int i = 0;i < s; i++) {
                for (int j = 0;j <= i;j++) {

                    tri1[i][j]=scan.nextInt();
                }
                System.out.println();
            }
            System.out.println("your triangle values is");
            for (int i = 0;i < s; i++) {
                for (int j = 0;j <= i;j++) {

                    System.out.print( tri1[i][j]+" ");
                }
                System.out.println();
            }

            int maxSum2 = topToDown(deletePrimes(tri1));
            System.out.println("the result is "+ maxSum2);
        }

    }
}
