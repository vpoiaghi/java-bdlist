package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Author;
import data.extendedbo.Kind;
import data.extendedbo.Origin;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoSerie extends BoItem {

	private BoRef<Kind> kind;
	private BoRef<Origin> origin;
	private BoRef<Author> manager;

	private String name;
	private String sortName;
	private String searchName;
	private Integer ended;
	private String webSite;
	private String story;
	
}
