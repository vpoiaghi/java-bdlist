package front.bean.sync_phone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncEditor", description="Editor to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncEditor extends IdBean {

	private String name;

	@Override
	public String toString() {
		return name;
	}
}
