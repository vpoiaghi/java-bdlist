package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.WebSite;
import utils.LogUtils;

public class DaoWebSite extends DaoItem<WebSite> {

	@Override
	public String getTableName() {
		return "WebSite";
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
	protected void buildBo(final ResultSet rs, final WebSite webSite) {
        
		try {

			webSite.setName(rs.getString("Name"));
			webSite.setUrl(rs.getString("Url"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
