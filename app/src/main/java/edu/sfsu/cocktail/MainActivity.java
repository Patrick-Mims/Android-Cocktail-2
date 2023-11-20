package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.Tasks.DataAsyncTask;
import edu.sfsu.cocktail.ViewModel.DrinkViewModel;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> cocktailModel = null;
    ProgressBar progressBar;
    DrinkViewModel drinkViewModel;
    RecyclerView recyclerView;

    private static final String ENDPOINT = Uri.parse("https://www.thecocktaildb.com/api/json/v1/1/search.php")
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

        TextView textView = findViewById(R.id.vm);

        cocktailModel = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressbar);

        new DataAsyncTask(this, recyclerView, progressBar, cocktailModel).execute(ENDPOINT);

        /**
         * ViewModel
         */
        drinkViewModel = new ViewModelProvider(this).get(DrinkViewModel.class);
        final Observer<Model> drinkObserver = new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                textView.setText(R.string.app_name);
            }
        };

        drinkViewModel.getUiState().observe(this, drinkObserver);

        /* this code also works
        drinkViewModel.getUiState().observe(this, new Observer<Model>() {
            @Override
            public void onChanged(Model model) {
                textView.setText("Pee Wee");
            }
        });

        drinkViewModel.getUiState().observe(this, uiState -> {
            textView.setText("Kamikaze");
        });
        */
    }
}