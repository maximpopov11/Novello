package com.yn_1.novello_app.cart;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.Const;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;
import com.yn_1.novello_app.library.LibraryFragmentDirections;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart screen view
 */
public class CartView extends Fragment {

    CartPresenter presenter;

    User user;
    ArrayList<Book> cart;

    Button purchase;
    LinearLayout innerLayout;

    final int Image_Width = 175;
    final int Image_Height = 280;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        presenter = new CartPresenter(this);

        user = ((NavBarActivity)getActivity()).getUser();
        presenter.setUser(user);

        presenter.getCartBooks();

        purchase.setOnClickListener(v -> {

            float[] prices = new float[cart.size()];
            int[] ids = new int[cart.size()];
            for (int i = 0; i < cart.size(); i++) {
                prices[i] = (float)cart.get(i).getPrice();
                ids[i] = cart.get(i).getBookID();
            }

            CartViewDirections.ActionCartViewToPurchaseFragment action =
                    CartViewDirections.actionCartViewToPurchaseFragment(null, null, null);
            action.setUserID(user.getUserId());
            action.setCartPrices(prices);
            action.setCartIDs(ids);
            ((NavBarActivity)getActivity()).getController().navigate(action);

        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        purchase = view.findViewById(R.id.purchase);
        innerLayout = view.findViewById(R.id.cartLinearLayoutInner);

    }

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
            //todo: remove from cart button
            //todo: move to wishlist button

            //image button
            ImageButton imageButton = new ImageButton(getView().getContext());
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(Image_Width, Image_Height);
            imageParams.setMargins(15, 0, 15, 0);
            imageButton.setLayoutParams(imageParams);
            imageButton.setBackgroundColor(Color.YELLOW);
            presenter.model.assignImageToBook(book, imageButton);
            innerLayout.addView(book.getImageButton());

            imageButton.setOnClickListener(v -> {
                //todo: image button on click
            });

            //book info
            TextView textView = new TextView(getView().getContext());
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(Image_Width, Image_Height);
            textParams.setMargins(Image_Width + 15, 15, 15, 15);
            textView.setLayoutParams(textParams);
            textView.setText("Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\n" + "Price: $" + book.getPrice());
            innerLayout.addView(textView);

            book.setImageButton(imageButton);

        }
    }

}
