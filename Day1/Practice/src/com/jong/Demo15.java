package com.jong;

class Book{
    public String title;
    public String author;
    public int price;
    public void printInfo(){
        System.out.println("Book: Title=" + title + ", Author=" + author + ", " +
                "Price=" + price);
                }
}

public class Demo15 {

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java";
        book1.author = "Smart guy";
        book1.price = 28;

        book1.printInfo();



    }
}
