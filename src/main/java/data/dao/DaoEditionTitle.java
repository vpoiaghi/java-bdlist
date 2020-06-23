package data.dao;

import java.lang.reflect.Type;

import dao.DaoLink;
import dao.IDaoItem;
import data.bo.BoEditionTitle;
import data.extendedbo.Edition;
import utils.LogUtils;

public class DaoEditionTitle extends DaoLink<BoEditionTitle> {

    public DaoEditionTitle() {
        this(null);
    }

    public DaoEditionTitle(IDaoItem owner) {
        super(owner, new Type[] {DaoEdition.class, DaoTitle.class});
    }

	/**
	 * Retourne le nombre d'éditions contenant tout ou partie des titres de l'édition passée en paramètre.
	 * @param edition Edition : édition testée. 
	 * @return Integer : le nombre d'édition.
	 */
	public int getOtherEditionsCount(final Edition edition) {
		
		int result = 0;
		
		final String tbl = getTableName();
		
		final String rqt =  
				" SELECT COUNT(*)" 
				+ " FROM " + tbl + " AS table1" 
                + " INNER JOIN " + tbl + " AS table2" 
                + " ON (table1.IdTitle = table2.IdTitle AND table1.IdEdition <> table2.IdEdition)" 
                + " WHERE table1.IdEdition = " + edition.getId();
		
		try {
			result = executeCountQuery(rqt);
		} catch (Exception e) {
			LogUtils.error(e);
		}
		
		return result;
	}
    
}
