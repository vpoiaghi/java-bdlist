package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.Origin;

public class DaoOrigin extends DaoNamedItem<Origin> {

	@Override
	public String getTableName() {
		return "origin";
	}
}
