package pl.arkadiuszbicz;

import java.math.BigInteger;
import java.io.*;
import java.util.Arrays;

public class SomeExamples {

    public static void main(String[] args) throws IOException {
        System.out.println(intToBinaryString(12359) + " " + Integer.toBinaryString(12359) + " " + lg(17));
        if ((pow(2, 3) != 8)) throw new AssertionError();
        if ((lg(8) != 3)) throw new AssertionError();
        if ((lg(4) != 2)) throw new AssertionError();
        int[] res = histogram( new int[]{9,1,2,2,3,3,3}, 6);
        System.out.println(Arrays.toString(res));
        if ((FibonacciRec(10) != Fibonacci(10))) throw new AssertionError();
        System.out.println(nSilnia(4));
        //readLinesAndPrint();
    }
    public static void readLinesAndPrint() throws IOException {  //1.1.21
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        if(br != null) {
            do {
                line = br.readLine();
                System.out.println(line);
            } while (line != null);
        }
    }

    public static int nSilnia(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return n * nSilnia(n-1);
    }

    public static int FibonacciRec(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return FibonacciRec(n-1) + FibonacciRec(n-2);
    }
    public static int Fibonacci(int n) {
        int[] fibs = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;
        for(int i =2; i <= n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
            System.out.print(fibs[i] + " ");
        }
        System.out.println(" ");
        return fibs[n];
    }

    public static int[] histogram(int[]a, int m) {
        int[] res = new int[m];
        for(int i=0; i<m; i++) {
            if(a[i] < m)
                res[a[i]] +=  1;
        }
        return res;
    }

    public static int lg(int n) { //1.1.14
        for(int i =0; i < n; i++) {
            if(n < pow(2,i))
                return i-1;
        }
        return 0;
    }

    public static int pow(int base, int multi) {
        int res = 1;
        for(int i =0; i < multi; i++) {
            res *= base;
        }
        return res;
    }

    public static String intToBinaryString(int v) {
        StringBuffer res = new StringBuffer();
        for(int n = v; n > 0; n /= 2) {
            res.append(n%2);
        }
        return res.reverse().toString();
    }

    public static String intToString(int v) {
        StringBuffer res = new StringBuffer();
        while(v > 0) {
            res.append(v % 10);
            v = v / 10;
        }
        return res.reverse().toString();
    }
}
