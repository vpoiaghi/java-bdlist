package mappers;

import java.util.List;

import data.bo.GroupAuthorRole;
import data.extendedbo.Color;
import data.extendedbo.Edition;
import data.extendedbo.Editor;
import data.extendedbo.Serie;
import data.extendedbo.Title;
import front.bean.sync_phone.SyncEdition;
import services.ServiceEdition;

public class MapperEditionToSyncEdition {
	
	private static final ServiceEdition svcEdition = new ServiceEdition();	

	public static SyncEdition map(final Edition edition) {
		
		SyncEdition syncEdition = null;
		
		if (edition != null) {
			
			syncEdition = new SyncEdition();

			syncEdition.setId(edition.getId());
			syncEdition.setTsp(edition.getTsp());
			syncEdition.setOrderNumber(getOrderNumber(edition));
			syncEdition.setCollection(getCollectionName(edition));
			syncEdition.setEditionNumber(edition.getEditionNumber());
			syncEdition.setIsbn(edition.getIsbn());
			syncEdition.setIsIntegral(edition.isIntegral());
			syncEdition.setIsSet(edition.isSet());
			syncEdition.setName(edition.getName());
			syncEdition.setSearchName(edition.getSearchName());
			syncEdition.setParutionDate(edition.getParutionDate());
			syncEdition.setVersionNumber(edition.getVersionNumber());
			syncEdition.setSpecialEdition(edition.getSpecialEdition());
			syncEdition.setBoardsCount(edition.getBoardsCount());
			syncEdition.setPrintingMax(edition.getPrintingMaxNumber());
			syncEdition.setTextAuthorName(getAuthorsByRole(edition, "Scénario"));
			syncEdition.setDrawAuthorName(getAuthorsByRole(edition, "Dessins"));
			syncEdition.setColorAuthorName(getAuthorsByRole(edition, "Couleurs"));
			syncEdition.setIsWithAutograph(getWithAutograph(edition));
			syncEdition.setHasAnotherEditions(svcEdition.hasAnotherEditions(edition));


			syncEdition.setIdState(getIdState(edition));
			syncEdition.setIdPossessionState(getIdPossessionState(edition));

			mapSeries(edition, syncEdition);
			mapTitles(edition, syncEdition);
			mapEditor(edition, syncEdition);
			mapBoardsColor(edition, syncEdition);
		}
        
		return syncEdition;
	}
	
	
	private static void mapSeries(final Edition edition, final SyncEdition syncEdition) {
		
		final List<Serie> series = edition.getSeries();
		
		if (series.size() > 1) {
			
			String s = "";
			for(Serie serie : series) {
				s += ";" + serie.getId();
			}
			syncEdition.setIdSeries(s + ";");
			
			syncEdition.setSerieName("Séries multiples"); 
			syncEdition.setSerieSearchName("SERIES MULTIPLES"); 

		} 
		else if (series.size() == 1) {
			Serie serie = series.get(0);
			syncEdition.setIdSerie(serie.getId());
			syncEdition.setSerieName(serie.getName()); 
			syncEdition.setSerieSearchName(serie.getSearchName()); 
		}
	}
	
	private static void mapTitles(final Edition edition, final SyncEdition syncEdition) {
		
		final List<Title> titles = edition.getTitles();
		
		if (titles.size() > 1) {
			
			String s = "";
			for(Title title : titles) {
				s += ";" + title.getId();
			}
			syncEdition.setIdTitles(s + ";");
		} 
		else if (titles.size() == 1) {
			syncEdition.setIdTitle(titles.get(0).getId());
		}
	}
	
	private static void mapEditor(final Edition edition, final SyncEdition syncEdition) {
		
		try {
			Editor editor = edition.getEditor().getBo();
			syncEdition.setEditorName(editor.getName());
			syncEdition.setIdEditor(editor.getId());
		} catch (NullPointerException ex) {
		}
	}
	
	private static void mapBoardsColor(final Edition edition, final SyncEdition syncEdition) {
		
		String strColors = "";
		
        for(Color c : edition.getColors()) {
        	strColors += c.getName() + ", ";
        }
        
        if (strColors.length() > 0) {
        	syncEdition.setBoardsColor(strColors.substring(0, strColors.length() - 2));
        } else {
        	syncEdition.setBoardsColor(null);
        }

	}
	
	private static int getOrderNumber(final Edition edition) {

		final List<Title> titles = edition.getTitles();
		int orderNumber = 1;

		if (titles.size() > 1) {

			if (edition.isIntegral()) {
				orderNumber = 10000;

				for (Title title : titles) {

					if (title.getOrderNumber() < orderNumber) {
						orderNumber = title.getOrderNumber();
					}
				}

			}

		} else if (titles.size() == 1) {
			orderNumber = titles.get(0).getOrderNumber();
		}

		return orderNumber;
	}
	
	private static String getAuthorsByRole(final Edition edition, final String role) {
		
        String textAuthorName = "";
        		
        for (GroupAuthorRole ar : edition.getAuthorRoles()) {
            if (role.equals(ar.getRole().getName())) {
                textAuthorName += ar.getAuthor().getId() + "," + ar.getAuthor().toString() + "; ";
            }
        }
        
        if (textAuthorName.length() > 0) {
            textAuthorName = textAuthorName.substring(0, textAuthorName.length() - 2);
        }
		
        return textAuthorName;
	}
	
	private static String getCollectionName(final Edition edition) {
		
		String collectionName;
		
		try {
			collectionName = edition.getCollection().getBo().getName();
		} catch (NullPointerException ex) {
			collectionName = null;
		}

		return collectionName;
	}
	
	private static boolean getWithAutograph(final Edition edition) {
		
		boolean withAutograph;
		
		try {
			withAutograph = edition.getAutographs().size() > 0;
		} catch (NullPointerException ex) {
			withAutograph = false;
		}
		
		return withAutograph;
	}
	
	private static Long getIdState(final Edition edition) {
		
		Long idState;
		
		try {
			idState = edition.getState().getBo().getId();
		} catch (NullPointerException ex) {
			idState = null;
		}
		
		return idState;
	}

	private static Long getIdPossessionState(final Edition edition) {
		
		Long idPossessionState;
		
		try {
			idPossessionState = edition.getPossessionState().getBo().getId();
		} catch (NullPointerException ex) {
			idPossessionState = null;
		}
		
		return idPossessionState;
	}
}