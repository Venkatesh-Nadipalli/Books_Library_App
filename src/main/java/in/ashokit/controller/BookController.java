package in.ashokit.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.service.BookService;

@Controller
public class BookController {
	
	
	private BookService service;


	public BookController(BookService service) {
	
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
	public ModelAndView deletebookbyid(@RequestParam("book_Id")Integer book_Id) {
		
		ModelAndView mav = new ModelAndView();
		
		service.deletebook(book_Id);
		
	      List<Book> allbooks = service.getAllBooks();
		  
		  mav.addObject("books",allbooks);
		  
		  mav.setViewName("booksView");
		  
			return mav;
	}
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam("book_Id")Integer book_Id) {
		
		ModelAndView mav = new ModelAndView();
		
		Book bookobj = service.getbookbyid(book_Id);
		
		mav.addObject("book",bookobj);
		
		mav.setViewName("index");
		
		return mav;
	}
}
