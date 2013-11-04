package com.qsoft.pilotproject.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * User: binhtv
 * Date: 10/31/13
 * Time: 11:55 AM
 */
public class OnlineDioDatabase extends SQLiteOpenHelper
{
    private static final String TAG = "OnlineDioDatabase";
    private static final String DATABASE_NAME = "onlinedio.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;

    interface Table
    {
        String COMMENTS = "comments";
        String FEEDS = "feeds";
    }

    public OnlineDioDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + Table.FEEDS + " ("
                + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + OnlineDioContract.Feed.COLUMN_ID + " INTEGER NOT NULL,"
                + OnlineDioContract.Feed.COLUMN_USER_ID + " INTEGER NOT NULL,"
                + OnlineDioContract.Feed.COLUMN_TITLE + " TEXT NOT NULL,"
                + OnlineDioContract.Feed.COLUMN_THUMBNAIL + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_DESCRIPTION + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_PLAYED + " INTEGER,"
                + OnlineDioContract.Feed.COLUMN_CREATED_AT + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_UPDATED_AT + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_LIKES + " INTEGER,"
                + OnlineDioContract.Feed.COLUMN_COMMENTS + " INTEGER,"
                + OnlineDioContract.Feed.COLUMN_USER_NAME + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_DISPLAY_NAME + " TEXT,"
                + OnlineDioContract.Feed.COLUMN_AVATAR + " TEXT"
                + " );");

        db.execSQL("CREATE TABLE " + Table.COMMENTS + " ("
                + OnlineDioContract.Comment._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + OnlineDioContract.Comment.COLUMN_ID + " INTEGER NOT NULL, "
                + OnlineDioContract.Comment.COLUMN_SOUND_ID + " INTEGER NOT NULL, "
                + OnlineDioContract.Comment.COLUMN_USER_ID + " INTEGER NOT NULL, "
                + OnlineDioContract.Comment.COLUMN_CONTENT + " TEXT, "
                + OnlineDioContract.Comment.COLUMN_CREATED_AT + " TEXT, "
                + OnlineDioContract.Comment.COLUMN_UPDATED_AT + " TEXT, "
                + OnlineDioContract.Comment.COLUMN_USER_NAME + " TEXT, "
                + OnlineDioContract.Comment.COLUMN_DISPLAY_NAME + " TEXT, "
                + OnlineDioContract.Comment.COLUMN_AVATAR + " TEXT"
                + " );"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2)
    {
        Log.d(TAG, "onUpgrade()");
        db.execSQL("DROP TABLE IF EXISTS " + Table.COMMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + Table.FEEDS);
        onCreate(db);
    }
}