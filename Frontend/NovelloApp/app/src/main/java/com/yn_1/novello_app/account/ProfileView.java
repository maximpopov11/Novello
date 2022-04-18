package com.yn_1.novello_app.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;

/**
 * Profile screen view
 */
public class ProfileView extends Fragment {

    ProfilePresenter presenter;

    User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        presenter = new ProfilePresenter(this);

        user = ((NavBarActivity)getActivity()).getUser();
        presenter.setUser(user);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile_view, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
