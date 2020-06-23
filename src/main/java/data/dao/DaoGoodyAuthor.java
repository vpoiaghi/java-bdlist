package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoGoodyAuthor;

public class DaoGoodyAuthor extends DaoLink<BoGoodyAuthor> {

    public DaoGoodyAuthor() {
        this(null);
    }

    public DaoGoodyAuthor(IDaoItem owner) {
        super(owner, new Type[] {DaoGoody.class, DaoAuthor.class});
    }

}
