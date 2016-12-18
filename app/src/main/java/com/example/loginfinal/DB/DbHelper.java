package com.example.loginfinal.DB;

import android.database.sqlite.SQLiteOpenHelper;


    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

    public class DbHelper extends SQLiteOpenHelper {
        public static final String TAG = DbHelper.class.getSimpleName();
        public static final String DB_NAME = "myapp.db";
        public static final int DB_VERSION = 1;

        public static final String USER_TABLE = "users";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME= "username";
        public static final String COLUMN_PASS = "password";

        public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASS + " TEXT);";

        public DbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_USERS);
            insertInitialData(db);

        }

        private void insertInitialData(SQLiteDatabase db) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, "android studio");
            cv.put(COLUMN_USERNAME, "android");
            cv.put(COLUMN_PASS, "123456");
            db.insert(USER_TABLE, null, cv);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
            onCreate(db);
        }


        public void addUser(String name ,String username, String password) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_USERNAME, name);
            values.put(COLUMN_USERNAME, username);
            values.put(COLUMN_PASS, password);
            long id = db.insert(USER_TABLE, null, values);
            db.close();
            Log.d(TAG, "user : " + id);
        }

        public boolean getUser(String username, String password){

            String selectQuery = "select * from  " + USER_TABLE + " where " +
                    COLUMN_USERNAME + " = " + "'"+username+"'" + " and " + COLUMN_PASS + " = " + "'"+password+"'";

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            // Cursor cursor=db.query(USER_TABLE,null,"? = "+COLUMN_USERNAME+" AND "+"? = "+COLUMN_PASS,new String[]{username,password},null,null,null);

            cursor.moveToFirst();
            if (cursor.getCount() > 0) {

                return true;
            }
            cursor.close();
            db.close();

            return false;

        }
        public String getname(String username){
            String name="";
            String selectQuery = "select * from  " + USER_TABLE + " where " +
                    COLUMN_USERNAME + " = " + "'"+username+"'";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            while (cursor.moveToNext()) {
                name = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_NAME));
            }
            return name;

        }
        public boolean chackUsername(String username){
            int count=0;
            String selectQuery = "select * from  " + USER_TABLE + " where " +
                    COLUMN_USERNAME + " = " + "'"+username+"'";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            while (cursor.moveToNext()) {
               count++;
            }
            if(count==0){
                return true;
            }else {
                return false;
            }

        }
    }


