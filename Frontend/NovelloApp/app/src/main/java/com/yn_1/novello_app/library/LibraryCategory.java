package com.yn_1.novello_app.library;

import android.util.Log;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;
import com.yn_1.novello_app.volley_requests.VolleyCommand;

import org.json.JSONException;
import org.json.JSONObject;

public enum LibraryCategory {
    NONE (0, null, new boolean[]{false, true, true, false, false, false}),
    WISHLIST (1, "wishlist", new boolean[]{true, false, true, false, false, false}),
    CART (2, "cart", new boolean[]{true, true, false, true, false, false}),
    BACKLOG (3, "backlog", new boolean[]{false, false, false, false, true, false}),
    CURRENTLY_READING (4, "currentlyReading", new boolean[]{false, false, false, true, false, true}),
    READ (5, "read", new boolean[]{false, false, false, true, true, false});

    private int categoryIndex;
    private final String stringFormat;
    private final boolean[] possibleTransactions;

    LibraryCategory(int categoryIndex, String stringFormat, boolean[] possibleTransactions) {
        this.categoryIndex = categoryIndex;
        this.stringFormat = stringFormat;
        this.possibleTransactions = possibleTransactions;
    }

    /**
     *
     * @return
     */
    public int getCategoryIndex() {
        return categoryIndex;
    }

    /**
     *
     * @return
     */
    public String getStringFormat() {
        return stringFormat;
    }

    /**
     *
     * @return
     */
    public boolean[] getPossibleTransactions() {
        return possibleTransactions;
    }

    /**
     * Method for moving book between user categories.
     * @param newCategory
     * @param userID
     * @param bookID
     */
    public void performTransaction(LibraryCategory newCategory, int userID, int bookID) {

        // Check if current category can move to new category
        if (possibleTransactions[newCategory.getCategoryIndex()]) {
            // Get the book.
            JsonObjectRequester bookReq = new JsonObjectRequester();
            bookReq.getRequest("book/" + bookID, null, new VolleyCommand<JSONObject>() {
                @Override
                public void execute(JSONObject book) {
                    // Call a helper method to move the book to a new category.
                    putInCategory(newCategory, userID, bookID);
                }

                @Override
                public void onError(VolleyError error) {
                    Log.d("Transaction", "Could not obtain Book at book ID " + bookID);
                }
            }, null, null);
        }
        else
        {
            Log.d("Transaction", "Invalid category transaction.");
        }
    }

    /**
     * Helper method for putting book in a new category
     * @param newCategory
     * @param userID
     * @param bookID
     */
    private void putInCategory(LibraryCategory newCategory, int userID, int bookID) {
        JsonObjectRequester categoryReq = new JsonObjectRequester();
        // If NONE: DELETE book
        if (newCategory == NONE)
        {
            String pathUrl = "bookData";
            JSONObject object = new JSONObject();
            try {
                object.put("bookId", bookID);
                object.put("userId", userID);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            categoryReq.deleteRequest(pathUrl, object, new VolleyCommand<JSONObject>() {
                @Override
                public void execute(JSONObject data) {
                    Log.d("Transaction", "Transaction successfully completed.");
                }

                @Override
                public void onError(VolleyError error) {
                    Log.d("Transaction", "Unable to PUT book in user category.");
                }
            }, null, null);
        }
        // Else: PUT book in new category
        else {
            String pathUrl = "bookData";
                    // userID + "/library/" + newCategory.getCategoryIndex();
            JSONObject object = new JSONObject();
            try {
                object.put("bookId", bookID);
                object.put("userId", userID);
                object.put("category", newCategory.categoryIndex);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("Transaction", "JSON object error.");
            }

            categoryReq.putRequest(pathUrl, object, new VolleyCommand<JSONObject>() {
                @Override
                public void execute(JSONObject data) {
                    Log.d("Transaction", "Transaction successfully completed.");
                }

                @Override
                public void onError(VolleyError error) {
                    Log.d("Transaction", "Unable to PUT book in user category.");
                }
            }, null, null);
        }
    }
}
