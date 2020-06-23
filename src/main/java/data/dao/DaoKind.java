package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.Kind;

public class DaoKind extends DaoNamedItem<Kind> {

	@Override
	public String getTableName() {
		return "Kind";
	}
}
