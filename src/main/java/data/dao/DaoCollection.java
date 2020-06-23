package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.Collection;
import data.extendedbo.Editor;
import utils.LogUtils;

public class DaoCollection extends DaoItem<Collection> {

	@Override
	public String getTableName() {
		return "Collection";
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
	protected void buildBo(final ResultSet rs, final Collection collection) {
        
		try {
			collection.setEditor(new BoRef<Editor>(DaoEditor.class, rs.getLong("IdEditor")));

			collection.setName(rs.getString("Name"));
			collection.setWebSite(rs.getString("WebSite"));
			collection.setManagement(rs.getString("Management"));
			collection.setCreationYear(rs.getInt("CreationYear"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
;
	}
}
