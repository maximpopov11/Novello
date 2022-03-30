package com.yn_1.novello_app.cart;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;

import java.util.List;

/**
 * Cart screen view
 */
public class CartView extends Fragment {

    CartPresenter presenter;
    CartModel model;

    Button purchase;
    LinearLayout innerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: get to cart from nav bar
        //todo: leave cart through nav bar
        super.onCreate(savedInstanceState);

        presenter = new CartPresenter();
        model = new CartModel();

        purchase.findViewById(R.id.purchase);
        innerLayout.findViewById(R.id.cartLinearLayoutInner);

        List<Book> cartBooks = presenter.getCartBooks();
        addBooksToLayout(cartBooks);

        purchase.setOnClickListener(v -> {
            //todo: test leave cart through pay screen
            Fragment libraryFragment = LibraryFragment.newInstance();
            getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    libraryFragment).addToBackStack(null).commit();
        });

    }

    private void addBooksToLayout(List<Book> cartBooks) {
        for (Book book : cartBooks) {
            ImageButton imageButton = new ImageButton(getView().getContext());
            //todo: show book image
            //innerLayout.addView(book.getImage());
            //todo: show book info (price, author, etc.) next to image
        }
    }

}
