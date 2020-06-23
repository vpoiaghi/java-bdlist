package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Editor;
import data.extendedbo.Person;
import utils.LogUtils;

public class DaoEditor extends DaoItem<Editor> {

	@Override
	public String getTableName() {
		return "Editor";
	}

	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyEditor.class));
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Editor editor) {
        
		try {
			editor.setManager(new BoRef<Person>(DaoPerson.class, rs.getLong("IdManager")));
			
			editor.setName(rs.getString("Name"));
			editor.setWebSite(rs.getString("WebSite"));
			editor.setNationality(rs.getString("Nationality"));
			editor.setFoundationYear(rs.getInt("FoundationYear"));
			editor.setCessationYear(rs.getInt("CessationYear"));
			editor.setCessationCause(rs.getString("CessationCause"));
			editor.setLegalForm(rs.getString("LegalForm"));
			editor.setStatus(rs.getString("Status"));
			editor.setHeadOffice(rs.getString("HeadOffice"));
			editor.setHeadQuarters(rs.getString("HeadQuarters"));
			editor.setBroadCasting(rs.getString("BroadCasting"));
			editor.setComingBooksWebSite(rs.getString("ComingBooksWebSite"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        

	}

}
