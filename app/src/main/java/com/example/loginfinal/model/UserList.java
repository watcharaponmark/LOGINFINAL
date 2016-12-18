package com.example.loginfinal.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.loginfinal.DB.DbHelper;

import java.util.ArrayList;
import java.util.Random;

public class UserList {

    private static final String TAG = UserList.class.getSimpleName();

    private static UserList mInstance;
    private Context mContext;

    private DbHelper mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<User> mFoodList = new ArrayList<>();
    private Random mRandom = new Random();

    public static UserList getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserList(context);
        }
        return mInstance;
    }

    private UserList(Context context) {
        this.mContext = context;
    }

    public void loadFromDatabase() {
        mFoodList.clear();
        mHelper = new DbHelper(mContext);
        mDb = mHelper.getWritableDatabase();

        Cursor cursor = mDb.query(DbHelper.USER_TABLE, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_NAME));

        }
        cursor.close();
        //mDb.close();
        //mHelper.close();
    }

    public ArrayList<User> getFoodList() {
        return mFoodList;
    }

    public User getRandomFood() {
        int randomIndex = mRandom.nextInt(mFoodList.size());
        User user = mFoodList.get(randomIndex);

        Log.i(TAG, user.name);
        return user;
    }
}
