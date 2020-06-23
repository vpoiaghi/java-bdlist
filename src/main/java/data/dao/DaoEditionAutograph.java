package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionAutograph;

public class DaoEditionAutograph extends DaoLink<BoEditionAutograph> {

    public DaoEditionAutograph() {
        this(null);
    }

    public DaoEditionAutograph(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoAutograph.class});
    }

}
