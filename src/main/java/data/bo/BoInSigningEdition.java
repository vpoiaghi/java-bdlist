package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoInSigningEdition extends BoLink {
	
    public BoInSigningEdition(long idInSigning, long idEdition) {
        super(2);
        setId(0, idInSigning);
        setId(1, idEdition);
    }

    public long getIdInSigning() {
        return getId(0);
    }

    public long getIdEdition() {
        return getId(1);
    }

}
