package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Person;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoSeller extends BoItem {

	private BoRef<Person> person;
	
	private String alias;
	private boolean recommended;
	private String comments;
}
