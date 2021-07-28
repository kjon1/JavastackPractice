package com.jong;

class BookA {
    private String title;
    private String author;
    private int price;

    public BookA(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;

    }
    public void printInfo(){
        System.out.println("Book: Title=" + title + ", Author=" + author + ", Price="
                + price);

    }
}

public class Demo17 {
    public static void main(String[] args) {
        BookA ba = new BookA("JAVA FOR DUMMIE", "VERY SMART GUY", 200);
        ba.printInfo();


    }
}
