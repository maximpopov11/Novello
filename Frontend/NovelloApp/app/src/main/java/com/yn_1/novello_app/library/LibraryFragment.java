package com.yn_1.novello_app.library;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;

import java.util.List;

public class LibraryFragment extends Fragment implements LibraryContract.View {

    private LibraryContract.Presenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    // Fragment components
    List<HorizontalScrollView> categories;
    HorizontalScrollView currentlyReadingView;
    HorizontalScrollView wishlistView;
    HorizontalScrollView readView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment LibraryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LibraryFragment newInstance(String param1) {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

        // Create a new library presenter instance, that holds a library model instance
        presenter = new LibraryPresenter(new LibraryModel(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get resources
        currentlyReadingView = view.findViewById(R.id.currentlyReadingView);
        wishlistView = view.findViewById(R.id.wishlistView);
        readView = view.findViewById(R.id.readView);

        // Start the presenter
        presenter.onViewCreated(((NavBarActivity)getActivity()).getUser(), getContext());
    }


    @Override
    public void displayAllBooks(List<Book> books) {
        for (Book book : books) {
            for (String categoryID : book.getUserCategoryId()) {
                for (HorizontalScrollView realCategory : categories) {
                    if (categoryID == realCategory.toString())
                    {
                        realCategory.addView(book.getImageButton());
                    }
                }
            }
        }
    }

    @Override
    public void displayBook(Book book) {
        Fragment bookFragment = new Fragment(); // TODO: Replace with real fragment
        getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                bookFragment).addToBackStack(null).commit();
    }
}