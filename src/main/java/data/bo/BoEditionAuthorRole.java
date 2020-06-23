package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionAuthorRole extends BoLink {
	
    public BoEditionAuthorRole(long idEdition, long idAuthor, long idRole) {
        super(3);
        setId(0, idEdition);
        setId(1, idAuthor);
        setId(2, idRole);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdAuthor() {
        return getId(1);
    }

    public long getIdRole() {
        return getId(2);
    }
}
