package com.yn_1.novello_app.cart;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.AdultUser;
import com.yn_1.novello_app.account.LoginActivity;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

public class PurchaseFragment extends Fragment {

    Button finish;
    EditText creditCardInput;
    String creditCardNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: leave purchase through nav bar
        super.onCreate(savedInstanceState);

        finish.findViewById(R.id.finishPurchase);
        creditCardInput.findViewById(R.id.creditCardInput);
        //todo: show total price and list of book titles in vertical scroll view

        finish.setOnClickListener(v -> {
            creditCardNumber = creditCardInput.getText().toString();
            JsonObjectRequester purchaseRequester = new JsonObjectRequester();
            JsonObjectCommand command = new JsonObjectCommand();
            //todo: add cart information to purchaseJson
            JSONObject purchaseJson = new JSONObject();
            try {
                purchaseJson.put("CreditCardNumber", creditCardNumber);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //todo: test next line
            purchaseRequester.postRequest("cart", purchaseJson, command, null, null);
            //todo: complete transaction
        });

    }

    /**
     * Goes to dashboard upon successful purchase completion
     * @param succeeded is true if the purchase was successful
     */
    private void purchaseResult(boolean succeeded) {
        //todo: go to dashbaord
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
