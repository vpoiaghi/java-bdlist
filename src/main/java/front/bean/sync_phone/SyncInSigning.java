package front.bean.sync_phone;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncInSigning", description="InSigning to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncInSigning extends IdBean {

	private Long idFestival;
	private Long idEditor;
	private Long idAuthor;
	
	private LocalDateTime startHour;
	private LocalDateTime endHour;
	private String comments;
}
