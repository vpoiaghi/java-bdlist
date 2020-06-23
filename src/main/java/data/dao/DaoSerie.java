package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Author;
import data.extendedbo.Kind;
import data.extendedbo.Origin;
import data.extendedbo.Serie;
import utils.LogUtils;

public class DaoSerie extends DaoItem<Serie> {

	@Override
	public String getTableName() {
		return "Serie";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionSerie.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodySerie.class));
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Serie serie) {
		
		try {
			
			serie.setKind(new BoRef<Kind>(DaoKind.class, rs.getLong("IdKind")));
			serie.setOrigin(new BoRef<Origin>(DaoOrigin.class, rs.getLong("IdOrigin")));
			serie.setManager(new BoRef<Author>(DaoAuthor.class, rs.getLong("IdManager")));

			serie.setName(rs.getString("Name")); 
	        serie.setSortName(rs.getString("SortName"));
	        serie.setSearchName(rs.getString("SearchName"));
	        serie.setEnded(rs.getInt("Ended"));
	        serie.setWebSite(rs.getString("WebSite"));
	        serie.setStory(rs.getString("Story"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
		
	}	
	
}
