package data.dao;

import dao.DaoNamedItem;
import data.extendedbo.PurchaseState;

public class DaoPurchaseState extends DaoNamedItem<PurchaseState> {

	@Override
	public String getTableName() {
		return "PurchaseState";
	}
}
