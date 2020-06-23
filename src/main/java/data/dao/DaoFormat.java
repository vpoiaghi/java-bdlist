package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.Format;

public class DaoFormat extends DaoNamedItem<Format> {

	@Override
	public String getTableName() {
		return "Format";
	}
}
