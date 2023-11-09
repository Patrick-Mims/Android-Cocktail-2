package edu.sfsu.cocktail.Tasks;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.sfsu.cocktail.Adapters.AdapterRecyclerView;
import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataAsyncTask extends AsyncTask<String, Integer, String> {
    Dialog dialog;
    Context context;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<Model> model;
    TextView tvLoading, tvPer;

    public DataAsyncTask(Context context, RecyclerView recyclerView, ProgressBar progressBar, ArrayList<Model> model) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
        this.model = model;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.progressbar_layout);
        progressBar = (ProgressBar)dialog.findViewById(R.id.progressbar);
        progressBar.incrementProgressBy(50);
        //progressBar.setProgress(50);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        BufferedReader bufferedReader;
        HttpURLConnection urlConnection = null;
        String line;
        String results;
        StringBuilder builder;
        URL url;

        try {
            Log.v("TAG", "params[0] => " + params[0]);

            url = new URL(params[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            Log.v("TAG", "try throw block 2.0");

            int code = urlConnection.getResponseCode();

            Log.v("TAG", "reponse code " + code);

            if(code != 200) {
                Log.v("TAG", "Not 200");
                throw new IOException("Invalid response from server: " + code);
            }

            Log.v("TAG", "Is 200");

            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            builder = new StringBuilder();

            Log.v("TAG", "before while loop");

            while((line = bufferedReader.readLine()) != null) {
                Log.v("TAG", "line => " + line);
                builder.append(line).append("\n");
            }

            Log.v("TAG", "after while loop");

            if(builder.length() == 0) {
                return null;
            }

            results = builder.toString();

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
        super.onProgressUpdate(values);

        progressBar.setProgress(values[0]);
        tvLoading.setText("Loading..." + values[0] + " %");
        tvPer.setText(values[0] + " %");
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        dialog.dismiss();

        try {
            JSONObject root = new JSONObject(result);
            JSONArray list = root.getJSONArray("drinks");

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
                        list.getJSONObject(i).getString("strImageAttrition"),
                        list.getJSONObject(i).getString("strCreativeCommonsConfirmed"),
                        list.getJSONObject(i).getString("dateModified")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.recyclerView.setAdapter(new AdapterRecyclerView(model));
    }
}