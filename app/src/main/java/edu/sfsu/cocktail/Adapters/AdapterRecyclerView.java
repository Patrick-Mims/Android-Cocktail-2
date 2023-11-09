package edu.sfsu.cocktail.Adapters;

import static edu.sfsu.cocktail.DetailActivity.EXTRA_ID;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sfsu.cocktail.DetailActivity;
import edu.sfsu.cocktail.Models.Model;
import edu.sfsu.cocktail.R;


public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    static Context context;
    ArrayList<Model> model;
    public AdapterRecyclerView(ArrayList<Model> model) {
        this.model = model;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView strId, idDrink, strDrink, strTags, strVideo, strCategory, strIBA, strAlcoholic, strGlass;
        TextView strInstructions, strInstructionsES, strInstructionsDE, strInstructionsFR, strInstructionsIT, strInstructionsZH_HANS, strInstructionsZH_HANT;
        TextView strDrinkThumb, strIngredient1, strIngredient2, strIngredient3, strIngredient4, strIngredient5, strIngredient6, strIngredient7, strIngredient8, strIngredient9, strIngredient10, strIngredient11, strIngredient12, strIngredient13, strIngredient14, strIngredient15;
        TextView strMeasure1, strMeasure2, strMeasure3, strMeasure4, strMeasure5, strMeasure6, strMeasure7, strMeasure8, strMeasure9, strMeasure10, strMeasure11, strMeasure12, strMeasure13, strMeasure14, strMeasure15;
        TextView ststrImageSource, strImageAttribution, strCreativeCommonsConfirmed, dateModified;

        ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.strId = view.findViewById(R.id.idDrink);
            this.imageView = view.findViewById(R.id.idImage);
        }
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    int imageHeight, imageWidth;
    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {
        imageHeight = 300;
        imageWidth = holder.imageView.getWidth();

        Model mod = model.get(position);

        holder.strId.setText(String.format("%s", mod.getIdDrink()));
        holder.strDrink.setText(String.format("%s", mod.getStrDrink()));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_ID, mod.getIdDrink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}