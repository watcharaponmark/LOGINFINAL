package com.example.loginfinal.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginfinal.model.User;

import java.util.ArrayList;

/**
 * Created by Mark on 12/18/16.
 */
/*
public class UserListAdapter extends  ArrayAdapter<User> {

        /*private Context mContext;
        private int mLayoutResId;
        private ArrayList<User> mUserList;
        public UserListAdapter(Context context, int resource, ArrayList<User> userlist) {
            super(context, resource, userlist);
            this.mContext = context;
            this.mLayoutResId = resource;
            this.mUserList = userlist;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemLayout = View.inflate(mContext, mLayoutResId, null);
            ImageView foodImageView = (ImageView) itemLayout.findViewById(R.id.food_image_view);
            TextView  UserNameTextView = (TextView) itemLayout.findViewById(R.id.listView);

            User user = mUserList.get(position);
            foodNameTextView.setText(user.name);

            Drawable drawable = Utils.getDrawableFromAssets(mContext, user.pictureFilename);
            foodImageView.setImageDrawable(drawable);

            return itemLayout;
        }
        */


