package com.example.loginfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.loginfinal.model.User;
import com.example.loginfinal.model.UserList;

public class UserListActivity extends AppCompatActivity {
    private ListView mUserListView;
   // @Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mUserListView = (ListView) findViewById(R.id.listView);
        mUserListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserList userList = UserList.getInstance(UserListActivity.this);
                User food = userList.getFoodList().get(i);

                Intent intent = new Intent(UserListActivity.this, UserListActivity.class);
                intent.putExtra("name", food.name);
                startActivity(intent);
            }
        });

        FloatingActionButt fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodListActivity.this, AddFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        FoodMenu foodMenu = FoodMenu.getInstance(this);
        foodMenu.loadFromDatabase();

        FoodListAdapter adapter = new FoodListAdapter(
                this,
                R.layout.list_item,foodMenu.getFoodList()
        );

        mFoodListView.setAdapter(adapter);
    }
    }*/
}
