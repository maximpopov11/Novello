package com.yn_1.novello_app.cart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.library.LibraryFragment;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PurchaseFragment extends Fragment {

    Button finish;
    EditText creditCardInput;
    String creditCardNumber;
    TextView priceText;
    List<Book> cart;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: PRE DEMO: leave purchase through nav bar
        super.onCreate(savedInstanceState);

        finish.findViewById(R.id.finishPurchase);
        creditCardInput.findViewById(R.id.creditCardInput);
        priceText.findViewById(R.id.price);
        //todo: PRE DEMO: get cart from cart fragment
        //todo: show list of book titles/authors/prices in vertical scroll view

        double price = 0;
        for (Book book : cart) {
            price += book.getPrice();
        }
        priceText.setText("Price = $" + price);

        finish.setOnClickListener(v -> {
            creditCardNumber = creditCardInput.getText().toString();
            if (canChargeCard(creditCardNumber)) {
                JsonObjectRequester purchaseRequester = new JsonObjectRequester();
                JsonObjectCommand command = new JsonObjectCommand();
                //todo: 3 represents unread. Set that in an enum.
                //todo: PRE DEMO: get user and provide user id in request
                for (Book book : cart) {
                    purchaseRequester.postRequest("setCategory/" + book.getBookID() + "/" + "set this to userID" + "/" + 3,
                            null, command, null, null);
                }
            }
            else {
                //todo: card cannot be charged, do something about it
            }
        });

    }

    /**
     * @param creditCardNumber
     * @return true if the card can be charged
     */
    private boolean canChargeCard(String creditCardNumber) {
        //todo: move to user or other more appropriate location
        return true;
    }

    /**
     * @param creditCardNumber
     * @return true if the card was charged successfully
     */
    private boolean chargeCard(String creditCardNumber) {
        //todo: move to user or other more appropriate location
        return true;
    }

    /**
     * Goes to dashboard upon successful purchase completion
     * @param succeeded is true if the purchase was successful
     */
    private void purchaseResult(boolean succeeded) {
        if (chargeCard(creditCardNumber)) {
            //todo: PRE DEMO: go to dashboard
        }
        else {
            //todo: card could not be charged, do something about it
        }
    }

    /**
     * Class used to get result of request
     */
    private class JsonObjectCommand implements VolleyCommand<JSONObject> {

        @Override
        public void execute(JSONObject data) {
            purchaseResult(data != null);
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}
