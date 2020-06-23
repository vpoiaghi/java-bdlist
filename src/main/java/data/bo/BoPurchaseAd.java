package data.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import bo.BoLink;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class BoPurchaseAd extends BoLink {

    public BoPurchaseAd(long idPurchase, long idAd) {
        super(2);
        setId(0, idPurchase);
        setId(1, idAd);
    }

    public long getIdPurchase() {
        return getId(0);
    }

    public long getAd() {
        return getId(1);
    }

}
