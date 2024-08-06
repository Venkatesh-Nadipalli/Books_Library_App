package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	public List<Book> findByActiveSW(String status);
	
	//public List<Book> findByBookName(String bookName);
	
	 @Query("SELECT b FROM Book b WHERE (:bookName IS NULL OR b.bookName = :bookName) AND (:bookId IS NULL OR b.bookId = :bookId) AND (:bookPrice IS NULL OR b.bookPrice = :bookPrice)")
	 List<Book> searchBooks(@Param("bookName") String bookName, @Param("bookId") Integer bookId, @Param("bookPrice") Double bookPrice);
}
