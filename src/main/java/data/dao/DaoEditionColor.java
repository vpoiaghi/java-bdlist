package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionColor;

public class DaoEditionColor extends DaoLink<BoEditionColor> {

    public DaoEditionColor() {
        this(null);
    }

    public DaoEditionColor(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoColor.class});
    }

}
