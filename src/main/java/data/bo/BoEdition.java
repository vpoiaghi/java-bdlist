package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Collection;
import data.extendedbo.Editor;
import data.extendedbo.PossessionState;
import data.extendedbo.SizeCategory;
import data.extendedbo.State;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoEdition extends BoItem {

	private BoRef<Editor> editor;
	private BoRef<State> state;
	private BoRef<Collection> collection;
	private BoRef<PossessionState> possessionState;
	private BoRef<SizeCategory> sizeCategory;

	private String editionNumber;
	private boolean read;
	private String isbn;
	private String eanIsbn;
	private String issn;
	private String ddl;
	private String reedition;
	private boolean isIntegral; 
	private boolean isSet; 
	private String name; 
	private String searchName; 
	private int pagesCount;
	private int boardsCount;
	private int graphicPagesCount;
	private double boughtPrice; 
	private LocalDate legalDepositeDate;
	private int legalDepositeMonth;
	private int legalDepositeYear;
	private LocalDate parutionDate;
	private int parutionMonth;
	private int parutionYear;
	private LocalDate boughtDate;
	private int boughtMonth;
	private int boughtYear;
	private LocalDate printDate;
	private int printMonth;
	private int printYear;
	private int versionNumber;
	private String editionInformations;
	private String autograph;
	private String specialEdition;
	private double width;
	private double height;
	private int printingNumber;
	private int printingMaxNumber;
	private String comments;

}