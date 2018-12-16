package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * Derste yapılan uygulamaya benzer bir uygulama yazılacak:
     * 3 farklı seçeneği olacak.
     * 1. kullanıcıdan bir değer alınacak ve alınan değerin faktöriyel hesabı yapılacak. (5! == 120) 5.4.3.2.1 = 120
     * 2. kullanıcıdan bir değer alınacak ve alınan değerin tek mi çift mi olduğu ekrana yazdırılacak.
     * 3. kullanıcıdan iki değer alınacak
     * ilk değer sayı olacak:
     * ikinci değer isim olacak:
     * ve girilen değer kadar ekrana hoşgeldiniz ....(girilen isim) yazdırılacak.
     */

    public static void main(String[] args) {
        String header = "Question: \n" +
                "1: Factorial\n" +
                "2: Even or Odd\n" +
                "3: Read name\n" +
                "q: exit";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (; ; ) {
            try {
                System.out.println(header);
                System.out.print("Select q: ");
                String selectStr = reader.readLine();

                if (selectStr.equals("q"))
                    break;

                int select = Integer.parseInt(selectStr);
                switch (select) {
                    case 1: {
                        System.out.print("input number: ");
                        String numberStr = reader.readLine();
                        int number = Integer.parseInt(numberStr);

                        int total = 1;
                        for (int i = 1; i <= number; i++)
                            total *= i;

                        System.out.println("Result " + numberStr + "! = " + total);
                        break;
                    }
                    case 2: {
                        System.out.print("input number: ");
                        String numberStr = reader.readLine();
                        int number = Integer.parseInt(numberStr);

                        if (number % 2 == 0)
                            System.out.println("Result " + numberStr + " ==> even");
                        else
                            System.out.println("Result " + numberStr + " ==> odd");

                        break;
                    }
                    case 3: {
                        System.out.print("input number: ");
                        String numberStr = reader.readLine();
                        int number = Integer.parseInt(numberStr);

                        System.out.print("input name: ");
                        String name = reader.readLine();

                        for (int i = 0; i < number; i++)
                            System.out.println((i + 1) + ". Welcome " + name);

                        break;
                    }
                }
                System.out.println("\n\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
