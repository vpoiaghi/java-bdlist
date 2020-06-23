package mappers;

import java.util.List;

import data.extendedbo.Author;
import data.extendedbo.Autograph;
import data.extendedbo.Edition;
import data.extendedbo.Goody;
import front.bean.sync_phone.SyncAutograph;

public class MapperAutographToSyncAutograph {

	public static SyncAutograph map(final Autograph autograph) {

		SyncAutograph syncAutograph = null;

		if (autograph != null) {

			syncAutograph = new SyncAutograph();

			syncAutograph.setIdEdition(getIdEdition(autograph));
			syncAutograph.setIdGoody(getIdGoody(autograph));

			setAuthorInfos(autograph, syncAutograph);

			syncAutograph.setId(autograph.getId());
			syncAutograph.setTsp(autograph.getTsp());

			syncAutograph.setAutographDate(autograph.getAutographDate());
			syncAutograph.setPlace(autograph.getPlace());
			syncAutograph.setEvent(autograph.getEvent());
			syncAutograph.setComments(autograph.getComments());
		}

		return syncAutograph;
	}

	private static Long getIdEdition(final Autograph autograph) {

		Long idEdition;
		List<Edition> editions = autograph.getEditions();

		if (editions.size() > 0) {
			idEdition = editions.get(0).getId();
		} else {
			idEdition = null;
		}

		return idEdition;
	}

	private static Long getIdGoody(final Autograph autograph) {

		Long idGoody;
		List<Goody> goodies = autograph.getGoodies();

		if (goodies.size() > 0) {
			idGoody = goodies.get(0).getId();
		} else {
			idGoody = null;
		}

		return idGoody;
	}

	private static void setAuthorInfos(final Autograph autograph, final SyncAutograph syncAutograph) {

		Author author;
		
		try {
			author = autograph.getAuthor().getBo();
		} catch (NullPointerException e) {
			author = null;
		}

		Long id = null;
		String ids = null;
		
		if (author != null) {
			id = author.getId();
			ids = ";" + id + ";";
		}

		syncAutograph.setIdAuthor(id);
		syncAutograph.setIdAuthors(ids);
	}
}
