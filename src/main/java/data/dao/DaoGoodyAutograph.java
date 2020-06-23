package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoGoodyAutograph;

public class DaoGoodyAutograph extends DaoLink<BoGoodyAutograph> {

    public DaoGoodyAutograph() {
        this(null);
    }

    public DaoGoodyAutograph(IDaoItem owner) {
        super(owner, new Type[] {DaoGoody.class, DaoAutograph.class});
    }

}
