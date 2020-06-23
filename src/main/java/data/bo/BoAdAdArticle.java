package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoAdAdArticle extends BoLink {

    public BoAdAdArticle(long idAd, long idArticle) {
        super(2);
        setId(0, idAd);
        setId(1, idArticle);
    }

    public long getIdAd() {
        return getId(0);
    }

    public long getArticle() {
        return getId(1);
    }

}
