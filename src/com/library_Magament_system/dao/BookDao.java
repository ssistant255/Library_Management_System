package com.library_Magament_system.dao;
import java.util.List;

import com.library_management_system.pojo.Book;
public interface BookDao 
{
	boolean addBook(Book b);
	boolean updateBook(Book b);
	boolean deleteBook(int id);
	Book  displayBookById(int id);
	List<Book>displayAllBook();
}
