package data.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import dao.FactoryOfDao;
import data.dao.DaoAd;
import data.dao.DaoAdAdArticle;
import data.dao.DaoAdArticle;
import data.dao.DaoAdState;
import data.dao.DaoAuthor;
import data.dao.DaoAuthorPerson;
import data.dao.DaoAutograph;
import data.dao.DaoCollection;
import data.dao.DaoColor;
import data.dao.DaoEdition;
import data.dao.DaoEditionAuthorRole;
import data.dao.DaoEditionAutograph;
import data.dao.DaoEditionColor;
import data.dao.DaoEditionFormat;
import data.dao.DaoEditionSerie;
import data.dao.DaoEditionSocietyRole;
import data.dao.DaoEditionTitle;
import data.dao.DaoEditor;
import data.dao.DaoFestival;
import data.dao.DaoFestivalReminder;
import data.dao.DaoFormat;
import data.dao.DaoGoody;
import data.dao.DaoGoodyAuthor;
import data.dao.DaoGoodyAutograph;
import data.dao.DaoGoodyEdition;
import data.dao.DaoGoodyEditor;
import data.dao.DaoGoodySerie;
import data.dao.DaoInSigning;
import data.dao.DaoInSigningEdition;
import data.dao.DaoKind;
import data.dao.DaoKindOfGoody;
import data.dao.DaoOrigin;
import data.dao.DaoPerson;
import data.dao.DaoPossessionState;
import data.dao.DaoPurchase;
import data.dao.DaoPurchaseAd;
import data.dao.DaoPurchaseState;
import data.dao.DaoRecallEvent;
import data.dao.DaoRole;
import data.dao.DaoSeller;
import data.dao.DaoSerie;
import data.dao.DaoSizeCategory;
import data.dao.DaoSociety;
import data.dao.DaoState;
import data.dao.DaoTitle;
import data.dao.DaoWebSite;
import data_source.DataSource;
import data_source.IDataSource;
import utils.LogUtils;

@Component
public final class SqliteDB extends DataSource implements IDataSource {

	public SqliteDB() {
		declareDaos();
	}
	
	protected final Connection getConnection() {

		Connection conn = null;
		
		try {
			// db parameters
			String url = "jdbc:sqlite:./data/Data.db3";
			 
			// create a connection to the database
			conn = DriverManager.getConnection(url);
			 
			//LogUtils.warn("Connection to SQLite has been established.");
	        
		} catch (SQLException e) {
			LogUtils.error(e);
		}
		
		return conn;
	}
	
	public void declareDaos() {
		
		FactoryOfDao.declareDao(new DaoAd(), this);
		FactoryOfDao.declareDao(new DaoAdArticle(), this);
		FactoryOfDao.declareDao(new DaoAdState(), this);
		FactoryOfDao.declareDao(new DaoAuthor(), this);
		FactoryOfDao.declareDao(new DaoAutograph(), this);
		FactoryOfDao.declareDao(new DaoCollection(), this);
		FactoryOfDao.declareDao(new DaoColor(), this);
		FactoryOfDao.declareDao(new DaoEdition(), this);
		FactoryOfDao.declareDao(new DaoEditor(), this);
		FactoryOfDao.declareDao(new DaoFestival(), this);
		FactoryOfDao.declareDao(new DaoFestivalReminder(), this);
		FactoryOfDao.declareDao(new DaoFormat(), this);
		FactoryOfDao.declareDao(new DaoGoody(), this);
		FactoryOfDao.declareDao(new DaoInSigning(), this);
		FactoryOfDao.declareDao(new DaoKind(), this);
		FactoryOfDao.declareDao(new DaoKindOfGoody(), this);
		FactoryOfDao.declareDao(new DaoOrigin(), this);
		FactoryOfDao.declareDao(new DaoPerson(), this);
		FactoryOfDao.declareDao(new DaoPossessionState(), this);
		FactoryOfDao.declareDao(new DaoPurchase(), this);
		FactoryOfDao.declareDao(new DaoPurchaseState(), this);
		FactoryOfDao.declareDao(new DaoRecallEvent(), this);
		FactoryOfDao.declareDao(new DaoRole(), this);
		FactoryOfDao.declareDao(new DaoSeller(), this);
		FactoryOfDao.declareDao(new DaoSerie(), this);
		FactoryOfDao.declareDao(new DaoSizeCategory(), this);
		FactoryOfDao.declareDao(new DaoSociety(), this);
		FactoryOfDao.declareDao(new DaoState(), this);
		FactoryOfDao.declareDao(new DaoTitle(), this);
		FactoryOfDao.declareDao(new DaoWebSite(), this);
		
		FactoryOfDao.declareDaoLink(new DaoAdAdArticle(FactoryOfDao.get(DaoAd.class)), this);
		FactoryOfDao.declareDaoLink(new DaoAdAdArticle(FactoryOfDao.get(DaoAdArticle.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoAuthorPerson(FactoryOfDao.get(DaoAuthor.class)), this);
		FactoryOfDao.declareDaoLink(new DaoAuthorPerson(FactoryOfDao.get(DaoPerson.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionAuthorRole(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionAuthorRole(FactoryOfDao.get(DaoAuthor.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionAuthorRole(FactoryOfDao.get(DaoRole.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionAutograph(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionAutograph(FactoryOfDao.get(DaoAutograph.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionColor(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionColor(FactoryOfDao.get(DaoColor.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionFormat(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionFormat(FactoryOfDao.get(DaoFormat.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionSerie(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionSerie(FactoryOfDao.get(DaoSerie.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionSocietyRole(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionSocietyRole(FactoryOfDao.get(DaoSociety.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionSocietyRole(FactoryOfDao.get(DaoRole.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoEditionTitle(FactoryOfDao.get(DaoEdition.class)), this);
		FactoryOfDao.declareDaoLink(new DaoEditionTitle(FactoryOfDao.get(DaoTitle.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoGoodyAuthor(FactoryOfDao.get(DaoGoody.class)), this);
		FactoryOfDao.declareDaoLink(new DaoGoodyAuthor(FactoryOfDao.get(DaoAuthor.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoGoodyAutograph(FactoryOfDao.get(DaoGoody.class)), this);
		FactoryOfDao.declareDaoLink(new DaoGoodyAutograph(FactoryOfDao.get(DaoAutograph.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoGoodyEdition(FactoryOfDao.get(DaoGoody.class)), this);
		FactoryOfDao.declareDaoLink(new DaoGoodyEdition(FactoryOfDao.get(DaoEdition.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoGoodyEditor(FactoryOfDao.get(DaoGoody.class)), this);
		FactoryOfDao.declareDaoLink(new DaoGoodyEditor(FactoryOfDao.get(DaoEditor.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoGoodySerie(FactoryOfDao.get(DaoGoody.class)), this);
		FactoryOfDao.declareDaoLink(new DaoGoodySerie(FactoryOfDao.get(DaoSerie.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoInSigningEdition(FactoryOfDao.get(DaoInSigning.class)), this);
		FactoryOfDao.declareDaoLink(new DaoInSigningEdition(FactoryOfDao.get(DaoEdition.class)), this);
		
		FactoryOfDao.declareDaoLink(new DaoPurchaseAd(FactoryOfDao.get(DaoPurchase.class)), this);
		FactoryOfDao.declareDaoLink(new DaoPurchaseAd(FactoryOfDao.get(DaoAd.class)), this);
	}
	
}
