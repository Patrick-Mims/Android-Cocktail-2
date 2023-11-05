package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;

import edu.sfsu.cocktail.Models.CocktailModel;

public class MainActivity extends AppCompatActivity {
    ArrayList<CocktailModel> cocktailModel = null;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    private static final String api = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cocktailModel = new ArrayList<>();
        // recyclerView = findViewById(R.id.recyclerView);

        // new cocktailTask(this, recyclerView, progressBar, cocktailModel);
    }
}