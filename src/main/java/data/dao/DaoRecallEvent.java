package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import data.extendedbo.RecallEvent;
import utils.LogUtils;

public class DaoRecallEvent extends DaoItem<RecallEvent> {

	@Override
	public String getTableName() {
		return "Autograph";
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
	protected void buildBo(final ResultSet rs, final RecallEvent recallEvent) {
        
		try {
			recallEvent.setStartDate(dateToLocalDate(rs.getString("StartDate")));
			recallEvent.setEndDate(dateToLocalDate(rs.getString("EndDate")));
			recallEvent.setName(rs.getString("Name"));
			recallEvent.setPlace(rs.getString("Place"));
			recallEvent.setComments(rs.getString("Comments"));
			recallEvent.setState(rs.getLong("State"));
			recallEvent.setReminderDays(rs.getInt("ReminderDays"));
			recallEvent.setPersistenceDays(rs.getInt("PersistenceDays"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        

	}
}
