package front.bean.sync_phone;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncEdition", description="Edition to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncEdition extends IdBean {

	private String serieName; 
	private String serieSearchName; 
	private Integer orderNumber; 
	private String collection;
	private String editionNumber;
	private String isbn;
	private Boolean isIntegral; 
	private Boolean isSet; 
	private String name; 
	private String searchName; 
	private LocalDate parutionDate;
	private Integer versionNumber;
	private String specialEdition;
	private Integer boardsCount;
	private Integer printingMax;
	private String boardsColor;
	private String textAuthorName;
	private String drawAuthorName;
	private String colorAuthorName;
	private Boolean isWithAutograph;
	private Boolean hasAnotherEditions; 
	private String editorName;
	
	private Long idState;
	private Long idPossessionState; 
	private Long idEditor;
	private Long idSerie;
	private String idSeries;
	private Long idTitle;
	private String idTitles;

}