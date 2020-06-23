package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionAutograph extends BoLink {
	
    public BoEditionAutograph(long idEdition, long idAutograph) {
        super(2);
        setId(0, idEdition);
        setId(1, idAutograph);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdAutograph() {
        return getId(1);
    }

}
