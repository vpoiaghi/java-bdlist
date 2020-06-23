package data.dao;

import java.sql.ResultSet;

import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Person;
import utils.LogUtils;

public class DaoPerson extends DaoItem<Person> {

	@Override
	public String getTableName() {
		return "Person";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoAuthorPerson.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Person person) {
        
		try {
			person.setFirstname(rs.getString("Firstname"));
			person.setLastname(rs.getString("Lastname"));
			person.setSearchName(rs.getString("SearchName"));
			person.setWebSite(rs.getString("WebSite"));
			person.setBirthDay(dateToLocalDate(rs.getString("BirthDay")));
			person.setBirthPlace(rs.getString("BirthPlace"));
			person.setBirthCountry(rs.getString("BirthCountry"));
			person.setDeathDay(dateToLocalDate(rs.getString("DeathDay")));
			person.setBiography(rs.getString("Biography"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        
	        
	}
}
