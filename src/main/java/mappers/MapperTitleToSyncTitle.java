package mappers;

import java.util.List;

import data.extendedbo.Edition;
import data.extendedbo.Serie;
import data.extendedbo.Title;
import front.bean.sync_phone.SyncTitle;
import services.ServiceEdition;

public class MapperTitleToSyncTitle {

	private static final ServiceEdition svcEdition = new ServiceEdition();
	
	public static SyncTitle map(final Title title) {

		SyncTitle syncTitle = null;

		if (title != null) {
			
			syncTitle = new SyncTitle();

			String story = title.getStory();
			if (story != null) {
				story = story.replace("\"", "''");
			}
			
			syncTitle.setIdSerie(getIdSerie(title));
			
			syncTitle.setId(title.getId());
			syncTitle.setTsp(title.getTsp());
			syncTitle.setName(title.getName().replace("\"", "''"));
			syncTitle.setOrderNumber(title.getOrderNumber());
			syncTitle.setOrderNumber(title.getOrderNumber());
			syncTitle.setStory(story);
			syncTitle.setOutSerie(title.isOutSerie());
			syncTitle.setInPossession(getInPossession(title));
		}

		return syncTitle;
	}

	private static boolean getInPossession(final Title title) {

		boolean inPossession = false;
		List<Edition> editions = svcEdition.getByTitle(title);

        for (Edition edition : editions) {
            if (edition.getPossessionState().getBo().getId() == 1) {
                inPossession = true;
                break;
            }
        }
	
        return inPossession;
	}
	
	private static Long getIdSerie(final Title title) {
		
		Long idSerie = null;
		Serie serie = null;
		
		try {
			serie = title.getSerie().getBo();
		} catch (NullPointerException e) {
		}
		
		if (serie != null) {
			idSerie = serie.getId();
		}
		
		return idSerie;
	}
}