package com.maxwell.notes.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.maxwell.notes.BaseActivity;
import com.maxwell.notes.LoginActivity;
import com.maxwell.notes.R;
import com.maxwell.notes.notes.models.Note;
import com.maxwell.notes.utils.Constants;

import java.util.ArrayList;

public class NotesActivity extends BaseActivity {
    RecyclerView rvNotes;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        setRecyclerViewData();

        setLogoutEvent();
    }

    private void populateNoteList(){
        noteList = new ArrayList<>();

        noteList.add(new Note("Pasear perro", "Hace mucho que no sale"));
        noteList.add(new Note("Pasear gato", "Nunca sale"));
        noteList.add(new Note("Alimentar perro", "Hace mucho que no come"));
        noteList.add(new Note("Alimentar loro", "Hace mucho que no habla"));
    }

    private void setRecyclerViewData(){
        rvNotes = findViewById(R.id.rvNotes);

        populateNoteList();

        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);

        rvNotes.setAdapter(adapter);

        rvNotes.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);

        rvNotes.setLayoutManager(manager);

    }

    private void setLogoutEvent() {
        Button btLogout = findViewById(R.id.btLogout);

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setPref(Constants.PREFS_USER, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
