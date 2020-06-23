package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.KindOfGoody;

public class DaoKindOfGoody extends DaoNamedItem<KindOfGoody> {

	@Override
	public String getTableName() {
		return "KindOfGoody";
	}
}
