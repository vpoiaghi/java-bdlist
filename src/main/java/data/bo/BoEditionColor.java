package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionColor extends BoLink {
	
    public BoEditionColor(long idEdition, long idColor) {
        super(2);
        setId(0, idEdition);
        setId(1, idColor);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdColor() {
        return getId(1);
    }

}
