package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Purchase;
import data.extendedbo.PurchaseState;
import data.extendedbo.Seller;
import data.extendedbo.WebSite;
import utils.LogUtils;

public class DaoPurchase extends DaoItem<Purchase> {

	@Override
	public String getTableName() {
		return "Purchase";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoPurchaseAd.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Purchase purchase) {
        
		try {
			purchase.setSeller(new BoRef<Seller>(DaoSeller.class, rs.getLong("IdSeller")));
			purchase.setWebSite(new BoRef<WebSite>(DaoWebSite.class, rs.getLong("IdWebSite")));
			purchase.setState(new BoRef<PurchaseState>(DaoPurchaseState.class, rs.getLong("IdState")));

			purchase.setPostage(rs.getDouble("Postage"));
			purchase.setStartDate(dateToLocalDate(rs.getString("StartDate")));
			purchase.setComments(rs.getString("Comments"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        

	}
}
