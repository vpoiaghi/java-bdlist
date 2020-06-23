package front.bean.sync_phone;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value="SyncData", description="All data to sync with phone")
@Getter @Setter
public class SyncData {

	private int seriesCount = 0;
	private int editionsCount = 0;
	private int goodiesCount = 0;
	private int authorsCount = 0;
	private int editorsCount = 0;
	private int autographsCount = 0;
	private int eventsCount = 0;
	private int festivalsCount = 0;
	private int festivalRemindersCount = 0;
	private int inSigningsCount = 0;
	private int titlesCount = 0;
	
	private List<SyncSerie> series = new ArrayList<>();
	private List<SyncEdition> editions = new ArrayList<>();
	private List<SyncGoody> goodies = new ArrayList<>();
	private List<SyncAuthor> authors = new ArrayList<>();
	private List<SyncEditor> editors = new ArrayList<>();
	private List<SyncAutograph> autographs = new ArrayList<>();
	private List<SyncEvent> events = new ArrayList<>();
	private List<SyncFestival> festivals = new ArrayList<>();
	private List<SyncFestivalReminder> festivalReminders = new ArrayList<>();
	private List<SyncInSigning> inSignings = new ArrayList<>();
	private List<SyncTitle> titles = new ArrayList<>();
}
