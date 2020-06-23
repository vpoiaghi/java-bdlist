package front.bean.sync_phone;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import front.bean.abstracts.IdBean;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@ApiModel(value="SyncFestival", description="Festival to sync with phone")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
public class SyncFestival extends IdBean {

	private String name;
	private LocalDate beginDate;
	private LocalDate endDate;

	@Override
	public String toString() {
		return name;
	}
}
