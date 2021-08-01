package com.jong;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        double firstNumber = 0;
        double secondNumber = 0;
        String whileLoopConditional = null;
        int menuSelection;
        boolean validInput = false;

        System.out.println("Welcome to Calculator.");
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        //whileLoopConditional = scanner.nextLine();

         do
        while (whileLoopConditional != "x") {
            try {
                System.out.println("Please enter the first number:");
                firstNumber = scanner.nextDouble();
                if (firstNumber > 0)
                    validInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Error: input is not an integer or contains non-integer values. Numerical values only allowed.");
                System.out.println();
                scanner.next();
                continue;
            }
            System.out.println("Please enter the second number:");
            secondNumber = scanner.nextDouble();
            //if (firstNumber > 0)
            //    validInput = true;
            // } catch (InputMismatchException e) {
            //   System.out.println("Please enter an integer.");

            System.out.println();
            System.out.println("First number: " + firstNumber);
            System.out.println("Second number: " + secondNumber);
            System.out.println();
            System.out.println("Please choose operation method.");
            System.out.println("1.  Add");
            System.out.println("2.  Subtract");
            System.out.println("3.  Multiply");
            System.out.println("4.  Divide");
            menuSelection = scanner.nextInt();
            switch (menuSelection) {
                case 1:
                    System.out.println("Result: " + firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
                    break;

                case 2:
                    System.out.println("Result: " + firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
                    break;

                case 3:
                    System.out.println("Result: " + firstNumber + " x " + secondNumber + " = " + (firstNumber * secondNumber));
                    break;

                case 4:
                    System.out.println("Result: " + firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));

                    System.out.println();
                    break;
            }
            System.out.println();

            System.out.println("Press \"ENTER\" to continue.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();

        } //while (whileLoopConditional != "x");
        while (validInput) ;

            }
    }





























/*System.out.println("1.  Add");
        System.out.println("2.  Subtract");
        System.out.println("3.  Multiply");
        System.out.println("4.  Divide");
        System.out.println("5.  Exit");*/
