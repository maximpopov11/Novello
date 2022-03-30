package com.yn_1.novello_app.cart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;

/**
 * Cart screen
 */
public class CartFragment extends Fragment {

    Button purchase;
    LinearLayout innerLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: get to cart from nav bar
        //todo: leave cart through nav bar
        super.onCreate(savedInstanceState);

        purchase.findViewById(R.id.purchase);
        innerLayout.findViewById(R.id.cartLinearLayoutInner);

        addBooksToLayout();

        purchase.setOnClickListener(v -> {
            //todo: leave cart through pay screen
        });

    }

    private void addBooksToLayout() {
        Book[] cartBooks =
                {new Book(0, "book 1", "author 1", 0, "isbn1", 0,"imageURL1"),
                new Book(0, "book 1", "author 1", 0, "isbn2", 0, "imageURL2")};
        for (Book book : cartBooks) {
            //todo: show book image
            //innerLayout.addView(book.getImage());
            //todo: show book info (price, author, etc.) next to image
        }
    }

}
