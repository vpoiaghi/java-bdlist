package front.bean.sync_phone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncSerie", description="Serie to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncSerie extends IdBean {
	
	private String kind;
	private String origin;
	private String name;
	private String searchName;
	private boolean ended;
	private String story;

}
