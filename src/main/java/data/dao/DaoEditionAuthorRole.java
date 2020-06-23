package data.dao;

import java.lang.reflect.Type;

import bo.GroupOfBo;
import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionAuthorRole;
import data.bo.GroupAuthorRole;
import data.bo.GroupEditionAuthor;
import data.bo.GroupEditionRole;

public class DaoEditionAuthorRole extends DaoLink<BoEditionAuthorRole> {

    public DaoEditionAuthorRole() {
        this(null);
    }

    public DaoEditionAuthorRole(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoAuthor.class, DaoRole.class});
    }

    @Override
    public GroupOfBo getNewGroup( ) {
    	
    	GroupOfBo group = null;
    	
    	if (owner instanceof DaoEdition) {
    		group = new GroupAuthorRole();
    	} else if (owner instanceof DaoAuthor) {
    		group = new GroupEditionRole();
    	} else if (owner instanceof DaoRole) {
    		group = new GroupEditionAuthor();
    	}
    	
    	return group;
    }
    
}
