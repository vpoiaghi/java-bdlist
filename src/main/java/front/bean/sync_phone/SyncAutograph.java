package front.bean.sync_phone;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncAutograph", description="Autograph to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncAutograph extends IdBean {

	private Long idEdition;
	private Long idGoody;
	private Long idAuthor;
	private String idAuthors;
	private LocalDate autographDate;
	private String place;
	private String event;
	private String comments;

}
