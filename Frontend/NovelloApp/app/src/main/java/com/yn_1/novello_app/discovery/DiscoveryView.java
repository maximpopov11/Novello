package com.yn_1.novello_app.discovery;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.cart.CartModel;
import com.yn_1.novello_app.cart.CartPresenter;
import com.yn_1.novello_app.library.LibraryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * View for the discovery screen
 */
public class DiscoveryView extends Fragment {

    DiscoveryPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: get to cart from nav bar
        //todo: leave cart through nav bar
        super.onCreate(savedInstanceState);

        presenter = new DiscoveryPresenter(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * Displays recommended books
     * @param recommendations
     */
    public void showRecommendedBooks(ArrayList<Pair<Book, Double>> recommendations) {

        //todo: show all recommended books in scroll view

    }

}
