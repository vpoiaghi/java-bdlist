package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoPerson;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Person extends BoPerson {

	private static final String UNKNOWN_PERSON_DEFAULT_TO_STRING = "Inconnu";
	
    public List<Author> getAuthors() {
        return getLinkedBoList(Author.class);
    }
    
    @Override
    public String toString() {

    	String result = "";

    	String firstName = getFirstname();
    	String lastName = getLastname();

    	if ((firstName == null) && (lastName == null)) {
    		result = UNKNOWN_PERSON_DEFAULT_TO_STRING;
    	} else if (firstName == null) {
    		result = lastName;
    	} else if (lastName == null) {
    		result = firstName;
    	} else {
    		result = lastName + ", " + firstName;
    	}

    	return result;

	}
}
