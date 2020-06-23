package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoAuthorPerson;

public class DaoAuthorPerson extends DaoLink<BoAuthorPerson> {

    public DaoAuthorPerson() {
        this(null);
    }

    public DaoAuthorPerson(IDaoItem owner) {
        super(owner, new Type[] {DaoAuthor.class, DaoPerson.class});
    }

}
