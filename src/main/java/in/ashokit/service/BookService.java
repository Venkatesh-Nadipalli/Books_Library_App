package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;

public interface BookService {

	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public void deletebook(Integer book_Id);
	
	public Book getbookbyid(Integer book_Id);
}
