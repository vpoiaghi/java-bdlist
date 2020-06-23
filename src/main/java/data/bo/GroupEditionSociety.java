package data.bo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoItem;
import bo.GroupOfBo;
import data.extendedbo.Edition;
import data.extendedbo.Society;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Getter @Setter
public class GroupEditionSociety extends GroupOfBo {

	private Long id = null;
	
	private Edition edition;
	private Society society;
	
	@Override
	public void setBoItem(BoItem boItem) {
		
		if (boItem instanceof Edition) {
			setEdition((Edition) boItem);
		} else if (boItem instanceof Society) {
			setSociety((Society) boItem);
		}
		
		if ((getEdition() != null) && (getSociety() != null)) {
			id = new Long(Objects.hash(getEdition().getId(), getSociety().getId()));
		}
	}
	
}
