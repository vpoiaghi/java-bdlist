package mappers;

import data.extendedbo.RecallEvent;
import front.bean.sync_phone.SyncEvent;

public class MapperRecallEventToSyncEvent {

	public static SyncEvent map(final RecallEvent recallEvent) {

		SyncEvent syncEvent = null;

		if (recallEvent != null) {
			
			syncEvent = new SyncEvent();

			syncEvent.setId(recallEvent.getId());
			syncEvent.setTsp(recallEvent.getTsp());
			syncEvent.setName(recallEvent.getName());

		}
		return syncEvent;
	}

}