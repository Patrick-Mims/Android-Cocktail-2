package edu.sfsu.cocktail.Adapters;

import static edu.sfsu.cocktail.DetailActivity.EXTRA_ID;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
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
    Context context;
    ArrayList<Model> model;
    public AdapterRecyclerView(ArrayList<Model> model) {
        this.model = model;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idDrink;
        TextView strDrink;
        TextView strDrinkAlternate;
        TextView strTags;
        TextView strVideo;
        TextView strCategory;
        TextView strIBA;
        TextView strAlcoholic;
        TextView strGlass;
        TextView strInstructions;
        TextView strInstructionsES;
        TextView strInstructionsDE;
        TextView strInstructionsFR;
        TextView strInstructionsIT;
        TextView strInstructionsZH_HANS;
        TextView strInstructionsZH_HANT;
        TextView strDrinkThumb;
        TextView strIngredient1;
        TextView strIngredient2;
        TextView strIngredient3;
        TextView strIngredient4;
        TextView strIngredient5;
        TextView strIngredient6;
        TextView strIngredient7;
        TextView strIngredient8;
        TextView strIngredient9;
        TextView strIngredient10;
        TextView strIngredient11;
        TextView strIngredient12;
        TextView strIngredient13;
        TextView strIngredient14;
        TextView strIngredient15;
        TextView strMeasure1;
        TextView strMeasure2;
        TextView strMeasure3;
        TextView strMeasure4;
        TextView strMeasure5;
        TextView strMeasure6;
        TextView strMeasure7;
        TextView strMeasure8;
        TextView strMeasure9;
        TextView strMeasure10;
        TextView strMeasure11;
        TextView strMeasure12;
        TextView strMeasure13;
        TextView strMeasure14;
        TextView strMeasure15;
        TextView strImageSource;
        TextView strImageAttribution;
        TextView strCreativeCommonsConfirmed;
        TextView dateModified;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.idDrink = view.findViewById(R.id.idDrink);
            this.strDrink = view.findViewById(R.id.strDrink);
            this.strDrinkAlternate = view.findViewById(R.id.strDrinkAlternate);
            this.strTags = view.findViewById(R.id.strTags);
            this.strVideo = view.findViewById(R.id.strVideo);
            this.strCategory = view.findViewById(R.id.strCategory);
            this.strIBA = view.findViewById(R.id.strIBA);
            this.strAlcoholic = view.findViewById(R.id.strAlcoholic);
            this.strGlass = view.findViewById(R.id.strGlass);
            this.strInstructions = view.findViewById(R.id.strInstructions);
            this.strInstructionsES = view .findViewById(R.id.strInstructionsES);
            this.strInstructionsDE = view .findViewById(R.id.strInstructionsDE);
            this.strInstructionsFR = view .findViewById(R.id.strInstructionsFR);
            this.strInstructionsIT = view .findViewById(R.id.strInstructionsIT);
            this.strInstructionsZH_HANS = view .findViewById(R.id.strInstructionsZH_HANS);
            this.strInstructionsZH_HANT = view .findViewById(R.id.strInstructionsZH_HANT);
            this.strDrinkThumb = view.findViewById(R.id.strDrinkThumb);
            this.strIngredient1 = view.findViewById(R.id.strIngredient1);
            this.strIngredient2 = view.findViewById(R.id.strIngredient2);
            this.strIngredient3 = view.findViewById(R.id.strIngredient3);
            this.strIngredient4 = view.findViewById(R.id.strIngredient4);
            this.strIngredient5 = view.findViewById(R.id.strIngredient5);
            this.strIngredient6 = view.findViewById(R.id.strIngredient6);
            this.strIngredient7 = view.findViewById(R.id.strIngredient7);
            this.strIngredient8 = view.findViewById(R.id.strIngredient8);
            this.strIngredient9 = view.findViewById(R.id.strIngredient9);
            this.strIngredient10 = view.findViewById(R.id.strIngredient10);
            this.strIngredient11 = view.findViewById(R.id.strIngredient11);
            this.strIngredient12 = view.findViewById(R.id.strIngredient12);
            this.strIngredient13 = view.findViewById(R.id.strIngredient13);
            this.strIngredient14 = view.findViewById(R.id.strIngredient14);
            this.strIngredient15 = view.findViewById(R.id.strIngredient15);
            this.strMeasure1 = view.findViewById(R.id.strMeasure1);
            this.strMeasure2 = view.findViewById(R.id.strMeasure2);
            this.strMeasure3 = view.findViewById(R.id.strMeasure3);
            this.strMeasure4 = view.findViewById(R.id.strMeasure4);
            this.strMeasure5 = view.findViewById(R.id.strMeasure5);
            this.strMeasure6 = view.findViewById(R.id.strMeasure6);
            this.strMeasure7 = view.findViewById(R.id.strMeasure7);
            this.strMeasure8 = view.findViewById(R.id.strMeasure8);
            this.strMeasure9 = view.findViewById(R.id.strMeasure9);
            this.strMeasure10 = view.findViewById(R.id.strMeasure10);
            this.strMeasure11 = view.findViewById(R.id.strMeasure11);
            this.strMeasure12 = view.findViewById(R.id.strMeasure12);
            this.strMeasure13 = view.findViewById(R.id.strMeasure13);
            this.strMeasure14 = view.findViewById(R.id.strMeasure14);
            this.strMeasure15 = view.findViewById(R.id.strMeasure15);
            this.strImageSource = view.findViewById(R.id.strImageSource);
            this.strImageAttribution = view.findViewById(R.id.strImageAttribution);
            this.strCreativeCommonsConfirmed = view.findViewById(R.id.strCreativeCommonsConfirmed);
            this.dateModified = view.findViewById(R.id.dateModified);
        }
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model mod = model.get(position);

        holder.idDrink.setText(String.format("%s", mod.getIdDrink()));
        holder.strDrink.setText(String.format("%s", mod.getStrDrink()));
        holder.strDrinkAlternate.setText(String.format("%s", mod.getStrDrinkAlternate()));
        holder.strTags.setText(String.format("%s", mod.getStrTags()));
        holder.strVideo.setText(String.format("%s", mod.getStrVideo()));
        holder.strCategory.setText(String.format("%s", mod.getStrCategory()));
        holder.strIBA.setText(String.format("%s", mod.getStrIBA()));
        holder.strAlcoholic.setText(String.format("%s", mod.getStrAlcoholic()));
        holder.strGlass.setText(String.format("%s", mod.getStrGlass()));
        holder.strInstructions.setText(String.format("%s", mod.getStrInstructions()));
        holder.strInstructionsES.setText(String.format("%s", mod.getStrInstructionsES()));
        holder.strInstructionsDE.setText(String.format("%s", mod.getStrInstructionsDE()));
        holder.strInstructionsFR.setText(String.format("%s", mod.getStrInstructionsFR()));
        holder.strInstructionsIT.setText(String.format("%s", mod.getStrInstructionsIT()));
        holder.strInstructionsZH_HANS.setText(String.format("%s", mod.getStrInstructionsZH_HANS()));
        holder.strInstructionsZH_HANT.setText(String.format("%s", mod.getStrInstructionsZH_HANT()));
        holder.strDrinkThumb.setText(String.format("%s", mod.getStrDrinkThumb()));
        holder.strIngredient1.setText(String.format("%s", mod.getStrIngredient1()));
        holder.strIngredient2.setText(String.format("%s", mod.getStrIngredient2()));
        holder.strIngredient3.setText(String.format("%s", mod.getStrIngredient3()));
        holder.strIngredient4.setText(String.format("%s", mod.getStrIngredient4()));
        holder.strIngredient5.setText(String.format("%s", mod.getStrIngredient5()));
        holder.strIngredient6.setText(String.format("%s", mod.getStrIngredient6()));
        holder.strIngredient7.setText(String.format("%s", mod.getStrIngredient7()));
        holder.strIngredient8.setText(String.format("%s", mod.getStrIngredient8()));
        holder.strIngredient9.setText(String.format("%s", mod.getStrIngredient9()));
        holder.strIngredient10.setText(String.format("%s", mod.getStrIngredient10()));
        holder.strIngredient11.setText(String.format("%s", mod.getStrIngredient11()));
        holder.strIngredient12.setText(String.format("%s", mod.getStrIngredient12()));
        holder.strIngredient13.setText(String.format("%s", mod.getStrIngredient13()));
        holder.strIngredient14.setText(String.format("%s", mod.getStrIngredient14()));
        holder.strIngredient15.setText(String.format("%s", mod.getStrIngredient15()));
        holder.strMeasure1.setText(String.format("%s", mod.getStrMeasure1()));
        holder.strMeasure2.setText(String.format("%s", mod.getStrMeasure2()));
        holder.strMeasure3.setText(String.format("%s", mod.getStrMeasure3()));
        holder.strMeasure4.setText(String.format("%s", mod.getStrMeasure4()));
        holder.strMeasure5.setText(String.format("%s", mod.getStrMeasure5()));
        holder.strMeasure6.setText(String.format("%s", mod.getStrMeasure6()));
        holder.strMeasure7.setText(String.format("%s", mod.getStrMeasure7()));
        holder.strMeasure8.setText(String.format("%s", mod.getStrMeasure8()));
        holder.strMeasure9.setText(String.format("%s", mod.getStrMeasure9()));
        holder.strMeasure10.setText(String.format("%s", mod.getStrMeasure10()));
        holder.strMeasure11.setText(String.format("%s", mod.getStrMeasure11()));
        holder.strMeasure12.setText(String.format("%s", mod.getStrMeasure12()));
        holder.strMeasure13.setText(String.format("%s", mod.getStrMeasure13()));
        holder.strMeasure14.setText(String.format("%s", mod.getStrMeasure14()));
        holder.strMeasure15.setText(String.format("%s", mod.getStrMeasure15()));
        holder.strImageSource.setText(String.format("%s", mod.getStrImageSource()));
        holder.strImageAttribution.setText(String.format("%s", mod.getStrImageAttribution()));
        holder.strCreativeCommonsConfirmed.setText(String.format("%s", mod.getStrCreativeCommonsConfirmed()));
        holder.dateModified.setText(String.format("%s", mod.getDateModified()));

        holder.strDrinkThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(EXTRA_ID, mod.getIdDrink());
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}