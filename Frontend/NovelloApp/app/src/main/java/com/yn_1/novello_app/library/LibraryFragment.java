package com.yn_1.novello_app.library;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;

import com.yn_1.novello_app.R;
import com.yn_1.novello_app.account.User;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LibraryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LibraryFragment extends Fragment implements LibraryContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // private static final User CURRENT_USER;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private User currentUser;

    LibraryContract.Presenter presenter;
    LibraryContract.Model model;

    // Fragment components
    List<HorizontalScrollView> categories;
    HorizontalScrollView currentlyReadingView;
    HorizontalScrollView wishlistView;
    HorizontalScrollView readView;


    public LibraryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LibraryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LibraryFragment newInstance(String param1, String param2) {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            currentUser = getArguments().getParcelable(Integer.toString(currentUser.hashCode()));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }


    @Override
    public void displayAllBooks(Book[] books) {
        for (Book book : books) {
            for (String categoryID : book.categoryID) {
                for (HorizontalScrollView realCategory : categories) {
                    if (categoryID != realCategory.toString())
                    {
                        ImageButton button = model.createImageFromBook(book);
                        realCategory.addView(button);
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