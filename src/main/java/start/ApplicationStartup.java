package start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dao.FactoryOfDao;
import data.dao.DaoPossessionState;
import data.dao.DaoState;
import data.source.SqliteDB;
import utils.LogUtils;


/**
 * Created by b.bassac on 23/06/2017.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	SqliteDB sqliteSBSource;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

		initCache();

		LogUtils.info("##############################");
		LogUtils.info("#          LOADING           #");
		LogUtils.info("##############################");

	}

	private void initCache() {

		try {

			// Chargement des State pour les placer en cache
			FactoryOfDao.get(DaoState.class).getAll();

			// Chargement des PossessionState pour les placer en cache
			FactoryOfDao.get(DaoPossessionState.class).getAll();

		} catch(Exception e) {
			LogUtils.error(e);
		}

	}
}
