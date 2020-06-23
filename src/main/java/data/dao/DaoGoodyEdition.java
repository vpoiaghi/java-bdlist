package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoGoodyEdition;

public class DaoGoodyEdition extends DaoLink<BoGoodyEdition> {

    public DaoGoodyEdition() {
        this(null);
    }

    public DaoGoodyEdition(IDaoItem owner) {
        super(owner, new Type[] {DaoGoody.class, DaoEdition.class});
    }

}
