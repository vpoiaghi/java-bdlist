package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.Festival;
import utils.LogUtils;

public class DaoFestival extends DaoItem<Festival> {

	@Override
	public String getTableName() {
		return "Festival";
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
	protected void buildBo(final ResultSet rs, final Festival festival) {
        
		try {
			festival.setName(rs.getString("Name"));
			festival.setBeginDate(dateToLocalDate(rs.getString("BeginDate")));
			festival.setEndDate(dateToLocalDate(rs.getString("EndDate")));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        

	}
}
