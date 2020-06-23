package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import data.extendedbo.FestivalReminder;
import utils.LogUtils;

public class DaoFestivalReminder extends DaoItem<FestivalReminder> {

	@Override
	public String getTableName() {
		return "FestivalReminder";
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
	protected void buildBo(final ResultSet rs, final FestivalReminder festivalReminder) {
        
		try {
			festivalReminder.setFestival(new BoRef<Festival>(DaoFestival.class, rs.getLong("IdFestival")));
			festivalReminder.setEditor(new BoRef<Editor>(DaoEditor.class, rs.getLong("IdEditor")));
			
			festivalReminder.setName(rs.getString("Name"));
			festivalReminder.setKind(rs.getLong("Kind"));
			festivalReminder.setComments(rs.getString("Comments"));
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
