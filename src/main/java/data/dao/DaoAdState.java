package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.AdState;
import utils.LogUtils;

public class DaoAdState extends DaoItem<AdState> {

	@Override
	public String getTableName() {
		return "AdState";
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
	protected void buildBo(final ResultSet rs, final AdState adState) {
        
		try {
			adState.setName(rs.getString("Name"));
			adState.setWin(rs.getBoolean("IsWin"));
			adState.setLost(rs.getBoolean("IsLost"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
