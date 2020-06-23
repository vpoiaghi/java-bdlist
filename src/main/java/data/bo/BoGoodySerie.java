package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoGoodySerie extends BoLink {
	
    public BoGoodySerie(long idGoody, long idSerie) {
        super(2);
        setId(0, idGoody);
        setId(1, idSerie);
    }

    public long getIdGoody() {
        return getId(0);
    }

    public long getIdSerie() {
        return getId(1);
    }

}
