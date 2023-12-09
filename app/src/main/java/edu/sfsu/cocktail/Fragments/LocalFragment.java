package edu.sfsu.cocktail.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.sfsu.cocktail.Data.Article;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocalFragment extends ListFragment {
    List<Article> article = new ArrayList<>();
    private long id;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LocalFragment() {
        // super(R.layout.fragment_local);
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocalFragment newInstance(String param1, String param2) {
        LocalFragment fragment = new LocalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     *
     * onCreateView - populates the List<Article> with data
     */

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        article.add(new Article(0, "California Governor Gavin Newsome advances water tunnel project amid apposition from environmental groups", "2188"));
        article.add(new Article(1, "Traffic reporter responds on live TV to body-shaming email", "1904"));
        article.add(new Article(2, "A CBS reporter refusing to reveal her sources could be held in contemptA CBS reporter refusing to reveal her sources could be held in contempt", "1234"));
        article.add(new Article(3, "Seattle cancels plan for privately funded playground at nude beach", "2003"));
        article.add(new Article(4, "Man sentenced to prison for flashing WSU students", "8988"));
        article.add(new Article(5, "US Government Wants Hunters to Shoot 500,000 Owls", "4456"));
        article.add(new Article(6, "Traffic reporter responds on live TV to body-shaming email", "1904"));
        article.add(new Article(7, "A CBS reporter refusing to reveal her sources could be held in contemptA CBS reporter refusing to reveal her sources could be held in contempt", "1234"));
        article.add(new Article(8, "Seattle cancels plan for privately funded playground at nude beach", "2003"));
        article.add(new Article(9, "Man sentenced to prison for flashing WSU students", "8988"));
        article.add(new Article(10, "US Government Wants Hunters to Shoot 500,000 Owls", "4456"));

        int listSize = article.size();

        String[] name = new String[listSize];

        for(int i = 0; i < article.size(); i++) {
            name[i] = article.get(i).getTitle();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, name);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // pass the workout id to the fragment
    public void setId(long id) {
       this.id = id;
    }
}