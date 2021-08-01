package com.jong;

public class Demo22 {
    public static void main(String[] args) {
        //case1 : exception not occur
        try {
            int c = 10/5;
            System.out.println(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("case1 finally called");
        }
        //case2 exception unhandled
        try {
            int c = 20/0;
            System.out.println(c);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("case2 finally called oh thank goodness");
        }
    }
}
