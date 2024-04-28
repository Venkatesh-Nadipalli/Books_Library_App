package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_Id;
	
	private String book_Name;
	private double book_Price;
	private String activeSW;
	
	
	public Integer getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}
	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public double getBook_Price() {
		return book_Price;
	}
	public void setBook_Price(double book_Price) {
		this.book_Price = book_Price;
	}
	public String getActiveSW() {
		return activeSW;
	}
	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}
	
	
	@Override
	public String toString() {
		return "Book [book_Id=" + book_Id + ", book_Name=" + book_Name + ", book_Price=" + book_Price + ", activeSW="
				+ activeSW + "]";
	}
	
	
	
	
	
}
