package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Author;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import data.extendedbo.InSigning;
import utils.LogUtils;

public class DaoInSigning extends DaoItem<InSigning> {

	@Override
	public String getTableName() {
		return "InSigning";
	}

	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoInSigningEdition.class));
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final InSigning inSigning) {
        
		try {
			inSigning.setFestival(new BoRef<Festival>(DaoFestival.class, rs.getLong("IdFestival")));
			inSigning.setEditor(new BoRef<Editor>(DaoEditor.class, rs.getLong("IdEditor")));
			inSigning.setAuthor(new BoRef<Author>(DaoAuthor.class, rs.getLong("IdAuthor")));

			inSigning.setDay(dateToLocalDate(rs.getString("Day")));
			inSigning.setStartTime(dateToLocalDateTime(rs.getString("StartTime")));
			inSigning.setEndTime(dateToLocalDateTime(rs.getString("EndTime")));
			inSigning.setComments(rs.getString("Comments"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}

}
