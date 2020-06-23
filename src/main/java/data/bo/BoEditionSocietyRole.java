package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionSocietyRole extends BoLink {
	
    public BoEditionSocietyRole(long idEdition, long idSociety, long idRole) {
        super(3);
        setId(0, idEdition);
        setId(1, idSociety);
        setId(2, idRole);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdSociety() {
        return getId(1);
    }

    public long getIdRole() {
        return getId(2);
    }
}
