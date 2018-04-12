package com.dao;

import com.entities.UserBookmark;
import com.thrillio.DataStore;
import com.entities.Bookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}

