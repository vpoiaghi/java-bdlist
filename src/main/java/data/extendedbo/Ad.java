package data.extendedbo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import data.bo.BoAd;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class Ad extends BoAd {

    public List<AdArticle> getAdArticles() {
        return getLinkedBoList(AdArticle.class);
    }

    public List<Purchase> getPurchases() {
        return getLinkedBoList(Purchase.class);
    }

    public AdState getAdState() {
        return getLinkedBo(AdState.class);
    }
}
