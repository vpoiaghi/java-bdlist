package mappers;

import java.util.List;

import data.extendedbo.Author;
import data.extendedbo.Editor;
import data.extendedbo.Goody;
import data.extendedbo.Serie;
import front.bean.sync_phone.SyncGoody;
import utils.StringUtils;

public class MapperGoodyToSyncGoody {

	public static SyncGoody map(final Goody goody) {
		
		SyncGoody syncGoody = null;
		
		if (goody != null) {
			
			syncGoody = new SyncGoody();
	
			String name = goody.toString().replace("\"", "''");
			
			syncGoody.setIdPossessionState(getIdPossessionState(goody));
	
			setSerieInfos(goody, syncGoody);
			setEditorInfos(goody, syncGoody);
			setAuthorInfos(goody, syncGoody);
			
			syncGoody.setId(goody.getId());
			syncGoody.setTsp(goody.getTsp());
			syncGoody.setName(name);
			syncGoody.setSearchName(StringUtils.toSearchString(name));
			syncGoody.setKindName(getKindName(goody));
			syncGoody.setState(null);
			syncGoody.setWithAutograph(goody.getAutograph() != null);
			syncGoody.setParutionDate(goody.getParutionDate());
			syncGoody.setCopyNumber(getCopyNumber(goody));
			syncGoody.setCopyCount(goody.getNumberMax());
			
			syncGoody.setSizeX(goody.getWidth());
			syncGoody.setSizeY(goody.getHeight());
			syncGoody.setSizeZ(null);
			syncGoody.setOrderNumber(goody.getOrderNumber());
		}		
		
		return syncGoody;
	}

	private static void setSerieInfos(final Goody goody, final SyncGoody syncGoody) {
		
		String serieName = null;
        final List<Serie> series = goody.getSeries();
        
        if (series.size() == 0) {
        	syncGoody.setSerieName(null);
        	syncGoody.setSerieSearchName(null);
            syncGoody.setIdSerie(null);
            syncGoody.setIdSeries(null);

        } else {
        	
        	if (series.size() == 1) {
            	final Serie firstSerie = series.get(0);
        		serieName = firstSerie.getSortName();
                syncGoody.setIdSerie(firstSerie.getId());
                syncGoody.setIdSeries(null);
            
        	} else if (series.size() > 1) {
                serieName = "Séries multiples";
                
                String s = ";";
                for(Serie serie : goody.getSeries()) {
                    s += serie.getId() + ";";
                }

                syncGoody.setIdSerie(null);
                syncGoody.setIdSeries(s);
            } 

    		syncGoody.setSerieName(serieName);
    		syncGoody.setSerieSearchName(StringUtils.toSearchString(serieName));
        }

	}
	
	private static void setEditorInfos(final Goody goody, final SyncGoody syncGoody) {
		
		final List<Editor> editors =  goody.getEditors();
		if (editors.size() > 0) {
			Editor editor = editors.get(0);
			syncGoody.setIdEditor(editor.getId());
			syncGoody.setEditorName(editor.getName());
		} else {
			syncGoody.setIdEditor(null);
			syncGoody.setEditorName(null);
		}
	}
	
	private static void setAuthorInfos(final Goody goody, final SyncGoody syncGoody) {
		
        List<Author> authors = goody.getAuthors();

        Long id = null;
        String ids = null;
        
        if(authors.size() == 1) {
        	id = authors.get(0).getId();
        	
        } else if(authors.size() > 1) {

            String a = "";
            for(Author author : authors) {
                a += author.getId() + ";";
            }
            
            if (a.length() > 0) {
            	ids = ";" + a;
            }
        }
        
		syncGoody.setIdAuthor(id);
		syncGoody.setIdAuthors(ids);
	}

	private static Long getIdPossessionState(final Goody goody) {
		
		Long idPossessionState;
		
		try {
			idPossessionState = goody.getPossessionState().getBo().getId();
		} catch(NullPointerException e) {
			idPossessionState = null;
		}

		return idPossessionState;
	}

	private static String getKindName(final Goody goody) {
		
		String kindName;
		
		try {
			kindName = goody.getKindOfGoody().getBo().getName();
		} catch(NullPointerException e) {
			kindName = null;
		}

		return kindName;
	}
	
	private static String getCopyNumber(final Goody goody) {
	
	   String copyNumber = null;

	   if ((goody.getNumberType() != null) && (goody.getNumber() != null)) {
		   copyNumber = (goody.getNumberType() + " " + goody.getNumber()).trim();
	   } else if (goody.getNumberType() != null) {
		   copyNumber = goody.getNumberType().trim();
	   } else if (goody.getNumberType() != null) {
		   copyNumber = goody.getNumber().trim();
	   }

	   return copyNumber;
	}

}
