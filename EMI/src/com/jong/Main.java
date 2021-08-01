package com.jong;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;


public class Main {
    public static void main(String[] args) {

        int principal;
        double rateInterest;
        int numberMonthly;
        int emi;
        double dividend;
        double divisor;
        boolean validInput;
        String whileLoopCondition = null;



        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Loan EMI Calculator.");
        System.out.println();



        while (whileLoopCondition != "x") {

            System.out.println("Please enter the loan currency type  (e.g. dollars, euros, yen)");
            //System.out.println(" Tip: this step is not necessary, it is ok to leave blank ");
            String currency = sc.next();


            System.out.println();
            System.out.println("Please enter the principal amount of the loan.");
            principal = sc.nextInt();
            //try {


            System.out.println("Please enter the monthly rate of interest.");
            //System.out.println("Tip: if you have annual interest amount, please don't forget to divide that value by 12 first in order to get the monthly rate");
            rateInterest = sc.nextDouble();


            System.out.println("Please enter the number of monthly installments.");
            numberMonthly = sc.nextInt();

            //System.out.println("Please enter the currency type  e.g. dollars, euros, yen");
            //String currency = sc.nextLine();

            double i = (double) Math.pow(1 + rateInterest, numberMonthly);

            //int perAnnumInterest = (int) (rateInterest*1200);


            dividend = (principal * rateInterest * (i));
            divisor = i - 1;
            emi = (int) (dividend / divisor);
            System.out.println();
            System.out.println("Success! Here is a summary of your loan: ");

            for (String s : Arrays.asList("Loan amount: " + principal + " " + currency + "   ------  Per Annum Interest Rate: " + rateInterest * 1200 +
                    " % " + "   ------  Loan Tenure: " + numberMonthly / 12 + "" + " Years", "Your Loan EMI is: " + emi + " " + currency)) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println("Press \"Enter\" to calculate a new EMI.");
            Scanner enterkey = new Scanner(System.in);
            enterkey.nextLine();


        }
        System.out.println("goodbye");
                }
            }



            // continue;



        //whileLoopCondition = "x";
        //System.out.println("Goodbye");





