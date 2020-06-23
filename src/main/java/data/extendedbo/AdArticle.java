package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoAdArticle;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class AdArticle extends BoAdArticle {

    public List<Ad> getAds() {
        return getLinkedBoList(Ad.class);
    }

}
