package mappers;

import data.extendedbo.Serie;
import front.bean.sync_phone.SyncSerie;
import utils.StringUtils;

public class MapperSerieToSyncSerie {

	public static final int SERIE_STATE_ONGOING = 0;
	public static final int SERIE_STATE_FINISHED = 1;
	public static final int SERIE_STATE_ABORTED = 2;

	public static SyncSerie map(final Serie serie) {

		SyncSerie syncSerie = null;

		if (serie != null) {

			syncSerie = new SyncSerie();

			syncSerie.setKind(getKindName(serie));
			syncSerie.setOrigin(getOriginName(serie));

			syncSerie.setId(serie.getId());
			syncSerie.setTsp(serie.getTsp());
			syncSerie.setName(serie.getSortName());
			syncSerie.setSearchName(StringUtils.toSearchString(serie.getSortName()));
			syncSerie.setEnded(serie.getEnded() != SERIE_STATE_ONGOING);
			syncSerie.setStory(getStory(serie));
		}

		return syncSerie;
	}

	private static String getKindName(final Serie serie) {
		
		String kindName;
		
		try {
			kindName = serie.getKind().getBo().getName();
		} catch (NullPointerException e) {
			kindName = null;
		}

		return kindName;
	}

	private static String getOriginName(final Serie serie) {

		String originName;
		
		try {
			originName = serie.getOrigin().getBo().getName();
		} catch (NullPointerException e) {
			originName = null;
		}

		return originName;
	}

	private static String getStory(final Serie serie) {
		
		String story = serie.getStory();
		
		if (story != null) {
			story = story.replace("\"", "''");
		}
		return story;
	}
}
