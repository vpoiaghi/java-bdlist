package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionSerie;

public class DaoEditionSerie extends DaoLink<BoEditionSerie> {

    public DaoEditionSerie() {
        this(null);
    }

    public DaoEditionSerie(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoSerie.class});
    }

}
