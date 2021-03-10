package com.mvvmmemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import javax.xml.transform.Result;

public class AddNoteActivity extends AppCompatActivity {

    public static final String Extra_Title=
            "com.mvvmmemo.ExtraTitle";
    public static final String Extra_Description=
            "com.mvvmmemo.ExtraDescription";
    public static final String Extra_Priority=
            "com.mvvmmemo.ExtraPriority";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        numberPickerPriority.setMinValue(0);
        numberPickerPriority.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }
    private void saveNote(){
        String title=editTextTitle.getText().toString();
        String description=editTextDescription.getText().toString();
        int priority =numberPickerPriority.getValue();
        if(title.trim().isEmpty()|description.trim().isEmpty()){
            Toast.makeText(this, "Please Insert the Title And Description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data=new Intent();
        data.putExtra(Extra_Title,title);
        data.putExtra(Extra_Description,description);
        data.putExtra(Extra_Priority,priority);
        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
