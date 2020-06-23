package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoTitle;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Title extends BoTitle {

    public List<Edition> getEditions() {
        return getLinkedBoList(Edition.class);
    }
}
