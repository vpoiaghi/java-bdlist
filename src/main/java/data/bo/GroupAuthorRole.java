package data.bo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoItem;
import bo.GroupOfBo;
import data.extendedbo.Author;
import data.extendedbo.Role;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Getter @Setter
public class GroupAuthorRole extends GroupOfBo {

	private Long id = null;
	
	private Author author;
	private Role role;
	
	@Override
	public void setBoItem(BoItem boItem) {
		
		if (boItem instanceof Author) {
			setAuthor((Author) boItem);
		} else if (boItem instanceof Role) {
			setRole((Role) boItem);
		}
		
		if ((getAuthor() != null) && (getRole() != null)) {
			id = new Long(Objects.hash(getAuthor().getId(), getRole().getId()));
		}
		
	}
	
}
