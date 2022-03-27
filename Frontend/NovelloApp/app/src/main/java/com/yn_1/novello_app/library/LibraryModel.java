package com.yn_1.novello_app.library;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.Const;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.account.User;
import com.yn_1.novello_app.volley_requests.ImageRequester;
import com.yn_1.novello_app.volley_requests.JsonArrayRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LibraryModel implements LibraryContract.Model {

    private List<Book> bookCollection;
    int AHHHH;
    int AHHHH2;

    @Override
    public void fetchAllBooks(User user, LibraryContract.View view, LibraryContract.Presenter presenter) {
        AHHHH=0;
        bookCollection = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String categoryPath = "";
            switch (i) {
                case 0:
                    categoryPath = "currentlyReading";
                    break;
                case 1:
                    categoryPath = "wishlist";
                    break;

                case 2:
                    categoryPath = "read";
                    break;
            }

            JsonArrayRequester req = new JsonArrayRequester();
            String finalCategoryPath = categoryPath;
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
                                    String imageUrl = book.getString("imageUrl");
                                    Book newBook = new Book(bookID, title, author, publicationYear, isbn, rating, imageUrl);
                                    newBook.setUserCategoryID(finalCategoryPath);
                                    bookCollection.add(newBook);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            AHHHH++;
                            if (AHHHH == 3) {
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

    @Override
    public void assignImageToBook(String imageURL, ImageButton button, LibraryContract.View view) {
        ImageRequester req = new ImageRequester();
        req.getRequest(imageURL, null, new VolleyCommand<Bitmap>() {
            @Override
            public void execute(Bitmap image) {
                Bitmap newImage = Bitmap.createScaledBitmap(image, 175*3, 280*3, true);
                button.setImageBitmap(newImage);
                AHHHH2++;
                if (AHHHH2 == 9) {
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
}
