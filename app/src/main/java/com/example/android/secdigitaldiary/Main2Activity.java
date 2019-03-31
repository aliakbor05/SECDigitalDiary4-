package com.example.android.secdigitaldiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.secdigitaldiary.notes.DatabaseHandler;
import com.example.android.secdigitaldiary.notes.Note;
import com.example.android.secdigitaldiary.notes.NotesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        initViews();
        loadNotes();

    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){
        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();
        if(notesList.size() != 0){
            adapter = new NotesAdapter(this,notesList);
            rvNotes.setAdapter(adapter);
        }


    }

    @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(Main2Activity.this,AddNoteActivity.class);
        startActivity(i);
    }

}