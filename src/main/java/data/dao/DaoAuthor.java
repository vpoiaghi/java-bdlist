package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Author;
import utils.LogUtils;

public class DaoAuthor extends DaoItem<Author> {

	@Override
	public String getTableName() {
		return "Author";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoAuthorPerson.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionAuthorRole.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyAuthor.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Author author) {
        
		try {
			author.setAlias(rs.getString("Alias"));
			author.setSearchAlias(rs.getString("SearchAlias"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
