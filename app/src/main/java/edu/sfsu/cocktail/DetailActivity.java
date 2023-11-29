package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.sfsu.cocktail.ViewModel.DrinkViewModel;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "ID";
    public static final String EXTRA_DRINK = "DRINK";
    public static final String EXTRA_DRINK_ALTERNATE = "DRINK_ALTERNATE";
    public static final String EXTRA_STR_TAGS = "STR_TAGS";
    public static final String EXTRA_STR_VIDEO = "STR_VIDEO";
    public static final String EXTRA_STR_CATEGORY = "STR_CATEGORY";
    public static final String EXTRA_STR_IBA = "STR_IBA";
    public static final String EXTRA_STR_ALCOHOLIC = "STR_ALCOHOLIC";
    public static final String EXTRA_STR_GLASS = "STR_GLASS";
    public static final String EXTRA_STR_INSTRUCTIONS = "STR_INSTRUCTIONS";
    public static final String EXTRA_STR_DRINK_THUMB = "STR_DRINK_THUMB";
    public static final String EXTRA_STR_INGREDIENT1 = "STR_INGREDIENT1";
    public static final String EXTRA_STR_INGREDIENT2 = "STR_INGREDIENT2";
    public static final String EXTRA_STR_INGREDIENT3 = "STR_INGREDIENT3";
    public static final String EXTRA_STR_INGREDIENT4 = "STR_INGREDIENT4";
    public static final String EXTRA_STR_INGREDIENT5 = "STR_INGREDIENT5";
    public static final String EXTRA_STR_INGREDIENT6 = "STR_INGREDIENT6";
    public static final String EXTRA_STR_INGREDIENT7 = "STR_INGREDIENT7";
    public static final String EXTRA_STR_INGREDIENT8 = "STR_INGREDIENT8";
    public static final String EXTRA_STR_INGREDIENT9 = "STR_INGREDIENT9";
    public static final String EXTRA_STR_INGREDIENT10 = "STR_INGREDIENT10";
    public static final String EXTRA_STR_INGREDIENT11 = "STR_INGREDIENT11";
    public static final String EXTRA_STR_INGREDIENT12 = "STR_INGREDIENT12";
    public static final String EXTRA_STR_INGREDIENT13 = "STR_INGREDIENT13";
    public static final String EXTRA_STR_INGREDIENT14 = "STR_INGREDIENT14";
    public static final String EXTRA_STR_INGREDIENT15 = "STR_INGREDIENT15";
    public static final String EXTRA_STR_MEASURE1 = "STR_MEASURE1";
    public static final String EXTRA_STR_MEASURE2 = "STR_MEASURE2";
    public static final String EXTRA_STR_MEASURE3 = "STR_MEASURE3";
    public static final String EXTRA_STR_MEASURE4 = "STR_MEASURE4";
    public static final String EXTRA_STR_MEASURE5 = "STR_MEASURE5";
    public static final String EXTRA_STR_MEASURE6 = "STR_MEASURE6";
    public static final String EXTRA_STR_MEASURE7 = "STR_MEASURE7";
    public static final String EXTRA_STR_MEASURE8 = "STR_MEASURE8";
    public static final String EXTRA_STR_MEASURE9 = "STR_MEASURE9";
    public static final String EXTRA_STR_MEASURE10 = "STR_MEASURE10";
    public static final String EXTRA_STR_MEASURE11 = "STR_MEASURE11";
    public static final String EXTRA_STR_MEASURE12 = "STR_MEASURE12";
    public static final String EXTRA_STR_MEASURE13 = "STR_MEASURE13";
    public static final String EXTRA_STR_MEASURE14 = "STR_MEASURE14";
    public static final String EXTRA_STR_MEASURE15 = "STR_MEASURE15";
    DrinkViewModel drinkViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String id = getIntent().getStringExtra(EXTRA_ID);
        String drink = getIntent().getStringExtra(EXTRA_DRINK);
        String image = getIntent().getStringExtra(EXTRA_STR_DRINK_THUMB);

        ImageView imageView = findViewById(R.id.mainImg);
        TextView tv_drink = findViewById(R.id.mainDrink);
        TextView tv_id = findViewById(R.id.drinkID);

        Picasso.get().load(Uri.parse(image)).resize(700, 700).into(imageView);
        tv_id.setText(id);
        tv_drink.setText(drink);
    }
}