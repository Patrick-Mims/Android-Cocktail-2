package edu.sfsu.cocktail.Tasks;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.sfsu.cocktail.Adapters.AdapterRecyclerView;
import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataAsyncTask extends AsyncTask<String, Integer, String> {

    ArrayList<Model> model;
    Context context;
    Dialog dialog;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    TextView tvLoading, tvPer;

    public DataAsyncTask(Context context, RecyclerView recyclerView, ProgressBar progressBar, ArrayList<Model> model) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
        this.model = model;
    }

    /**
     * onPreExecute()
     * Called on the main thread
     */
    protected void onPreExecute() {
        super.onPreExecute();
        /*
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.progressbar_layout);
        progressBar = (ProgressBar)dialog.findViewById(R.id.progressbar);
        progressBar.setProgress(5);
        dialog.show();
        */
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
    }
    // youtube api key
    // AIzaSyBFPWRNE0FiNMuyeSuztuYTNYQsy8oiqFM

    // AIzaSyD2K14rDsXszx7neG_BxA_F_cdVLJUgTUU
    @Override
    protected String doInBackground(String... params) {
        BufferedReader bufferedReader;
        HttpURLConnection urlConnection = null;
        String line;
        String results;
        StringBuilder builder;
        URL url;

        int i = 0;

        try {
            publishProgress(i);
            url = new URL(params[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            int code = urlConnection.getResponseCode();

            if(code != 200) {
                throw new IOException("Invalid response from server: " + code);
            }

            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            builder = new StringBuilder();

            while((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            if(builder.length() == 0) {
                return null;
            }

            results = builder.toString();
            i++;

            return results;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }

    protected void onProgressUpdate(Integer... values) {
        //super.onProgressUpdate(values);

        progressBar.setProgress(values[0]);
        //tvLoading.setText("Loading..." + values[0] + " %");
        //tvPer.setText(values[0] + " %");
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        progressBar.setVisibility(View.GONE);

        try {
            JSONObject root = new JSONObject(result);
            JSONArray list = root.getJSONArray("drinks"); // Drinks[] is an array of objects

            // Each json value that gets returned, will have its value added to the model
            for(int i = 0; i < list.length(); i++) {
                model.add(new Model(
                        list.getJSONObject(i).getString("idDrink"),
                        list.getJSONObject(i).getString("strDrink"),
                        list.getJSONObject(i).getString("strDrinkAlternate"),
                        list.getJSONObject(i).getString("strTags"),
                        list.getJSONObject(i).getString("strVideo"),
                        list.getJSONObject(i).getString("strCategory"),
                        list.getJSONObject(i).getString("strIBA"),
                        list.getJSONObject(i).getString("strAlcoholic"),
                        list.getJSONObject(i).getString("strGlass"),
                        list.getJSONObject(i).getString("strInstructions"),
                        list.getJSONObject(i).getString("strInstructionsES"),
                        list.getJSONObject(i).getString("strInstructionsDE"),
                        list.getJSONObject(i).getString("strInstructionsFR"),
                        list.getJSONObject(i).getString("strInstructionsIT"),
                        list.getJSONObject(i).getString("strInstructionsZH-HANS"),
                        list.getJSONObject(i).getString("strInstructionsZH-HANT"),
                        list.getJSONObject(i).getString("strDrinkThumb"),
                        list.getJSONObject(i).getString("strIngredient1"),
                        list.getJSONObject(i).getString("strIngredient2"),
                        list.getJSONObject(i).getString("strIngredient3"),
                        list.getJSONObject(i).getString("strIngredient4"),
                        list.getJSONObject(i).getString("strIngredient5"),
                        list.getJSONObject(i).getString("strIngredient6"),
                        list.getJSONObject(i).getString("strIngredient7"),
                        list.getJSONObject(i).getString("strIngredient8"),
                        list.getJSONObject(i).getString("strIngredient9"),
                        list.getJSONObject(i).getString("strIngredient10"),
                        list.getJSONObject(i).getString("strIngredient11"),
                        list.getJSONObject(i).getString("strIngredient12"),
                        list.getJSONObject(i).getString("strIngredient13"),
                        list.getJSONObject(i).getString("strIngredient14"),
                        list.getJSONObject(i).getString("strIngredient15"),
                        list.getJSONObject(i).getString("strMeasure1"),
                        list.getJSONObject(i).getString("strMeasure2"),
                        list.getJSONObject(i).getString("strMeasure3"),
                        list.getJSONObject(i).getString("strMeasure4"),
                        list.getJSONObject(i).getString("strMeasure5"),
                        list.getJSONObject(i).getString("strMeasure6"),
                        list.getJSONObject(i).getString("strMeasure7"),
                        list.getJSONObject(i).getString("strMeasure8"),
                        list.getJSONObject(i).getString("strMeasure9"),
                        list.getJSONObject(i).getString("strMeasure10"),
                        list.getJSONObject(i).getString("strMeasure11"),
                        list.getJSONObject(i).getString("strMeasure12"),
                        list.getJSONObject(i).getString("strMeasure13"),
                        list.getJSONObject(i).getString("strMeasure14"),
                        list.getJSONObject(i).getString("strMeasure15"),
                        list.getJSONObject(i).getString("strImageSource"),
                        list.getJSONObject(i).getString("strImageAttribution"),
                        list.getJSONObject(i).getString("strCreativeCommonsConfirmed"),
                        list.getJSONObject(i).getString("dateModified")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // LinearLayManager is the default
        // this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        this.recyclerView.setAdapter(new AdapterRecyclerView(model));
    }
}