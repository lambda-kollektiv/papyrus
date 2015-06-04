package org.lambda_kollektiv.papyrus;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

public class MainActivity extends FragmentActivity {
    public final static String EXTRA_MESSAGE = "org.lambda_kollektiv.papyrus.MESSAGE";
    private NotesDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialize database
        this.dbHelper = new NotesDatabaseHelper(getBaseContext());
        this.db = dbHelper.getWritableDatabase();

        // build view
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.input_fragment) != null || findViewById(R.id.list_fragment) != null) {
            if(savedInstanceState != null) {
                return;
            }

            InputFragment inputFragment = new InputFragment();
            NotesFragment notesFragment = new NotesFragment();
            notesFragment.setArguments(getIntent().getExtras());

            FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.input_fragment, inputFragment);
            transaction.add(R.id.list_fragment, notesFragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void storeNote(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        ContentValues values = new ContentValues();
        values.put(NotesContract.NoteEntry.COLUMN_NAME_ENTRY_ID, UUID.randomUUID().toString());
        values.put(NotesContract.NoteEntry.COLUMN_NAME_TEXT, message);
        long newRowId;
        newRowId = db.insert(NotesContract.NoteEntry.TABLE_NAME, "null", values);
        System.out.println("Stored:" + newRowId);
    }
}
