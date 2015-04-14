package com.gpshopper.labs.firesearch;

import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;


/**
 * FireSearch 1.0 is a simple library for predictive search suggestions,
 * based on a user's previous search history. It retains past searches
 * previous search and displays suggestions when there's a similar match.
 *
 * It makes user of Android system User Dictionary applications,
 * adding words into the dictionary database, non-repetitively.
 */


public class FireSearch extends FireSearchBaseClass{

    private Cursor cursor;
    private SearchView searchView;
    private SimpleCursorAdapter simpleCursorAdapter;
    private final String TAG = FireSearch.class.getSimpleName();

    /**
     * Base container format for suggested words
     */
    private final String[] COLUMNS =
            new String[] { UserDictionary.Words._ID, UserDictionary.Words.WORD };

    /**
     * List item format for suggested words
     */
    private final int[] COLUMNS_LIST_ITEM =
            new int[] { android.R.id.text1, android.R.id.text1, android.R.id.button2 };


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) searchViewItem.getActionView();

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setOnSuggestionListener(this);
        searchView.setIconifiedByDefault(false);

        MenuItemCompat.setOnActionExpandListener(searchViewItem,
                new MenuItemCompat.OnActionExpandListener() {

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                searchView.clearFocus();
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSuggestionSelect(int position) {
        return false;
    }

    @Override
    public boolean onSuggestionClick(int position) {
            /**
             *
             * Similar to the {@link #onQueryTextSubmit} below, this method handles suggestion clicks,
             * via the search field drop down.
             *
             * Handle new intents or other actions with the user's suggested queries in here,
             * when a suggestion is clicked.
             *
             */
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if (query != null && !wordExists(query)) {
            UserDictionary.Words.addWord(getApplicationContext(), query, 0, 0);
            /**
             *
             * This method is responsible for the 'Search' or 'Go' action,
             * via the keyboard. i.e. if the user does not select a search suggestion
             * from the search field drop down, but hits the 'Search' or 'Go' button.
             *
             * Handle new intents or other actions with the user's entered query in here.
             *
             */
            Log.i(TAG, "Word: '" + query + "' has been inserted into the dictionary.");
            return true;
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        if (!query.isEmpty()) {
            performSuggestions(query);
        } else {
            return false;
        }
        return true;
    }


    /** Checks if the word exists in the dictionary database before adding it.
     *
     *  @param query he current word being searched by the user.
     */
    private boolean wordExists(String query) {

        ContentResolver resolver = getContentResolver();
        String[] columns = new String[] { UserDictionary.Words._ID, UserDictionary.Words.WORD };

        cursor = resolver.query(UserDictionary.Words.CONTENT_URI,
                columns, UserDictionary.Words.WORD + " = '" + query + "'", null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
            Log.w(TAG, "Word: '" + query + "' already exists and will not be re-inserted.");
            return true;
        }

        return false;
    }



    /** Performs and displays search suggestions once the first few letters, entered by the user,
     *  matches existing words already in the database.
     *
     *  @param query the current word being searched by the user.
     */
    private void performSuggestions(String query){

        ContentResolver resolver = getContentResolver();
        cursor = resolver.query(UserDictionary.Words.CONTENT_URI, COLUMNS,
                UserDictionary.Words.WORD + " LIKE '" + query + "%'", null, null);

        if (cursor != null) {
            simpleCursorAdapter = new SimpleCursorAdapter(this.getBaseContext(),
                    android.R.layout.simple_list_item_1, cursor, COLUMNS, COLUMNS_LIST_ITEM);
        } else {
            cursor.close();
            Log.w(TAG, "Cursor came back with nothing. Cursor has been closed.");
        }

        searchView.setSuggestionsAdapter(simpleCursorAdapter);
    }

}
