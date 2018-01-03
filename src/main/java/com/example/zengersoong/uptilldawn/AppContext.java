package com.example.zengersoong.uptilldawn;

import java.util.ArrayList;

/**
 * Created by soong on 11/30/17.
 *
 * A  singleton to keep global data and global methods
 * It data store here will persist as long as the app is running
 */

class AppContext {
    private static final AppContext ourInstance = new AppContext();

    ArrayList<ArrayList<String>> arrayResult;

    static AppContext getInstance() {
        return ourInstance;
    }

    private AppContext() {

    }
}
