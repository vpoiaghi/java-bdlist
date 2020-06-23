package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoGoody;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Goody extends BoGoody {

    public List<Serie> getSeries() {
        return getLinkedBoList(Serie.class);
    }

    public List<Author> getAuthors() {
        return getLinkedBoList(Author.class);
    }

	public List<Edition> getEditions() {
        return getLinkedBoList(Edition.class);
    }

	public List<Editor> getEditors() {
        return getLinkedBoList(Editor.class);
    }
	
	@Override
    public String toString() {

		String s = getKindOfGoody().toString();
		String d = getDescription();

		if ("coffret".equals(s.toLowerCase()) || "fourreau".equals(s.toLowerCase())) {

			s += " : ";

			for (Edition e : getEditions()) {
				s += e.getEditionNumber() + ", ";
			}

			s = s.substring(0, s.length() - 2);
		
		} else if (d != null) {
            s += " - " + d;
		}

		return s;
	}

}
