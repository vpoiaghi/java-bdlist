package data.bo;

import java.time.LocalDateTime;

import bo.BoItem;
import bo.BoRef;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoAd extends BoItem {

	private BoRef<BoAdState> state;

	private String title;
	private String url;
	private String sellerComments;
	private String comments;
	private LocalDateTime endOfValidity;
	private double currentCost;
	private double bestPrice;
	private int articlesCount;
}
