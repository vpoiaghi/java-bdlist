package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoAuthor;
import utils.LogUtils;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Author extends BoAuthor {

    public List<Person> getPersons() {
        return getLinkedBoList(Person.class);
    }

    public List<Goody> getGoodies() {
        return getLinkedBoList(Goody.class);
    }

    @Override
    public String toString() {

    	String result = getAlias();

    	if (result == null) {
    		// Si l'auteur n'a pas d'alias, il peut n'y avoir qu'une seule personne derrière l'auteur.
    		
    		List<Person> persons = getPersons();
    		
    		if (persons == null) {
    			LogUtils.warn("Persons is null for Author " + getId());
    		} else if (persons.size() == 0) {
    			LogUtils.warn("Persons is empty for Author " + getId());
    		}
    		
            result = persons.get(0).toString();
    	}

    	return result;
    }

}
