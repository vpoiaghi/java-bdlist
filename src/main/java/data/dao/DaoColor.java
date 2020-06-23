package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.Color;

public class DaoColor extends DaoNamedItem<Color> {

	@Override
	public String getTableName() {
		return "Color";
	}
}
