package data.dao;

import java.lang.reflect.Type;

import bo.GroupOfBo;
import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionSocietyRole;
import data.bo.GroupEditionRole;
import data.bo.GroupEditionSociety;
import data.bo.GroupSocietyRole;

public class DaoEditionSocietyRole extends DaoLink<BoEditionSocietyRole> {

    public DaoEditionSocietyRole() {
        this(null);
    }

    public DaoEditionSocietyRole(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoSociety.class, DaoRole.class});
    }

    @Override
    public GroupOfBo getNewGroup( ) {
    	
    	GroupOfBo group = null;
    	
    	if (owner instanceof DaoEdition) {
    		group = new GroupSocietyRole();
    	} else if (owner instanceof DaoSociety) {
    		group = new GroupEditionRole();
    	} else if (owner instanceof DaoRole) {
    		group = new GroupEditionSociety();
    	}

    	return group;
    }
}
