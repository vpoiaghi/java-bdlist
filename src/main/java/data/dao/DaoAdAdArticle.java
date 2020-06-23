package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoAdAdArticle;

public class DaoAdAdArticle extends DaoLink<BoAdAdArticle> {

    public DaoAdAdArticle() {
        this(null);
    }

    public DaoAdAdArticle(IDaoItem owner) {
        super(owner, new Type[] {DaoAd.class, DaoAdArticle.class});
    }

}
