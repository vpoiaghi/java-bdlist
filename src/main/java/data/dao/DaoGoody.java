package data.dao;

import java.sql.ResultSet;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Collection;
import data.extendedbo.Goody;
import data.extendedbo.KindOfGoody;
import data.extendedbo.PossessionState;
import utils.LogUtils;

public class DaoGoody extends DaoItem<Goody> {

	@Override
	public String getTableName() {
		return "Goody";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoGoodySerie.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyAuthor.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyEdition.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyEditor.class));
	}
		
	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Goody goody) {
        
		try {
			goody.setKindOfGoody(new BoRef<KindOfGoody>(DaoKindOfGoody.class, rs.getLong("IdKindOfGoody")));			
			goody.setPossessionState(new BoRef<PossessionState>(DaoPossessionState.class, rs.getLong("IdPossessionState")));
			goody.setCollection(new BoRef<Collection>(DaoCollection.class, rs.getLong("IdCollection")));

			goody.setOrderNumber(rs.getInt("OrderNumber"));
			goody.setDescription(rs.getString("Description"));
			goody.setSearchDescription(rs.getString("SearchDescription"));
			goody.setNumber(rs.getString("Number"));
			goody.setNumberType(rs.getString("NumberType"));
			goody.setNumberMax(rs.getInt("NumberMax"));
			goody.setAutograph(rs.getString("Autograph"));
			goody.setParutionDate(dateToLocalDate(rs.getString("ParutionDate")));
			goody.setBoughtDate(dateToLocalDate(rs.getString("BoughtDate")));
			goody.setFormat(rs.getString("Format"));
			goody.setWidth(rs.getLong("Width"));
			goody.setHeight(rs.getLong("Height"));
			goody.setComments(rs.getString("Comments"));
			goody.setBoxNumber(rs.getInt("BoxNumber"));
			goody.setNumberInCollection(rs.getInt("NumberInCollection"));
			goody.setScanned(rs.getBoolean("Scanned"));
			goody.setCount(rs.getInt("Count"));
			
		} catch (Exception e) {
        	LogUtils.error(e);
        }        

	}
}
