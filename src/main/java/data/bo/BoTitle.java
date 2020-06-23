package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Serie;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoTitle extends BoItem {

	private BoRef<Serie> serie;

	private String name;
	private String searchName;
	private Integer orderNumber;
	private String story;
	private boolean outSerie;

}
