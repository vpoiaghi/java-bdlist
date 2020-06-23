package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Person;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoEditor extends BoItem {

	private BoRef<Person> manager;
	
	private String name;
	private String webSite;
	private String nationality;
	private Integer foundationYear;
	private Integer cessationYear;
	private String cessationCause;
	private String legalForm;
	private String status;
	private String headOffice;
	private String headQuarters;
	private String broadCasting;
	private String comingBooksWebSite;

}
