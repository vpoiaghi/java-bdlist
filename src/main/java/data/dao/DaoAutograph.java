package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Author;
import data.extendedbo.Autograph;
import utils.LogUtils;

public class DaoAutograph extends DaoItem<Autograph> {

	@Override
	public String getTableName() {
		return "Autograph";
	}

	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionAutograph.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyAutograph.class));
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Autograph autograph) {
        
		try {
			autograph.setAuthor(new BoRef<Author>(DaoAuthor.class, rs.getLong("IdAuthor")));

			autograph.setAutographDate(dateToLocalDate(rs.getString("AutographDate")));
			autograph.setPlace(rs.getString("Place"));
			autograph.setEvent(rs.getString("Event"));
			autograph.setComments(rs.getString("Comments"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}

}
