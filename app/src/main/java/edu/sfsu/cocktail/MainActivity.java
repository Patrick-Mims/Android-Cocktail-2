package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;

import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.Tasks.DataAsyncTask;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> cocktailModel = null;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    private static String ENDPOINT = Uri.parse("https://www.thecocktaildb.com/api/json/v1/1/search.php")
            .buildUpon()
            .appendQueryParameter("s", "martini")
            .build().toString();

    /**
     * When you compile your app, each XML layout file is compiled into a View resource.
     * Load the layout resource in your app's Activity.onCreate() callback implementation.
     * Do so by calling setContentView(), passing it the reference to your layout resource:
     * R.layout.layout_file_name
     * example:  setContentView(R.layout.main_layout);
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cocktailModel = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        new DataAsyncTask(this, recyclerView, progressBar, cocktailModel).execute(ENDPOINT);
    }
}