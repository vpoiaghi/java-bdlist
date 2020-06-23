package data.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import bo.BoItem;
import bo.BoRef;
import data.extendedbo.Author;
import data.extendedbo.Editor;
import data.extendedbo.Festival;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoInSigning extends BoItem {
	
	private BoRef<Festival> festival;
	private BoRef<Editor> editor;
	private BoRef<Author> author;
	
	private LocalDate day;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String comments;
}
