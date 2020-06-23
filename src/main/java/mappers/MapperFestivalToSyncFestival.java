package mappers;

import data.extendedbo.Festival;
import front.bean.sync_phone.SyncFestival;

public class MapperFestivalToSyncFestival {

	public static SyncFestival map(final Festival festival) {

		SyncFestival syncFestival = null;

		if (festival != null) {
			
			syncFestival = new SyncFestival();

			syncFestival.setId(festival.getId());
			syncFestival.setTsp(festival.getTsp());
			syncFestival.setName(festival.getName());
			
			syncFestival.setBeginDate(festival.getBeginDate());
			syncFestival.setEndDate(festival.getEndDate());

		}
		return syncFestival;
	}

}