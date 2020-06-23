package data.bo;

import bo.BoItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoAdState extends BoItem {

	private String name;
	private boolean isWin;
	private boolean isLost;
}
