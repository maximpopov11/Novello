package com.yn_1.novello_app.library;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.book.Book;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryModel implements LibraryContract.Model {
    private List<Book> bookCollection;
    private int bookCount;

    // Collection of book buttons
    private Map<ImageButton, Book> bookButtons;

    private final String[] categoryPaths = {"currentlyReading", "wishlist", "read"};

    private int finishedCollectionCounter;
    @Override
    public void fetchAllBooks(User user, LibraryContract.View view, LibraryContract.Presenter presenter) {
        bookButtons = null;
        bookCount = 0;
        finishedCollectionCounter = 0;
        bookCollection = new ArrayList<>();
        bookButtons = new HashMap<>();

        for (int i = 0; i < categoryPaths.length; i++) {
            String categoryPath = categoryPaths[i];

            JsonArrayRequester req = new JsonArrayRequester();
            req.getRequest(user.getUsername() + "/library/"+categoryPath,
                    null, new VolleyCommand<JSONArray>() {
                        @Override
                        public void execute(JSONArray data) {
                            for (int i = 0; i < data.length(); i++) {
                                try {
                                    JSONObject book = data.getJSONObject(i);
                                    int bookID = book.getInt("bookID");
                                    String title = book.getString("title");
                                    String author = book.getString("author");
                                    int publicationYear = book.getInt("publicationYear");
                                    String isbn = book.getString("isbn");
                                    int rating = book.getInt("rating");
                                    String bookUrl = book.getString("bookUrl");
                                    String imageUrl = book.getString("imageUrl");
                                    Book newBook = new Book(bookID, title, author, publicationYear, isbn, rating, -1, bookUrl, imageUrl);
                                    newBook.setUserCategoryID(categoryPath);
                                    bookCollection.add(newBook);
                                    bookCount++;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            finishedCollectionCounter++;
                            if (finishedCollectionCounter == COLLECTION_COUNT) {
                                Log.d("Model", "fetchAllBooks() finished");
                                presenter.createBookButtons(((Fragment) view).getContext());
                            }
                        }

                        @Override
                        public void onError(VolleyError error) {

                        }
                    }, null, null);
        }
    }

    private int finishedImagesCounter;
    @Override
    public void assignImageToBook(Book book, String imageURL, ImageButton button, LibraryContract.View view) {
        ImageRequester req = new ImageRequester();
        req.getRequest(imageURL, null, new VolleyCommand<Bitmap>() {
            @Override
            public void execute(Bitmap image) {
                Bitmap newImage = Bitmap.createScaledBitmap(image, BOOK_SIZE[0], BOOK_SIZE[1], true);
                button.setImageBitmap(newImage);
                finishedImagesCounter++;
                if (finishedImagesCounter == bookCount) {
                    Log.d("Model", "assignImageToBook() finished");
                    view.startPresenter();
                }
            }

            @Override
            public void onError(VolleyError error) {
                Log.d("Image Load Error", imageURL);
            }
        }, null, null);
    }

    @Override
    public List<Book> getUserBookCollection() {
        return bookCollection;
    }

    // TODO: Press add button to add book to collection
    @Override
    public List<Book> addBookToCollection(Book book) {
        return null;
    }

    // TODO: Hold book to remove book from collection
    @Override
    public List<Book> removeBookFromCollection(Book book) {
        return null;
    }

    @Override
    public Map<ImageButton, Book> getBookButtons() {
        return bookButtons;
    }

    @Override
    public void addBookButton(Book book, ImageButton button) {
        if (bookButtons == null) {
            bookButtons = new HashMap<>();
        }
        bookButtons.put(button, book);
    }

    @Override
    public Book getBookButton(ImageButton button) {
        return bookButtons.get(button);
    }
}
