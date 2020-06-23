package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoPerson extends BoItem {

	private String firstname;
	private String lastname;
	private String searchName;
	private String webSite;
	private LocalDate birthDay;
	private String birthPlace;
	private String birthCountry;
	private LocalDate deathDay;
	private String biography;

}
