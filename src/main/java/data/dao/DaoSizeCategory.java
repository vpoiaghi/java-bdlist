package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.SizeCategory;

public class DaoSizeCategory extends DaoNamedItem<SizeCategory> {

	@Override
	public String getTableName() {
		return "SizeCategory";
	}
}
