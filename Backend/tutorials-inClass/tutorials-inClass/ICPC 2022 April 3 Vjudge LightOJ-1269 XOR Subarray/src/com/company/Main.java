package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();
        for (int i = 0; i < numCases; i++) {

            //get input array
            int length = scan.nextInt();
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = scan.nextInt();
            }

            //get cumulative array
            int[] cumulative = new int[array.length];
            cumulative[0] = array[0];
            for (int j = 1; j < cumulative.length; j++) {
                cumulative[j] = cumulative[j-1] ^ array[j];
            }

            //find max/min subarray
            int max = cumulative[0];
            int min = cumulative[0];
            for (int left = 0; left < cumulative.length; left++) {
                for (int right = left; right < cumulative.length; right++) {
                    int candidate = cumulative[right];
                    if (left > 0) {
                        candidate = candidate ^ cumulative[left - 1];
                    }
                    if (candidate > max) {
                        max = candidate;
                    }
                    if (candidate < min) {
                        min = candidate;
                    }
                }
            }

            System.out.println("Case " + (i + 1) + ": " + max + " " + min);

        }

    }
}
