package com.maxwell.notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.maxwell.notes.utils.PreferencesManager;

public abstract class BaseActivity extends AppCompatActivity {
    public PreferencesManager prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = new PreferencesManager(this);
    }
}
