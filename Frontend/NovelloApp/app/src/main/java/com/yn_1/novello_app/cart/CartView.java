package com.yn_1.novello_app.cart;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.Const;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart screen view
 */
public class CartView extends Fragment {

    CartPresenter presenter;

    User user;

    Button purchase;
    LinearLayout innerLayout;

    final int Image_Width = 175;
    final int Image_Height = 280;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: get to cart from nav bar
        //todo: leave cart through nav bar
        super.onCreate(savedInstanceState);

        presenter = new CartPresenter(this);

        user = ((NavBarActivity)getActivity()).getUser();
        presenter.setUser(user);

        purchase.findViewById(R.id.purchase);
        innerLayout.findViewById(R.id.cartLinearLayoutInner);

        presenter.getCartBooks();

        purchase.setOnClickListener(v -> {
            presenter.purchaseClicked(this);
        });

    }

    public void sendCart(ArrayList<Book> cart) {
        addBooksToLayout(cart);
    }

    /**
     * Adds book information to cart screen
     * @param cartBooks are the books to add
     */
    private void addBooksToLayout(List<Book> cartBooks) {
        for (Book book : cartBooks) {
            //todo: show book info in rows: imageButton, title, author, price, remove from cart button, move to wishlist
            ImageButton imageButton = new ImageButton(getView().getContext());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Image_Width, Image_Height);
            params.setMargins(15, 0, 15, 0);
            imageButton.setLayoutParams(params);
            imageButton.setBackgroundColor(Color.YELLOW);
            //todo: set image bitmap

            imageButton.setOnClickListener(v -> {
                //todo: image button on click
            });

            book.setImageButton(imageButton);

            innerLayout.addView(book.getImageButton());
        }
    }

}
