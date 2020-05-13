package com.hupgo.fasylapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnVowels, btnConsonant, btnWordCount, btnTotalCharacter;
EditText editTextCharacters;
    String sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVowels = findViewById(R.id.btn_vowels);
        btnConsonant = findViewById(R.id.btn_consonants);
        btnWordCount = findViewById(R.id.btn_word_count);
        btnTotalCharacter = findViewById(R.id.btn_character);
editTextCharacters = findViewById(R.id.characters);



        //The button to show the vowels
        btnVowels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = String.valueOf(editTextCharacters.getText());
                Toast.makeText(MainActivity.this, "Vowels "+getVowels(sentence), Toast.LENGTH_LONG).show();
            }
        });


        //The button to show the consonants
        btnConsonant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = String.valueOf(editTextCharacters.getText());
                Toast.makeText(MainActivity.this, "Consonants "+getConsonants(sentence), Toast.LENGTH_LONG).show();
            }
        });

        // The button to display the number of words in each sentence(s)
        btnWordCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = String.valueOf(editTextCharacters.getText());
                Toast.makeText(MainActivity.this, "Words are "+getWordCount(sentence), Toast.LENGTH_LONG).show();
            }
        });
        //The button to display the total number of characters in sentence(s)
        btnTotalCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentence = String.valueOf(editTextCharacters.getText());
                Toast.makeText(MainActivity.this, "Words are "+getCharCount(sentence), Toast.LENGTH_LONG).show();
            }
        });
    }


    public int getCharCount(String sentence){
        int characters = 0;
        for(int a = 0; a<sentence.length(); a++){
            if(sentence.charAt(a) !=' '){
                characters ++;
            }
        }
                return characters;
    }

    //Method to count the number of words in a sentence.
    public int getWordCount(String sentence){
        /* Using java split method with a combining regex functionality
        *
        *  */
    return sentence.split("\\s+").length;

    }

//A method to get vowels from a string of characters
    public final int getVowels(String sentence){
        int vowels = 0;
        String str = sentence.toLowerCase();
        for(int i = 0; i<str.length(); i++){
            char character = str.charAt(i);
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                vowels++;
            }
        }
        return vowels;
    }


    //method to get consonants in a string of characters
    public final int getConsonants(String sentence){
        int consonants  = 0;
        String str = sentence.toLowerCase();
        for(int i = 0; i<str.length(); i++){
            char character = str.charAt(i);
            //checking to return
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {

            }else if((character != ' ') && !(character >='0' && character <='9') && (character >='a' && character <='z')){
                consonants++;
            }
        }

        return consonants;
    }
}
