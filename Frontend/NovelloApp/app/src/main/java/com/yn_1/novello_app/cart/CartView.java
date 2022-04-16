package com.yn_1.novello_app.cart;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.Const;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.*;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart screen view
 */
public class CartView extends Fragment {

    CartPresenter presenter;

    User user;
    ArrayList<Book> cart = new ArrayList<>();

    Button purchase;
    LinearLayout innerLayout;

    final int Text_Width = 500;
    final int Text_Height = 300;
    final int Image_Width = 175;
    final int Image_Height = 280;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        presenter = new CartPresenter(this);

        user = ((NavBarActivity)getActivity()).getUser();
        presenter.setUser(user);

        presenter.getCartBooks();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("Cart", "CartView entered on create view.");

        return inflater.inflate(R.layout.fragment_cart, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Cart", "CartView entered on view created.");

        purchase = view.findViewById(R.id.purchase);
        innerLayout = view.findViewById(R.id.cartLinearLayoutInner);

        purchase.setOnClickListener(v -> {

            float[] prices = new float[cart.size()];
            int[] ids = new int[cart.size()];
            for (int i = 0; i < cart.size(); i++) {
                prices[i] = (float)cart.get(i).getPrice();
                ids[i] = cart.get(i).getBookID();
            }

            CartViewDirections.ActionCartViewToPurchaseFragment action =
                    CartViewDirections.actionCartViewToPurchaseFragment();
            action.setUserID(user.getUserId());
            action.setCartPrices(prices);
            action.setCartIDs(ids);
            ((NavBarActivity)getActivity()).getController().navigate(action);

        });

    }

    /**
     * Receives the cart from the presenter
     * @param cart: array list of books
     */
    public void sendCart(ArrayList<Book> cart) {
        this.cart = cart;
        addBooksToLayout(cart);
    }

    /**
     * Adds book information to cart screen
     * @param cartBooks are the books to add
     */
    private void addBooksToLayout(List<Book> cartBooks) {
        for (Book book : cartBooks) {
            //todo: create sample ui and insert book info for each book, creating a new version with each book

            //todo: remove from cart button
            //todo: move to wishlist button

            //todo: add book image button

            //book info
            TextView textView = new TextView(getView().getContext());
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(Text_Width, Text_Height);
            textParams.setMargins(5, 5, 5, 5);
            textView.setLayoutParams(textParams);
            textView.setText("Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\n" + "Price: $" + book.getPrice());
            innerLayout.addView(textView);

        }
    }

}
