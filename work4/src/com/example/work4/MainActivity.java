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
			//����һ��DatabaseHelper����
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			//ֻ�е�����DatabaseHelper�����getReadableDatabase()������������getWritableDatabase()����֮�󣬲Żᴴ�������һ�����ݿ�
			SQLiteDatabase db = dbHelper.getWritableDatabase();
		}
    }
    
    class InsertListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//����ContentValues����
			ContentValues values = new ContentValues();
			//��ö����в����ֵ�ԣ����м���������ֵ��ϣ�����뵽��һ�е�ֵ��ֵ��������ݿ⵱�е���������һ��
			values.put("id", 1);
			values.put("name","zhangsan");
			DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test",null,1);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			//����insert�������Ϳ��Խ����ݲ��뵽���ݿ⵱��
			db.insert("user", null, values);
			
			
		}
    }
    //���²������൱��ִ��SQL��䵱�е�update���
    //UPDATE table_name SET XXCOL=XXX WHERE XXCOL=XX...
    class UpdateListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//�õ�һ����д��SQLiteDatabase����
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
