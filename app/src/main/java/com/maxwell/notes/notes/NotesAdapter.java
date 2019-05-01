package com.maxwell.notes.notes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxwell.notes.R;
import com.maxwell.notes.notes.models.Note;
import com.maxwell.notes.utils.Constants;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    ArrayList<Note> noteList;
    Context ctx;

    public NotesAdapter(ArrayList<Note> noteList, Context ctx) {
        this.noteList = noteList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_note, parent, false);

        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, final int i) {
        holder.tvNoteTitle.setText(noteList.get(i).getTitle());
        holder.tvNoteBody.setText(noteList.get(i).getBody());

        holder.llNoteContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            noteList.remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());


//                Intent intent = new Intent(ctx, DetailNoteActivity.class);
//                intent.putExtra(Constants.EXTRA_NOTE_TITLE, noteList.get(i).getTitle());
//                intent.putExtra(Constants.EXTRA_NOTE_BODY, noteList.get(i).getBody());
//                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
