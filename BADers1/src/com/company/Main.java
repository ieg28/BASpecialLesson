package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void log_print(Object s) {
        System.out.println(s);
    }

    /**
     * 1 den 20 ye kadar sayılar yazdırılacak,
     * yazdırılan sayılardan 3 ile bölüne bilenler altına tekrar yazdırılacak
     * 3 ile bölünenler toplanarak tekrar yazdırılacak.
     */
    public static void firstSample() {
        int count = 20;
        for (int i = 1; i <= count; i++) {
            log_print("i=" + i);
        }

        int total = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 3 == 0) {
                log_print("i%3 = " + i);
                total += i;
            }
        }

        log_print("total = " + total);
        log_print("finish.....");
    }

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public static int sumMultiples3or5(int count, boolean isDebug) {
        int total = 0;
        for (int i = 1; i < count; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                total += i;

                if (isDebug)
                    log_print("i= " + i);
            }
        }

        if (isDebug)
            log_print("total=" + total);

        return total;
    }

    /**
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     */
    public static int sumFibonacci(int limit, boolean isDebug) {
        int total = 0;

        int first = 1;
        int second = 2;
        int third = 0;

        while ((first + second) < limit) {
            third = first + second;
            first = second;
            second = third;

            if (third % 2 == 0)
                total += third;

            if (isDebug)
                log_print(third);
        }

        return total + 2;
    }


    public static void main(String[] args) {
        String header = "Select code: \n" +
                "0: firstSample\n" +
                "1: sumFibonacci\n" +
                "2: sumMultiples3or5\n" +
                "q: exit\n";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (; ; ) {
            System.out.println(header);
            System.out.print("Select mode: ");
            String input = "";
            try {
                input = reader.readLine();

                if (input.equals("q"))
                    break;

                int mode = -1;
                mode = Integer.parseInt(input);

                switch (mode) {
                    case 0: {
                        firstSample();
                        break;
                    }
                    case 1: {
                        System.out.print("Limit: ");
                        String limit = reader.readLine();
                        int lim = Integer.parseInt(limit);
                        sumFibonacci(lim, true);
                        break;
                    }
                    case 2: {
                        System.out.print("Count: ");
                        String count = reader.readLine();
                        int co = Integer.parseInt(count);
                        sumMultiples3or5(co, true);
                        break;
                    }
                    default: {
                        System.out.println("Wrong select mode.!!!!!!");
                        break;
                    }
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
