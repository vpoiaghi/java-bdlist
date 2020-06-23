package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Author;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoAutograph extends BoItem {

	private BoRef<Author> author;
	
	private LocalDate autographDate;
	private String place;
	private String event;
	private String comments;

}
