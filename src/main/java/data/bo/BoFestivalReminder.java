package data.bo;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoFestivalReminder extends BoItem {

	private BoRef<Festival> festival;
	private BoRef<Editor> editor;
	
	private String name;
	private Long kind;
	private String comments;

}
