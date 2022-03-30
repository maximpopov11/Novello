package com.yn_1.novello_app.cart;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.R;

public class PurchaseFragment extends Fragment {

    Button finish;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //todo: leave purchase through nav bar
        super.onCreate(savedInstanceState);

        finish.findViewById(R.id.finishPurchase);

        finish.setOnClickListener(v -> {
            //todo: complete transaction
            //todo: go to dashbaord
        });

    }

}
