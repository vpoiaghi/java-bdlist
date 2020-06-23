package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionTitle extends BoLink {
	
    public BoEditionTitle(long idEdition, long idTitle) {
        super(2);
        setId(0, idEdition);
        setId(1, idTitle);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdTitle() {
        return getId(1);
    }

}
