package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.FactoryOfDao;
import data.dao.DaoAuthor;
import data.dao.DaoAutograph;
import data.dao.DaoEdition;
import data.dao.DaoEditor;
import data.dao.DaoFestival;
import data.dao.DaoFestivalReminder;
import data.dao.DaoGoody;
import data.dao.DaoInSigning;
import data.dao.DaoRecallEvent;
import data.dao.DaoSerie;
import data.dao.DaoTitle;
import data.extendedbo.Author;
import data.extendedbo.Autograph;
import data.extendedbo.Edition;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import data.extendedbo.FestivalReminder;
import data.extendedbo.Goody;
import data.extendedbo.InSigning;
import data.extendedbo.RecallEvent;
import data.extendedbo.Serie;
import data.extendedbo.Title;
import front.bean.sync_phone.SyncAuthor;
import front.bean.sync_phone.SyncAutograph;
import front.bean.sync_phone.SyncData;
import front.bean.sync_phone.SyncEdition;
import front.bean.sync_phone.SyncEditor;
import front.bean.sync_phone.SyncEvent;
import front.bean.sync_phone.SyncFestival;
import front.bean.sync_phone.SyncFestivalReminder;
import front.bean.sync_phone.SyncGoody;
import front.bean.sync_phone.SyncInSigning;
import front.bean.sync_phone.SyncSerie;
import front.bean.sync_phone.SyncTitle;
import mappers.MapperAuthorToSyncAuthor;
import mappers.MapperAutographToSyncAutograph;
import mappers.MapperEditionToSyncEdition;
import mappers.MapperEditorToSyncEditor;
import mappers.MapperFestivalReminderToSyncFestivalReminder;
import mappers.MapperFestivalToSyncFestival;
import mappers.MapperGoodyToSyncGoody;
import mappers.MapperInSigningToSyncInSigning;
import mappers.MapperRecallEventToSyncEvent;
import mappers.MapperSerieToSyncSerie;
import mappers.MapperTitleToSyncTitle;
import utils.LogUtils;

public class ServicePhoneSync {

	private static final DaoSerie daoSerie = FactoryOfDao.get(DaoSerie.class);
	private static final DaoEdition daoEdition = FactoryOfDao.get(DaoEdition.class);
	private static final DaoGoody daoGoody = FactoryOfDao.get(DaoGoody.class);
	private static final DaoAuthor daoAuthor = FactoryOfDao.get(DaoAuthor.class);
	private static final DaoEditor daoEditor = FactoryOfDao.get(DaoEditor.class);
	private static final DaoAutograph daoAutograph = FactoryOfDao.get(DaoAutograph.class);
	private static final DaoRecallEvent daoRecallEvent = FactoryOfDao.get(DaoRecallEvent.class);
	private static final DaoFestival daoFestival = FactoryOfDao.get(DaoFestival.class);
	private static final DaoFestivalReminder daoFestivalReminder = FactoryOfDao.get(DaoFestivalReminder.class);
	private static final DaoInSigning daoInSigning = FactoryOfDao.get(DaoInSigning.class);
	private static final DaoTitle daoTitle = FactoryOfDao.get(DaoTitle.class);

	public SyncData getData(final LocalDateTime tsp) {

		SyncData syncData = new SyncData();

		syncData.setSeries(getSyncSeries(tsp));
		syncData.setEditions(getSyncEditions(tsp));
		syncData.setGoodies(getSyncGoodies(tsp));
		syncData.setAuthors(getSyncAuthors(tsp));
		syncData.setEditors(getSyncEditors(tsp));

		syncData.setAutographs(getSyncAutographs(tsp));
		syncData.setEvents(getSyncRecallEvents(tsp));
		syncData.setFestivals(getSyncFestivals(tsp));
		syncData.setFestivalReminders(getSyncFestivalReminders(tsp));
		syncData.setInSignings(getSyncInSignings(tsp));

		syncData.setTitles(getSyncTitles(tsp));

		syncData.setSeriesCount(syncData.getSeries().size());
		syncData.setEditionsCount(syncData.getEditions().size());
		syncData.setGoodiesCount(syncData.getGoodies().size());
		syncData.setAuthorsCount(syncData.getAuthors().size());
		syncData.setEditorsCount(syncData.getEditors().size());
		syncData.setAutographsCount(syncData.getAutographs().size());
		syncData.setEventsCount(syncData.getEvents().size());
		syncData.setFestivalsCount(syncData.getFestivals().size());
		syncData.setFestivalRemindersCount(syncData.getFestivalReminders().size());
		syncData.setInSigningsCount(syncData.getInSignings().size());
		syncData.setTitlesCount(syncData.getTitles().size());
		
		
		return syncData;

	}

	private List<SyncSerie> getSyncSeries(final LocalDateTime tsp) {

		final List<SyncSerie> syncSeries = new ArrayList<>();		

		try {
			final List<Serie> series = daoSerie.getChanged(tsp);

			for(Serie serie : series) {
				
				if (serie == null) {
					LogUtils.warn("Serie = null");
				}
				
				syncSeries.add(MapperSerieToSyncSerie.map(serie));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncSeries;
	}

	private List<SyncEdition> getSyncEditions(final LocalDateTime tsp) {

		final List<SyncEdition> syncEditions = new ArrayList<>();

		try {
			final List<Edition> editions = daoEdition.getChanged(tsp);

			for(Edition edition : editions) {
				syncEditions.add(MapperEditionToSyncEdition.map(edition));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncEditions;
	}

	private List<SyncGoody> getSyncGoodies(final LocalDateTime tsp) {

		final List<SyncGoody> syncGoodies = new ArrayList<>();

		try {
			final List<Goody> goodies = daoGoody.getChanged(tsp);

			for(Goody goody : goodies) {
				syncGoodies.add(MapperGoodyToSyncGoody.map(goody));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncGoodies;
	}

	private List<SyncAuthor> getSyncAuthors(final LocalDateTime tsp) {

		final List<SyncAuthor> syncAuthors = new ArrayList<>();

		try {
			final List<Author> authors = daoAuthor.getChanged(tsp);

			for(Author author : authors) {
				syncAuthors.add(MapperAuthorToSyncAuthor.map(author));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncAuthors;
	}

	private List<SyncEditor> getSyncEditors(final LocalDateTime tsp) {

		final List<SyncEditor> syncEditors = new ArrayList<>();

		try {
			final List<Editor> editors = daoEditor.getChanged(tsp);

			for(Editor editor : editors) {
				syncEditors.add(MapperEditorToSyncEditor.map(editor));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncEditors;
	}

	private List<SyncAutograph> getSyncAutographs(final LocalDateTime tsp) {

		final List<SyncAutograph> syncAutographs = new ArrayList<>();

		try {
			final List<Autograph> autographs = daoAutograph.getChanged(tsp);

			for(Autograph autograph : autographs) {
				syncAutographs.add(MapperAutographToSyncAutograph.map(autograph));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncAutographs;
	}

	private List<SyncEvent> getSyncRecallEvents(final LocalDateTime tsp) {

		final List<SyncEvent> syncEvents = new ArrayList<>();

		try {
			final List<RecallEvent> recallEvents = daoRecallEvent.getChanged(tsp);

			for(RecallEvent recallEvent : recallEvents) {
				syncEvents.add(MapperRecallEventToSyncEvent.map(recallEvent));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncEvents;
	}

	private List<SyncFestival> getSyncFestivals(final LocalDateTime tsp) {

		final List<SyncFestival> syncFestivals = new ArrayList<>();

		try {
			final List<Festival> festivals = daoFestival.getChanged(tsp);

			for(Festival festival : festivals) {
				syncFestivals.add(MapperFestivalToSyncFestival.map(festival));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncFestivals;
	}

	private List<SyncFestivalReminder> getSyncFestivalReminders(final LocalDateTime tsp) {

		final List<SyncFestivalReminder> syncFestivalReminders = new ArrayList<>();

		try {
			final List<FestivalReminder> festivalReminders = daoFestivalReminder.getChanged(tsp);

			for(FestivalReminder festivalReminder : festivalReminders) {
				syncFestivalReminders.add(MapperFestivalReminderToSyncFestivalReminder.map(festivalReminder));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncFestivalReminders;
	}

	private List<SyncInSigning> getSyncInSignings(final LocalDateTime tsp) {

		final List<SyncInSigning> syncInSignings = new ArrayList<>();

		try {
			final List<InSigning> inSignings = daoInSigning.getChanged(tsp);

			for(InSigning inSigning : inSignings) {
				syncInSignings.add(MapperInSigningToSyncInSigning.map(inSigning));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncInSignings;
	}

	private List<SyncTitle> getSyncTitles(final LocalDateTime tsp) {

		final List<SyncTitle> syncTitles = new ArrayList<>();

		try {
			final List<Title> titles = daoTitle.getChanged(tsp);

			for(Title title : titles) {
				syncTitles.add(MapperTitleToSyncTitle.map(title));
			}
		} catch (Exception e) {
			LogUtils.error(e);
		}

		return syncTitles;
	}
}
