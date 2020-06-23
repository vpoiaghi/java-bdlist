package data.bo;

import java.time.LocalDate;

import bo.BoItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoRecallEvent extends BoItem {

	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	private String place;
	private String comments;
	private Long state;
	private Integer reminderDays;
	private Integer persistenceDays;

}
