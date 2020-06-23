package front.bean.sync_phone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncFestivalReminder", description="FestivalReminder to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncFestivalReminder extends IdBean {

	private Long idFestival;
	private Long idEditor;
	
	private String name;
	private int kind;
	private String comments;

	@Override
	public String toString() {
		return name;
	}
}
