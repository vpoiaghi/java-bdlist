package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Society;
import utils.LogUtils;

public class DaoSociety extends DaoItem<Society> {

	@Override
	public String getTableName() {
		return "Society";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionSocietyRole.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Society society) {
        
		try {
			society.setName(rs.getString("Name"));
			society.setWebSite(rs.getString("WebSite"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
