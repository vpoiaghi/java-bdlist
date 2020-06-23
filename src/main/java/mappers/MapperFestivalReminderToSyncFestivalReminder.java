package mappers;

import data.extendedbo.Editor;
import data.extendedbo.Festival;
import data.extendedbo.FestivalReminder;
import front.bean.sync_phone.SyncFestivalReminder;

public class MapperFestivalReminderToSyncFestivalReminder {

	public static SyncFestivalReminder map(final FestivalReminder festivalReminder) {

		SyncFestivalReminder syncFestivalReminder = null;

		if (festivalReminder != null) {
			
			syncFestivalReminder = new SyncFestivalReminder();

			syncFestivalReminder.setIdEditor(getIdEditor(festivalReminder));
			syncFestivalReminder.setIdFestival(getIdFestival(festivalReminder));
			
			syncFestivalReminder.setId(festivalReminder.getId());
			syncFestivalReminder.setTsp(festivalReminder.getTsp());
			syncFestivalReminder.setName(festivalReminder.getName());
			

		}
		return syncFestivalReminder;
	}

	private static Long getIdEditor(final FestivalReminder festivalReminder) {
		
		Long idEditor = null;
		Editor editor = null;
		
		try {
			editor = festivalReminder.getEditor().getBo();
		} catch (NullPointerException e) {
		}
		
		if (editor != null) {
			idEditor = editor.getId();
		}
		
		return idEditor;
	}

	private static Long getIdFestival(final FestivalReminder festivalReminder) {
		
		Long idFestival = null;
		Festival festival = null;
		
		try {
			festival = festivalReminder.getFestival().getBo();
		} catch (NullPointerException e) {
		}
		
		if (festival != null) {
			idFestival = festival.getId();
		}
		
		return idFestival;
	}

}