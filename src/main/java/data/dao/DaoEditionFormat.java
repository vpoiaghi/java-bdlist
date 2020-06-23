package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionFormat;

public class DaoEditionFormat extends DaoLink<BoEditionFormat> {

    public DaoEditionFormat() {
        this(null);
    }

    public DaoEditionFormat(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoFormat.class});
    }

}
