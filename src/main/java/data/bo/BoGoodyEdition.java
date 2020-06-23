package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoGoodyEdition extends BoLink {
	
    public BoGoodyEdition(long idGoody, long idEdition) {
        super(2);
        setId(0, idGoody);
        setId(1, idEdition);
    }

    public long getIdGoody() {
        return getId(0);
    }

    public long getIdEdition() {
        return getId(1);
    }

}
