package mappers;

import data.extendedbo.Author;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import data.extendedbo.InSigning;
import front.bean.sync_phone.SyncInSigning;

public class MapperInSigningToSyncInSigning {

	public static SyncInSigning map(final InSigning inSigning) {

		SyncInSigning syncInSigning = null;

		if (inSigning != null) {
			
			syncInSigning = new SyncInSigning();

			syncInSigning.setIdFestival(getIdFestival(inSigning));
			syncInSigning.setIdEditor(getIdEditor(inSigning));
			syncInSigning.setIdAuthor(getIdAuthor(inSigning));
			
			syncInSigning.setId(inSigning.getId());
			syncInSigning.setTsp(inSigning.getTsp());
			syncInSigning.setStartHour(inSigning.getStartTime());
			syncInSigning.setEndHour(inSigning.getEndTime());
			syncInSigning.setComments(inSigning.getComments());
		}

		return syncInSigning;
	}

	private static Long getIdEditor(final InSigning inSigning) {
		
		Long idEditor = null;
		Editor editor = null;
		
		try {
			editor = inSigning.getEditor().getBo();
		} catch (NullPointerException e) {
		}
		
		if (editor != null) {
			idEditor = editor.getId();
		}
		
		return idEditor;
	}

	private static Long getIdFestival(final InSigning inSigning) {
		
		Long idFestival = null;
		Festival festival = null;
		
		try {
			festival = inSigning.getFestival().getBo();
		} catch (NullPointerException e) {
		}
		
		if (festival != null) {
			idFestival = festival.getId();
		}
		
		return idFestival;
	}

	private static Long getIdAuthor(final InSigning inSigning) {
		
		Long idAuthor = null;
		Author author = null;
		
		try {
			author = inSigning.getAuthor().getBo();
		} catch (NullPointerException e) {
		}
		
		if (author != null) {
			idAuthor = author.getId();
		}
		
		return idAuthor;
	}
}