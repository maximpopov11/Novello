package com.yn_1.novello_app.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.yn_1.novello_app.*;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.cart.CartViewDirections;

/**
 * Class representing the Home screen.
 */
public class HomeFragment extends Fragment {

    private ImageButton settings;
    private ImageButton profile;

    /**
     * Creates a new fragment instance, using specific arguments to be added to the bundle.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        settings = view.findViewById(R.id.settings);
        profile = view.findViewById(R.id.profile);

        settings.setOnClickListener(v -> {
            //todo: create drop down
        });

        profile.setOnClickListener(v -> {
            HomeFragmentDirections.ActionHomeFragmentToProfileView action =
                    HomeFragmentDirections.actionHomeFragmentToProfileView();
            action.setUserID(((NavBarActivity)getActivity()).getUser().getUserId());
            ((NavBarActivity)getActivity()).getController().navigate(action);
        });

    }
}