package data.bo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoItem;
import bo.GroupOfBo;
import data.extendedbo.Author;
import data.extendedbo.Edition;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Getter @Setter
public class GroupEditionAuthor extends GroupOfBo {

	private Long id = null;
	
	private Edition edition;
	private Author author;
	
	@Override
	public void setBoItem(BoItem boItem) {
		
		if (boItem instanceof Edition) {
			setEdition((Edition) boItem);
		} else if (boItem instanceof Author) {
			setAuthor((Author) boItem);
		}
	
		if ((getEdition() != null) && (getAuthor() != null)) {
			id = new Long(Objects.hash(getEdition().getId(), getAuthor().getId()));
		}
	}
	
}
