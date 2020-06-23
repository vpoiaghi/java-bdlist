package data.dao;

import java.sql.ResultSet;
import java.util.List;

import bo.BoRef;
import dao.DaoItem;
import dao.DaoLinks;
import dao.FactoryOfDao;
import data.extendedbo.Collection;
import data.extendedbo.Edition;
import data.extendedbo.Editor;
import data.extendedbo.PossessionState;
import data.extendedbo.SizeCategory;
import data.extendedbo.State;
import utils.LogUtils;

public class DaoEdition extends DaoItem<Edition> {

	@Override
	public String getTableName() {
		return "Edition";
	}
	
	@Override
	protected void initLinks(final DaoLinks daoLinks) {
		daoLinks.add(FactoryOfDao.get(this, DaoEditionTitle.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionSerie.class));
		daoLinks.add(FactoryOfDao.get(this, DaoGoodyEdition.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionAutograph.class));
		daoLinks.add(FactoryOfDao.get(this, DaoInSigningEdition.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionColor.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionFormat.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionSocietyRole.class));
		daoLinks.add(FactoryOfDao.get(this, DaoEditionAuthorRole.class));
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Override
	protected void buildBo(final ResultSet rs, final Edition edition) {
		
		try {
			edition.setEditor(new BoRef<Editor>(DaoEditor.class, rs.getLong("IdEditor")));
			edition.setState(new BoRef<State>(DaoState.class, rs.getLong("IdState")));
			edition.setCollection(new BoRef<Collection>(DaoCollection.class, rs.getLong("IdCollection")));
			edition.setPossessionState(new BoRef<PossessionState>(DaoPossessionState.class, rs.getLong("IdPossessionState")));
			edition.setSizeCategory(new BoRef<SizeCategory>(DaoSizeCategory.class, rs.getLong("IdSizeCategory")));
			
	        edition.setEditionNumber(rs.getString("EditionNumber"));
	        edition.setRead(rs.getBoolean("Read"));
	        edition.setIsbn(rs.getString("ISBN"));
	        edition.setEanIsbn(rs.getString("EAN_ISBN"));
	        edition.setIssn(rs.getString("ISSN"));
	        edition.setDdl(rs.getString("DDL"));
	        edition.setReedition(rs.getString("Reedition"));
	        edition.setIntegral(rs.getBoolean("Integral"));
	        edition.setSet(rs.getBoolean("Miscellany"));
	        edition.setName(rs.getString("Name")); 
	        edition.setSearchName(rs.getString("SearchName"));
	        edition.setPagesCount(rs.getInt("PageCount"));
	        edition.setBoardsCount(rs.getInt("BoardCount"));
	        edition.setGraphicPagesCount(rs.getInt("GraphicPagesCount"));
	        edition.setBoughtPrice(rs.getDouble("BoughtPrice"));
	        edition.setLegalDepositeDate(dateToLocalDate(rs.getString("LegalDepositDate")));
	        edition.setLegalDepositeMonth(rs.getInt("LegalDepositMonth"));
	        edition.setLegalDepositeYear(rs.getInt("LegalDepositYear"));
	        edition.setParutionDate(dateToLocalDate(rs.getString("ParutionDate")));
	        edition.setParutionMonth(rs.getInt("ParutionMonth"));
	        edition.setParutionYear(rs.getInt("ParutionYear"));
	        edition.setBoughtDate(dateToLocalDate(rs.getString("BoughtDate")));
	        edition.setBoughtMonth(rs.getInt("BoughtMonth"));
	        edition.setBoughtYear(rs.getInt("BoughtYear"));
	        edition.setPrintDate(dateToLocalDate(rs.getString("PrintDate")));
	        edition.setPrintMonth(rs.getInt("PrintMonth"));
	        edition.setPrintYear(rs.getInt("PrintYear"));
	        edition.setVersionNumber(rs.getInt("VersionNumber"));
	        edition.setEditionInformations(rs.getString("editionInformations"));
	        edition.setAutograph(rs.getString("Autograph"));
	        edition.setSpecialEdition(rs.getString("SpecialEdition"));
	        edition.setWidth(rs.getDouble("Width"));	        
	        edition.setHeight(rs.getDouble("Height"));
	        edition.setPrintingNumber(rs.getInt("PrintingNumber"));
	        edition.setPrintingMaxNumber(rs.getInt("PrintingMaxNumber"));
	        edition.setComments(rs.getString("Comments"));

		} catch (Exception e) {
        	LogUtils.error(e);
        }        
		
	}	
	
	/**
	 * Retourne la liste des éditions contenant un titre.
	 * @param idTitle Long : id du titre recherché.
	 * @return List<Edition> la liste des éditions.
	 */
	public List<Edition> getByTitle(final Long idTitle) {
		
		List<Edition> editions = null;
		
		final String tblEdition = getTableName();
		final String tblEditionTitle = "Edition_Title";
				
		final String rqt =  
				" SELECT *"
				+ " FROM " + tblEdition 
                + " INNER JOIN " + tblEditionTitle 
                + " ON (" + tblEdition + ".Id = " + tblEditionTitle + ".IdEdition AND " + tblEditionTitle + ".IdTitle = " + idTitle + ")";
		
		try {
			editions = getBoList(rqt);
		} catch (Exception e) {
			LogUtils.error(e);
		}
		
		return editions;
	}

}
