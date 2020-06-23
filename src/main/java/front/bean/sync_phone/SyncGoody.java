package front.bean.sync_phone;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncGoody", description="Goody to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncGoody extends IdBean {
	
	private Long idEditor;
	private Long idSerie;
	private String idSeries;
	private Long idAuthor;
	private String idAuthors;
	private Long idPossessionState; 
	
	private String name;
	private String searchName;
	private String serieName;
	private String serieSearchName;
	private String kindName;
	private String editorName;
	private Integer state;
	private boolean isWithAutograph;
	private LocalDate parutionDate;
	private String copyNumber;
	private Integer copyCount;
	private Long sizeX;
	private Long sizeY;
	private Long sizeZ;
	private Integer orderNumber;
}
