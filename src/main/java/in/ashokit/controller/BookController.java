package in.ashokit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.serviceimpl.BookServiceimpl;

@RestController
public class BookController {
	
	@Autowired
	private BookServiceimpl service;

	
	public BookController(BookServiceimpl service) {
		this.service = service;
	}
	
	
	
	@GetMapping("/index")
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("book",new Book());
		
		mav.setViewName("index");
		
		return mav ;
	}
	
	@GetMapping("/books")
	public ModelAndView getallbooks()
	{
		
		ModelAndView mav = new ModelAndView();
		
	  List<Book> allbooks = service.getAllBooks();
	  
	  mav.addObject("books",allbooks);
	  
	  mav.setViewName("booksView");
	  
		return mav;
	}
	
	@PostMapping("/book")
	public ModelAndView savebook(Book book) {
		
		ModelAndView mav = new ModelAndView();
		
		boolean status=service.saveBook(book);
		
		if(status)
			mav.addObject("sucmsg","Book saved");
		else
			mav.addObject("errmsg","failed to save");
		
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deletebookbyid(@RequestParam("bookId")Integer bookId) {
		
		ModelAndView mav = new ModelAndView();
		
		service.deletebook(bookId);
		
	      List<Book> allbooks = service.getAllBooks();
		  
		  mav.addObject("books",allbooks);
		  
		  mav.setViewName("booksView");
		  
			return mav;
	}
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam("bookId")Integer bookId) {
		
		ModelAndView mav = new ModelAndView();
		
		Book bookobj = service.getbookbyid(bookId);
		
		mav.addObject("book",bookobj);
		
		mav.setViewName("index");
		
		return mav;
	}
	
//	@GetMapping("/search")
//	 public ResponseEntity<List<Book>> searchBooks(@RequestParam("bookName") String bookName) {
//        List<Book> books = service.searchBooksByName(bookName);
//        if (books.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }
	
	
	 @GetMapping("/search")
	    public ResponseEntity<List<Book>> searchAllBooks(@RequestParam(required = false) String bookName,
	                                                  @RequestParam(required = false) Integer bookId,
	                                                  @RequestParam(required = false) Double bookPrice) {
	        List<Book> books = service.searchBooksAll(bookName, bookId, bookPrice);
	        if (books.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(books, HttpStatus.OK);
	    }
}
