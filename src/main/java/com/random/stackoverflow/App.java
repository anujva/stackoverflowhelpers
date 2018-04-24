package com.random.stackoverflow;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println(genNextPrime(12));
    }

    public static int genNextPrime(int num) {
        if (num % 2 == 0) {
            num = genNextPrime(++num);
        } else {
            for (int i = 3; i < (num + 1) / 2; i += 2) {
                if (num % i == 0) {
                    num += 2;
                    num = genNextPrime(num);
                }
            }
        }
        return num;
    }
}
