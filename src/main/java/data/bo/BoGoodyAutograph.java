package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoGoodyAutograph extends BoLink {
	
    public BoGoodyAutograph(long idGoody, long idAutograph) {
        super(2);
        setId(0, idGoody);
        setId(1, idAutograph);
    }

    public long getIdGoody() {
        return getId(0);
    }

    public long getIdAutograph() {
        return getId(1);
    }

}
