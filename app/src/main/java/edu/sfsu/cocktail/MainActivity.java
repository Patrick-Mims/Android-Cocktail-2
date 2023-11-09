package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.Tasks.DataAsyncTask;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> model = null;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    private static String ENDPOINT = Uri.parse("https://www.thecocktaildb.com/api/json/v1/1/search.php")
            .buildUpon()
            .appendQueryParameter("s", "margarita")
            .build().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        Log.v("TAG", "ENDPOINT => " + ENDPOINT);

        new DataAsyncTask(this, recyclerView, progressBar, model).execute(ENDPOINT);
    }
}