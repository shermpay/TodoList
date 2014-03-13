package com.shermpay.todolist.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.todolist.R;
import com.shermpay.todolist.model.TodoItem;

public class TodoItemActivity extends ActionBarActivity {
    private TodoItem mTodoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item);
        Intent fromIntent = getIntent();
        mTodoItem = fromIntent.getParcelableExtra("com.shermpay.todolist.ui.TodoListActivity" +
                ".TODO_ITEM");
        TextView nameTextView = (TextView)findViewById(R.id.todo_item_name);
        TextView priorityTextView = (TextView)findViewById(R.id.todo_item_priority);

        nameTextView.setText(mTodoItem.toString());
        priorityTextView.setText("Priority: " + mTodoItem.getPriority());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
