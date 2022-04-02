package com.yn_1.novello_app.book;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yn_1.novello_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment implements BookContract.View {

    private BookContract.Presenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private TextView titleText;
    private TextView authorText;
    private TextView publicationYearText;
    private TextView isbnText;
    private RatingBar ratingBar;
    private TextView ratingText;
    private TextView descriptionText;

    // TODO: Rename and change types of parameters
    private int bookID;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bookID Parameter 1.
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(int bookID) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, bookID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookID = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create a new book presenter instance, that holds a book model instance
        presenter = new BookPresenter(new BookModel(), this);

        // Receives data
        presenter.beforeViewCreated();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleText = view.findViewById(R.id.titleText);
        authorText = view.findViewById(R.id.authorText);
        publicationYearText = view.findViewById(R.id.publicationYearText);
        isbnText = view.findViewById(R.id.isbnText);
        ratingBar = view.findViewById(R.id.ratingBar);
        ratingText = view.findViewById(R.id.ratingText);
        descriptionText = view.findViewById(R.id.descriptionText);
    }

    @Override
    public void startPresenter() {
        presenter.onViewCreated();
    }

    @Override
    public void displayComponents(Book book) {
        titleText.setText(book.getTitle());
        authorText.setText(book.getAuthor());
        publicationYearText.setText(book.getPublicationYear());
        isbnText.setText(book.getISBN());
        ratingBar.setRating(book.getRating());
        ratingText.setText(book.getRating());
        descriptionText.setText(book.getPublicationYear());
    }
}