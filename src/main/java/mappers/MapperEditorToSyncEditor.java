package mappers;

import data.extendedbo.Editor;
import front.bean.sync_phone.SyncEditor;

public class MapperEditorToSyncEditor {

	public static SyncEditor map(final Editor editor) {

		SyncEditor syncEditor = null;

		if (editor != null) {
			
			syncEditor = new SyncEditor();

			syncEditor.setId(editor.getId());
			syncEditor.setTsp(editor.getTsp());
			syncEditor.setName(editor.getName());

		}
		return syncEditor;
	}

}