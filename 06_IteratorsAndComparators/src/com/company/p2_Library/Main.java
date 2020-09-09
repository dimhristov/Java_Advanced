package com.company.p2_Library;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);


        Book[] books = {bookOne, bookTwo, bookThree};
        Library library = new Library(books);

        for (Book o : library) {

        }

        for (Book book : books) {
            System.out.println(book.getTitle());
        }

    }
}
