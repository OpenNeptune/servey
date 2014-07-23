package app.model;

import lombok.Getter;
import lombok.Setter;

public class Book {
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String  productID;
	
	@Getter @Setter private String  bookname;
	
	@Getter @Setter private String  author;

	@Override
	public String toString() {
		return "Book [id=" + id + ", productID=" + productID + ", bookname=" + bookname + ", author=" + author + "]";
	}
}
