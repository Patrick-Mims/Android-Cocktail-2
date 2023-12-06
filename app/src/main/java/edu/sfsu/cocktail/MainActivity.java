package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.sfsu.cocktail.Fragments.LocalFragment;
import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.Services.LocalService;
import edu.sfsu.cocktail.Tasks.DataAsyncTask;
import edu.sfsu.cocktail.ViewModel.DrinkViewModel;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> cocktailModel = null;
    ProgressBar progressBar;
    DrinkViewModel drinkViewModel;
    RecyclerView recyclerView;

    public String getParsedUrl(String drink) {
        return Uri.parse("https://www.thecocktaildb.com/api/json/v1/1/search.php").buildUpon().appendQueryParameter("s", drink).build().toString();
    }

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        /**
         * The onCreate() method is called when an instance of the Activity subclass is created.
         */
        super.onCreate(savedInstanceState);
        /**
         * setContentView() method inflates a layout and puts it on the screen.
         */
        setContentView(R.layout.activity_main);

        cocktailModel = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView); // access elements by using their Resource ID.
        progressBar = findViewById(R.id.progressbar);

        Context theContext = getBaseContext();
        TextView textView = findViewById(R.id.vm);

        Button button1 = findViewById(R.id.show_mojito);
        button1.setText("Gin");

        Button button2 = findViewById(R.id.show_margarita);
        button2.setText("Martini");

        Button button3 = findViewById(R.id.startService);
        button3.setText("Start Service");

        Button button4 = findViewById(R.id.stopService);
        button4.setText("Stop Service");

        /**
         * Toast Notification
         */
        Toast toast = Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);

        /**
         * Anonymous Inner Class
         * Everything within the outermost set of parenthesis is passed into setOnClickListener(OnClickListener)
         * Therefore we can access textView from within
         * 11.21.23
         */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText("[ Data AsyncTask ]");
                button1.setText("Data Loaded");

                toast.show();
                new DataAsyncTask(MainActivity.this, recyclerView, progressBar, cocktailModel).execute(getParsedUrl("gin"));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("[ Data AsyncTask ]");
                button1.setText("Data Loaded");

                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                new DataAsyncTask(MainActivity.this, recyclerView, progressBar, cocktailModel).execute(getParsedUrl("martini"));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, LocalService.class));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, LocalService.class));
            }
        });

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
        Fragment fragment = new LocalFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, fragment);
        ft.commit();
    }
}