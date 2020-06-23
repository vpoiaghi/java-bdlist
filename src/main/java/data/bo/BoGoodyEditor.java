package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoGoodyEditor extends BoLink {
	
    public BoGoodyEditor(long idGoody, long idEditor) {
        super(2);
        setId(0, idGoody);
        setId(1, idEditor);
    }

    public long getIdGoody() {
        return getId(0);
    }

    public long getIdEditor() {
        return getId(1);
    }

}
