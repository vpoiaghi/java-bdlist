package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionFormat extends BoLink {
	
    public BoEditionFormat(long idEdition, long idFormat) {
        super(2);
        setId(0, idEdition);
        setId(1, idFormat);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdFormat	() {
        return getId(1);
    }

}
