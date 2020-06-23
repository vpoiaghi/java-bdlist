package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Collection;
import data.extendedbo.KindOfGoody;
import data.extendedbo.PossessionState;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoGoody extends BoItem {
	
	private BoRef<KindOfGoody> kindOfGoody;
	private BoRef<PossessionState> possessionState;
	private BoRef<Collection> collection;

	private Integer orderNumber;
	private String description;
	private String searchDescription;
	private String number;
	private String numberType;
	private Integer numberMax;
	private String autograph;
	private LocalDate parutionDate;
	private LocalDate boughtDate;
	private String format;
	private Long width;
	private Long height;
	private String comments;
	private Integer boxNumber;
	private Integer numberInCollection;
	private Boolean scanned;
	private Integer count;
}	
