package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public void deletebook(Integer bookId);
	
	public Book getbookbyid(Integer bookId);
	
	// public List<Book> searchBooksByName(String bookName);
	 
	 public List<Book> searchBooksAll(String bookName, Integer bookId, Double bookPrice);
}
