package com.shermpay.todolist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todolist.R;
import com.shermpay.todolist.model.TodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoListActivity extends ActionBarActivity {
    private ListView mTodoListView;
    private EditText mTodoEdit;
    private Button mAddButtom;
    private ArrayAdapter<TodoItem> mTodoListAdapter;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        mTodoListView = (ListView) findViewById(R.id.todo_list_view);
        mTodoListAdapter = new ArrayAdapter<TodoItem>(this, R.layout.todo_list_item,
                R.id.todo_list_item_name, new ArrayList<TodoItem>());
        mTodoListView.setAdapter(mTodoListAdapter);

        mTodoEdit = (EditText)findViewById(R.id.add_todo_edit);
        mAddButtom = (Button)findViewById(R.id.add_todo_button);

        mAddButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoItemName = mTodoEdit.getText().toString();
                if (!todoItemName.equals("")) {
                    TodoItem newTodoItem = new TodoItem(todoItemName);
                    mTodoListAdapter.add(newTodoItem);
                    mTodoEdit.setText("");
                } else {
                    Toast emptyTodoToast = Toast.makeText(TodoListActivity.this,
                            "Todo Name cannot be empty", Toast.LENGTH_SHORT);
                    emptyTodoToast.show();
                }
            }
        });

        mTodoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TodoItem itemClicked = mTodoListAdapter.getItem(i);
                Intent todoItemIntent = new Intent(TodoListActivity.this, TodoItemActivity.class);
                todoItemIntent.putExtra("com.shermpay.todolist.ui.TodoListActivity.TODO_ITEM",
                        itemClicked);
                startActivity(todoItemIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo_list, menu);
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
