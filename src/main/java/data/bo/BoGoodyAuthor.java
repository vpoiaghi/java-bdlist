package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoGoodyAuthor extends BoLink {
	
    public BoGoodyAuthor(long idGoody, long idAuthor) {
        super(2);
        setId(0, idGoody);
        setId(1, idAuthor);
    }

    public long getIdGoody() {
        return getId(0);
    }

    public long getIdAuthor() {
        return getId(1);
    }

}
