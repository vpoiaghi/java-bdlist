package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoPurchaseAd;

public class DaoPurchaseAd extends DaoLink<BoPurchaseAd> {

    public DaoPurchaseAd() {
        this(null);
    }

    public DaoPurchaseAd(IDaoItem owner) {
        super(owner, new Type[] {DaoPurchase.class, DaoAd.class});
    }

}
