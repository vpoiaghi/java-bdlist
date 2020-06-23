package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Editor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoCollection extends BoItem {

	private BoRef<Editor> editor;
	
	private String name;
	private String webSite;
	private String management;
	private Integer creationYear;

}
