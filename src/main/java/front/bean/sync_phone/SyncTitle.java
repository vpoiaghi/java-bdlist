package front.bean.sync_phone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncTitle", description="Title to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncTitle extends IdBean {

	private Long idSerie;
	
	private String name;
	private Integer orderNumber;
	private String story;
	private boolean outSerie;
	private boolean inPossession;

	@Override
	public String toString() {
		return name;
	}
}
