package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.PossessionState;

public class DaoPossessionState extends DaoNamedItem<PossessionState> {

	@Override
	public String getTableName() {
		return "PossessionState";
	}
}
