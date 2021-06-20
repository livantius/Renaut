package com.example.renaut;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.renaut.RoomData.Words;
import com.example.renaut.RoomData.WordsDatabase;

public class AddWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
        EditText word = findViewById(R.id.editTextTextPersonName);
        EditText word1 = findViewById(R.id.editTextTextPersonName2);
        EditText word2 = findViewById(R.id.editTextTextPersonName3);
        EditText word3 = findViewById(R.id.editTextTextPersonName4);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewWord("Код детали:        " + word.getText().toString());
                addNewWord("Тип детали:        " + word1.getText().toString());
                addNewWord("Производитель: " + word2.getText().toString());
                addNewWord("Магазин:             " + word3.getText().toString());
                addNewWord(" ");
            }
        });
    }

    private void addNewWord(String word) {
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        Words words = new Words();
        words.word = word;


        db.wordsDao().insertWords(words);
        finish();
    }

 
}