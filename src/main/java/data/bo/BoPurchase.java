package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.PurchaseState;
import data.extendedbo.Seller;
import data.extendedbo.WebSite;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoPurchase extends BoItem {

	private BoRef<Seller> seller;
	private BoRef<WebSite> webSite;
	private BoRef<PurchaseState> State;
	
	private Double postage;
	private LocalDate startDate;
	private String comments;
}
