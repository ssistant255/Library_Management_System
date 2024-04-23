package com.library_magagement_system.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library_Magament_system.dao.BookDaoImpl;
import com.library_management_system.pojo.Book;
public class Booktest 
{
	public static void main(String[] args) {
        int id, year, choice;
        String name, author;
        Book b = new Book();
        BookDaoImpl bd = new BookDaoImpl();

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Add Book\n2.Update Book\n3.Delete Book\n4.DisplayBookById\n5.DisplayAllBook\n6.Exit");
            System.out.println("Enter your choice[1-6]");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name");
                    name = sc.next();
                    System.out.println("Enter the author");
                    author = sc.next();
                    System.out.println("Enter the year");
                    year = sc.nextInt();
                    b.setName(name);
                    b.setAuthor(author);
                    b.setYear(year);
                    boolean flag1 = bd.addBook(b);
                    if (flag1 == true) {
                        System.out.println("Book adding successfully");
                    } else {
                        System.out.println("Book not add successfully");
                    }
                    break;

                case 2:
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    System.out.println("Enter the name");
                    name = sc.next();
                    System.out.println("Enter the author");
                    author = sc.next();
                    System.out.println("Enter the year");
                    year = sc.nextInt();
                    b.setName(name);
                    b.setAuthor(author);
                    b.setYear(year);
                    b.setId(id);
                    boolean flag2 = bd.updateBook(b);
                    if (flag2 == true) {
                        System.out.println("Book Update successfully");
                    } else {
                        System.out.println("Book not Update successfully");
                    }
                    break;

                case 3:
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    b.setId(id);
                    boolean flag3 = bd.deleteBook(id);
                    if (flag3 == true) {
                        System.out.println("Book Delete successfully");
                    } else {
                        System.out.println("Book Not Delete successfully");
                    }
                    break;

                case 4:
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    b.setId(id);
                    b = bd.displayBookById(id);
                    System.out.println(b.getId() + " " + b.getName() + " " + b.getAuthor() + " " + b.getYear());
                    break;

                case 5:
                    List<Book> b1 = new ArrayList<Book>();
                    b1 = bd.displayAllBook();
                    for (Book book : b1)
                        System.out.println(book.getId() + " " + book.getName() + " " + book.getAuthor() + " "
                                + book.getYear());
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
            }
        } while (choice < 6);
    }
}