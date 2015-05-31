package org.lambda_kollektiv.papyrus;

import android.provider.BaseColumns;

/**
 * Created by konny on 31.05.15.
 * This class defines the table name and its columns.
 */
class NotesContract {
    public NotesContract(){}

    public static abstract class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_NAME_ENTRY_ID = "noteid";
        public static final String COLUMN_NAME_TEXT = "notetext";
    }
}
