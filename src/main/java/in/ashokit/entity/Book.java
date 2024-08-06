package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(name = "bookName")
	private String bookName;
	
	@Column(name = "bookPrice")
	private double bookPrice;
	
	@Column(name = "activeSW")
	private String activeSW;
	
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getActiveSW() {
		return activeSW;
	}
	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}
	
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", activeSW="
				+ activeSW + "]";
	}
	
	
	
	
	
}
