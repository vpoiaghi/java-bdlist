package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.bo.BoAdState;
import data.extendedbo.Ad;
import utils.LogUtils;

public class DaoAd extends DaoItem<Ad> {

	@Override
	public String getTableName() {
		return "Ad";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoAdAdArticle.class));
		daoLinks.add(FactoryOfDao.get(this, DaoPurchaseAd.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Ad ad) {
        
		try {
			ad.setState(new BoRef<BoAdState>(DaoState.class, rs.getLong("IdState")));
			
			ad.setTitle(rs.getString("Title"));
			ad.setUrl(rs.getString("Url"));
			ad.setSellerComments(rs.getString("SellerComments"));
			ad.setComments(rs.getString("Comments"));
			ad.setEndOfValidity(dateToLocalDateTime(rs.getString("EndOfValidity")));
			ad.setCurrentCost(rs.getDouble("CurrentCost"));
			ad.setBestPrice(rs.getDouble("BestPrice"));
			ad.setArticlesCount(rs.getInt("ArticlesCount"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
