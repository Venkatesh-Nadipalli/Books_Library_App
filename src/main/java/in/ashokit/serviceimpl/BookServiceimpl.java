package in.ashokit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepository;
import in.ashokit.service.BookService;

@Service
public class BookServiceimpl implements BookService {

	@Autowired
	private BookRepository bookrepo;
	
	
	public BookServiceimpl(BookRepository bookrepo) {
		this.bookrepo=bookrepo;
	}
	

      

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		
		return bookrepo.findByActiveSW("Y");
	}
	
	@Override
	public boolean saveBook(Book book) {
		
		book.setActiveSW("Y");
		
	Book savedbook	= bookrepo.save(book);
	
	if (savedbook.getBookId()!=null)
		return true;
		return false;
	}

	@Override
	public void deletebook(Integer bookId)
	{
		//bookrepo.deleteById(bookId);
		
	Optional<Book>	findbyid = bookrepo.findById(bookId);
		if(findbyid.isPresent()) {
			Book book = findbyid.get();
			book.setActiveSW("N");
			bookrepo.save(book);
		}
	}
	@Override
	public Book getbookbyid(Integer bookId) {
		
		Optional<Book>	findbyid = bookrepo.findById(bookId);
		if(findbyid.isPresent()) 
			return findbyid.get();
		return null;
	}
	
//	
//	  @Override public List<Book> searchBooksByName(String bookName) { 
//		  return bookrepo.findByBookName(bookName); 
//		  }
	 
	  @Override
	    public List<Book> searchBooksAll(String bookName, Integer bookId, Double bookPrice) {
	        return bookrepo.searchBooks(bookName, bookId, bookPrice);
	    }
}
