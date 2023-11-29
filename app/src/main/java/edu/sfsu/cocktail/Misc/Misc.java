package edu.sfsu.cocktail.Misc;

import android.content.Context;
import android.content.Intent;

import edu.sfsu.cocktail.DetailActivity;

public class Misc {
    public Misc() {

    }

    public Intent createIntent(Context context, String name, String value) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent.putExtra(name, value);
    }
}