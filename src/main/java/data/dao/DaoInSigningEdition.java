package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoInSigningEdition;

public class DaoInSigningEdition extends DaoLink<BoInSigningEdition> {

    public DaoInSigningEdition() {
        this(null);
    }

    public DaoInSigningEdition(IDaoItem owner) {
        super(owner, new Type[] {DaoInSigning.class, DaoEdition.class});
    }

}
