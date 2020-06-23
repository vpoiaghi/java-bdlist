package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.Person;
import data.extendedbo.Seller;
import utils.LogUtils;

public class DaoSeller extends DaoItem<Seller> {

	@Override
	public String getTableName() {
		return "Seller";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Seller seller) {
		
		try {
			seller.setPerson(new BoRef<Person>(DaoPerson.class, rs.getLong("IdPerson")));
			
			seller.setAlias(rs.getString("Alias"));
			seller.setRecommended(rs.getBoolean("Recommended"));
			seller.setComments(rs.getString("Comments"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}	
	
}
