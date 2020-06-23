package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoGoodySerie;

public class DaoGoodySerie extends DaoLink<BoGoodySerie> {

    public DaoGoodySerie() {
        this(null);
    }

    public DaoGoodySerie(IDaoItem owner) {
        super(owner, new Type[] {DaoGoody.class, DaoSerie.class});
    }

}
