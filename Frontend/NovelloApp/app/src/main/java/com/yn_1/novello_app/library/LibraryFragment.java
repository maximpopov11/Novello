package com.yn_1.novello_app.library;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.book.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment implements LibraryContract.View {

    // Presenter accessible from View
    private LibraryContract.Presenter presenter;

    // Fragment components
    List<HorizontalScrollView> categories;
    HorizontalScrollView currentlyReadingView;
    HorizontalScrollView wishlistView;
    HorizontalScrollView readView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LibraryFragment.
     */
    public static LibraryFragment newInstance() {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Set arguments
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new library presenter instance, that holds a library model instance
        presenter = new LibraryPresenter(new LibraryModel(), this);

        // Receives data
        presenter.beforeViewCreated(((NavBarActivity)getActivity()).getUser());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get resources
        currentlyReadingView = view.findViewById(R.id.currentlyReading);
        wishlistView = view.findViewById(R.id.wishlist);
        readView = view.findViewById(R.id.read);

        categories = new ArrayList<>();
        categories.add(currentlyReadingView);
        categories.add(wishlistView);
        categories.add(readView);
    }

    @Override
    public void startPresenter() {
        // Start the presenter
        presenter.onViewCreated(((NavBarActivity)getActivity()).getUser(), getContext());
    }


    @Override
    public void displayAllBooks(List<Book> books) {
        Log.d("Library", "displayAllBooks() reached");
        for (Book book : books) {
            for (HorizontalScrollView realCategory : categories) {
                Log.d("Library", getView().getResources().getResourceName(realCategory.getId()));
                if (getView().getResources().getResourceName(realCategory.getId()).equals("com.yn_1.novello_app:id/" + book.getUserCategoryId()))
                {
                    ((LinearLayout)realCategory.getChildAt(0)).addView(book.getImageButton());
                    Log.d("Library", book.getTitle() + "added");
                }
            }
        }
    }

    @Override
    public void displayBook(Book book) {
        LibraryFragmentDirections.ActionLibraryFragmentToBookFragment action =
                LibraryFragmentDirections.actionLibraryFragmentToBookFragment();
        action.setBookID(book.getBookID());
        ((NavBarActivity)getActivity()).getController().navigate(action);
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        presenter.createBookMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        presenter.onBookMenuItemSelected(item);
        return true;
    }
}