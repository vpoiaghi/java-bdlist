package services;

import dao.FactoryOfDao;
import data.dao.DaoAuthor;
import data.extendedbo.Author;
import front.exceptions.AuthorNoFoundException;

public class ServiceAuthor {

	private static final DaoAuthor daoAuthor = FactoryOfDao.get(DaoAuthor.class);
	
	/**
	 * Retourne l'auteur correspondant à l'id.
	 * @param id Long : id de l'auteur recherché.
	 * @return Author l'auteur corresonpans à l'id si il existe, null sinon.
	 */
	public Author getAuthorById(final Long id) {
		
		Author author = null;
		
		try {
			author = daoAuthor.getById(id);
		} catch (Exception e) {
			throw new AuthorNoFoundException(e, id);
		}

		return author;
	}

}
