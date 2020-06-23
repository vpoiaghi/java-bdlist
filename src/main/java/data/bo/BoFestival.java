package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoFestival extends BoItem {

	private String name;
	private LocalDate beginDate;
	private LocalDate endDate;

}
