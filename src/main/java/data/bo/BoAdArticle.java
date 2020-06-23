package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Edition;
import data.extendedbo.Goody;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoAdArticle extends BoItem {

	private BoRef<Edition> edition;
	private BoRef<Goody> goody;

	private int withNumber;
	private int withAutograph;
}
