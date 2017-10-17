package com.example.work4;

import com.example.util.DatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button createdb;
	private Button insertdb;
	private Button updatedb;
	private Button querydb;
	private Button deletedb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createdb = (Button)findViewById(R.id.createDatabase);
        updatedb = (Button)findViewById(R.id.update);
        insertdb = (Button)findViewById(R.id.insert);
        querydb = (Button)findViewById(R.id.query);
        deletedb = (Button)findViewById(R.id.delete);        createdb.setOnClickListener(new CreateListener());
        insertdb.setOnClickListener(new InsertListener());
        updatedb.setOnClickListener(new UpdateListener());
        querydb.setOnClickListener(new QueryListener());
        deletedb.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }
    class CreateListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			//创建一个DatabaseHelper对象
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			//只有调用了DatabaseHelper对象的getReadableDatabase()方法，或者是getWritableDatabase()方法之后，才会创建，或打开一个数据库
			SQLiteDatabase db = dbHelper.getWritableDatabase();
		}
    }
    
    class InsertListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//生成ContentValues对象
			ContentValues values = new ContentValues();
			//向该对象当中插入键值对，其中键是列名，值是希望插入到这一列的值，值必须和数据库当中的数据类型一致
			values.put("id", 1);
			values.put("name","zhangsan");
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			//调用insert方法，就可以将数据插入到数据库当中
			db.insert("user", null, values);
			
			
		}
    }
    //更新操作就相当于执行SQL语句当中的update语句
    //UPDATE table_name SET XXCOL=XXX WHERE XXCOL=XX...
    class UpdateListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//得到一个可写的SQLiteDatabase对象
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("name", "lisi");
			db.update("user", values, "id=?", new String[]{"1"});
		}
    }
    class QueryListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			
			
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			
		}
    }
}
