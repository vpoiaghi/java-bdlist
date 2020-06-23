package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Serie;
import data.extendedbo.Title;
import utils.LogUtils;

public class DaoTitle extends DaoItem<Title> {

	@Override
	public String getTableName() {
		return "Title";
	}

	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionTitle.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Title title) {
        
		try {
			title.setSerie(new BoRef<Serie>(DaoSerie.class, rs.getLong("IdSerie")));

			title.setName(rs.getString("Name"));
			title.setSearchName(rs.getString("SearchName"));
			title.setOrderNumber(rs.getInt("OrderNumber"));
			title.setStory(rs.getString("Story"));
			title.setOutSerie(rs.getBoolean("OutSerie"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
