package com.yn_1.novello_app.book;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.yn_1.novello_app.R;

import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment implements BookContract.View {

    private BookContract.Presenter presenter;

    private TextView titleText;
    private TextView authorText;
    private TextView publicationYearText;
    private TextView isbnText;
    private RatingBar ratingBar;
    private TextView ratingText;
    private TextView priceText;
    private TextView descriptionText;
    private ImageView bookCoverView;
    private TableLayout reviewsTable;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance() {
        BookFragment fragment = new BookFragment();
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
        int bookID = BookFragmentArgs.fromBundle(getArguments()).getBookID();

        // Create a new book presenter instance, that holds a book model instance
        presenter = new BookPresenter(new BookModel(bookID), this);

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
        priceText = view.findViewById(R.id.priceText);
        descriptionText = view.findViewById(R.id.descriptionText);
        bookCoverView = view.findViewById(R.id.bookImageView);
        reviewsTable = view.findViewById(R.id.reviewsTable);
    }

    @Override
    public void startView() {
        presenter.onViewCreated();
    }

    @Override
    public void displayComponents(Book book) {
        titleText.setText(book.getTitle());
        String authorString = " Author: " + book.getAuthor();
        authorText.setText(authorString);
        String publicationString = " Publication Year: " + book.getPublicationYear();
        publicationYearText.setText(publicationString);
        String isbnString = " ISBN: " + book.getISBN();
        isbnText.setText(isbnString);
        ratingBar.setRating((float)book.getRating());
        String ratingString = "(" + book.getRating() + ")";
        ratingText.setText(ratingString);
        String priceString = " Price:  $" + book.getPrice();
        priceText.setText(priceString);
        String descriptionString = " Description: " + book.getDescription();
        descriptionText.setText(descriptionString);
        presenter.onDisplayBookCover(bookCoverView);
    }

    @Override
    public void populateReviewsTable(Map<Integer, String[]> reviews) {
        for (int i = 0; i < reviews.size(); i++) {
            TableRow row = new TableRow(getContext());

            TextView userID = new TextView(getContext());
            TextView userRating = new TextView(getContext());
            TextView userReview = new TextView(getContext());

            userID.setText(reviews.get(i)[0]);
            userRating.setText(reviews.get(i)[0]);
            userReview.setText(reviews.get(i)[0]);

            row.addView(userID);
            row.addView(userRating);
            row.addView(userReview);

            reviewsTable.addView(row);
        }
    }
}