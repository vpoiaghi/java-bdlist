package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.AdArticle;
import data.extendedbo.Edition;
import data.extendedbo.Goody;
import utils.LogUtils;

public class DaoAdArticle extends DaoItem<AdArticle> {

	@Override
	public String getTableName() {
		return "AdArticle";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoAdAdArticle.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final AdArticle adArticle) {
        
		try {
			adArticle.setEdition(new BoRef<Edition>(DaoEdition.class, rs.getLong("IdEdition")));
			adArticle.setGoody(new BoRef<Goody>(DaoGoody.class, rs.getLong("IdGoody")));
			
			adArticle.setWithNumber(rs.getInt("WithNumber"));
			adArticle.setWithAutograph(rs.getInt("WithAutograph"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
