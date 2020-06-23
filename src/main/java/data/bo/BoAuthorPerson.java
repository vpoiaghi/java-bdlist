package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoAuthorPerson extends BoLink {

    public BoAuthorPerson(long idAuthor, long idPerson) {
        super(2);
        setId(0, idAuthor);
        setId(1, idPerson);
    }

    public long getIdAuthor() {
        return getId(0);
    }

    public long getPerson() {
        return getId(1);
    }

}
