package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoEditionSerie extends BoLink {
	
    public BoEditionSerie(long idEdition, long idSerie) {
        super(2);
        setId(0, idEdition);
        setId(1, idSerie);
    }

    public long getIdEdition() {
        return getId(0);
    }

    public long getIdSerie() {
        return getId(1);
    }

}
