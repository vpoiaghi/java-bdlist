package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoGoodyEditor;

public class DaoGoodyEditor extends DaoLink<BoGoodyEditor> {

    public DaoGoodyEditor() {
        this(null);
    }

    public DaoGoodyEditor(IDaoItem owner) {
        super(owner, new Type[] {DaoGoody.class, DaoEditor.class});
    }

}
