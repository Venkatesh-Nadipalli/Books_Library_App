package in.ashokit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepository;
import in.ashokit.service.BookService;

@Service
public class BookServiceimpl implements BookService {

	
	private BookRepository bookrepo;
	
	
	
	public BookServiceimpl(BookRepository bookrepo) {
		
		this.bookrepo = bookrepo;
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
	
	if (savedbook.getBook_Id()!=null)
		return true;
		return false;
	}

	@Override
	public void deletebook(Integer book_Id)
	{
		//bookrepo.deleteById(book_Id);
		
	Optional<Book>	findbyid = bookrepo.findById(book_Id);
		if(findbyid.isPresent()) {
			Book book = findbyid.get();
			book.setActiveSW("N");
			bookrepo.save(book);
		}
	}
	public Book getbookbyid(Integer book_Id) {
		
		Optional<Book>	findbyid = bookrepo.findById(book_Id);
		if(findbyid.isPresent()) 
			return findbyid.get();
		return null;
	}
}
