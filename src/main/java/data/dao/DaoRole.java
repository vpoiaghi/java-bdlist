package data.dao;

import dao.DaoLinks;
import dao.DaoNamedItem;
import dao.FactoryOfDao;
import data.extendedbo.Role;

public class DaoRole extends DaoNamedItem<Role> {

	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionAuthorRole.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionSocietyRole.class));
	}
	
	@Override
	public String getTableName() {
		return "Role";
	}
}
