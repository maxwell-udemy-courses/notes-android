package com.maxwell.notes.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxwell.notes.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    LinearLayout llNoteContainer;
    TextView tvNoteTitle, tvNoteBody;

    public NoteViewHolder(@NonNull View v) {
        super(v);

        llNoteContainer = v.findViewById(R.id.llNoteContainer);
        tvNoteTitle = v.findViewById(R.id.tvNoteTitle);
        tvNoteBody = v.findViewById(R.id.tvNoteBody);
    }
}
