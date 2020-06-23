package data.bo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoItem;
import bo.GroupOfBo;
import data.extendedbo.Role;
import data.extendedbo.Society;
import lombok.Getter;
import lombok.Setter;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Getter @Setter
public class GroupSocietyRole extends GroupOfBo {

	private Long id = null;
	
	private Society society;
	private Role role;
	
	@Override
	public void setBoItem(BoItem boItem) {
		
		if (boItem instanceof Society) {
			setSociety((Society) boItem);
		} else if (boItem instanceof Role) {
			setRole((Role) boItem);
		}

		if ((getSociety() != null) && (getRole() != null)) {
			id = new Long(Objects.hash(getSociety().getId(), getRole().getId()));
		}
	}
	
}
