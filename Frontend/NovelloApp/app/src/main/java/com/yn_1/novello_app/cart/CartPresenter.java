package com.yn_1.novello_app.cart;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;

import java.util.List;

/**
 * Cart screen presenter
 */
public class CartPresenter {

    CartModel model;
    User user = null;

    /**
     * Constructor. Creates model.
     */
    public CartPresenter() {
        model = new CartModel();
    }

    /**
     * @return books in cart
     */
    public List<Book> getCartBooks() {
        return model.getCartBooks();
    }

    /**
     * Sets user for Presenter and Model
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        model.setUser(user);
    }

    /**
     * Purchase clicked
     * @param cartView
     */
    public void purchaseClicked(CartView cartView) {
        openPurchase(cartView);
    }

    /**
     * Goes to purchase screen
     * @param cartView
     */
    public void openPurchase(CartView cartView) {
        //todo: test leave cart through pay screens
        Fragment libraryFragment = LibraryFragment.newInstance();
        cartView.getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                libraryFragment).addToBackStack(null).commit();
    }

}
