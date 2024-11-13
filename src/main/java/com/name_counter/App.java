package com.name_counter;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        // Ensure a name parameter is provided
        if (args.length < 1) {
            System.out.println("Please provide a name as a parameter.");
            return;
        }

        String name = args[0];
        Random random = new Random();

        for (int i = 1; i <= 15; i++) {
            System.out.println("Hello I am " + name + " and I am printing the number " + i);
            try {
                // Wait a random time between 1 and 5 seconds
                Thread.sleep((1 + random.nextInt(5)) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}