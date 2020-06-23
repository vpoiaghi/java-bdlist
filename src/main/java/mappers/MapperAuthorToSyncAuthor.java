package mappers;

import data.extendedbo.Author;
import front.bean.sync_phone.SyncAuthor;
import utils.StringUtils;

public class MapperAuthorToSyncAuthor {

	public static SyncAuthor map(final Author author) {

		SyncAuthor syncAuthor = null;

		if (author != null) {
			
			syncAuthor = new SyncAuthor();

			final String name = author.toString();
			final String searchName = StringUtils.toSearchString(name);

			syncAuthor.setId(author.getId());
			syncAuthor.setTsp(author.getTsp());
			syncAuthor.setName(name);
			syncAuthor.setSearchName(searchName);

		}
		return syncAuthor;
	}

}