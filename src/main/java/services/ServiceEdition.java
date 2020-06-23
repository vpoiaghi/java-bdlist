package services;

import java.util.List;

import dao.FactoryOfDao;
import data.dao.DaoEdition;
import data.dao.DaoEditionTitle;
import data.extendedbo.Edition;
import data.extendedbo.Title;

public class ServiceEdition {

	private static final DaoEdition daoEdition = FactoryOfDao.get(DaoEdition.class);
	private static final DaoEditionTitle daoEditionTitle = FactoryOfDao.get(daoEdition, DaoEditionTitle.class);
	
	
	/**
	 * Vérifie s'il il existe une ou plusieurs autres éditions contenant tout ou partie des titres
	 * de l'édition passée en paramètre.
	 * @param edition Edition : édition testée. 
	 * @return boolean : true si il existe d'autres édition, false sinon.
	 */
	public boolean hasAnotherEditions(final Edition edition) {
		return daoEditionTitle.getOtherEditionsCount(edition) > 0;
	}
	
	/**
	 * Retourne la liste des éditions contenant un titre.
	 * @param title Title : titre recherché.
	 * @return List<Edition> la liste des éditions.
	 */
	public List<Edition> getByTitle(final Title title) {
		return daoEdition.getByTitle(title.getId());
	}

}
