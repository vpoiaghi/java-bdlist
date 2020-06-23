package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoEdition;
import data.bo.GroupAuthorRole;
import data.bo.GroupSocietyRole;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Edition extends BoEdition {

    public List<Serie> getSeries() {
        return getLinkedBoList(Serie.class);
    }
	
    public List<Title> getTitles() {
        return getLinkedBoList(Title.class);
    }

    public List<Goody> getGoodies() {
        return getLinkedBoList(Goody.class);
    }

    public List<Autograph> getAutographs() {
        return getLinkedBoList(Autograph.class);
    }

    public List<InSigning> getInSignings() {
        return getLinkedBoList(InSigning.class);
    }

    public List<Color> getColors() {
        return getLinkedBoList(Color.class);
    }

    public List<Format> getFormats() {
        return getLinkedBoList(Format.class);
    }

    public List<GroupAuthorRole> getAuthorRoles() {
        return getLinkedBoList(GroupAuthorRole.class);
    }
    
    public List<GroupSocietyRole> getSocietyRoles() {
        return getLinkedBoList(GroupSocietyRole.class);
    }
}