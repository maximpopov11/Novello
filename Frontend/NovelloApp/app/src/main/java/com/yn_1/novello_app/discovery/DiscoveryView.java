package com.yn_1.novello_app.discovery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.cart.CartModel;
import com.yn_1.novello_app.cart.CartPresenter;
import com.yn_1.novello_app.library.LibraryFragment;

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

}
