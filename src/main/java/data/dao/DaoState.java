package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.State;

public class DaoState extends DaoNamedItem<State> {

	@Override
	public String getTableName() {
		return "State";
	}

}
