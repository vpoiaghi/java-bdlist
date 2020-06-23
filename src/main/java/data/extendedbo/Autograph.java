package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoAutograph;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Autograph extends BoAutograph {

    public List<Edition> getEditions() {
        return getLinkedBoList(Edition.class);
    }

    public List<Goody> getGoodies() {
        return getLinkedBoList(Goody.class);
    }

}
