package com.example.contactstest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    private final int table1Dir = 0;
    private final int table1Item = 1;
    private final int table2Dir = 2;
    private final int table2Item = 3;

    private UriMatcher uriMatcher;

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {

        uriMatcher.addURI("com.example.app.provider", "table1", table1Dir);
        uriMatcher.addURI("com.example.app.provider", "table1/#", table1Item);
        uriMatcher.addURI("com.example.app.provider", "table2", table2Dir);
        uriMatcher.addURI("com.example.app.provider", "table2/#", table2Item);

        switch (uriMatcher.match(uri)){
            case table1Dir:
                //query all in table1
                break;
            case table1Item:
                //query single in table1
                break;
            case table2Dir:
                //query all in table2
                break;
            case table2Item:
                //query single in table2
                break;
        }

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        switch (uriMatcher.match(uri)){
            case table1Dir:
                return "vnd.android.cursor.dir/vnd.com.com.example.app.provider.table1";
            case table1Item:
                return "vnd.android.cursor.item/vnd.com.com.example.app.provider.table1";
            case table2Dir:
                return "vnd.android.cursor.dir/vnd.com.com.example.app.provider.table2";
            case table2Item:
                return "vnd.android.cursor.item/vnd.com.com.example.app.provider.table2";
        }

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
