package com.example.work4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class submit extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit);
		final EditText user=(EditText) findViewById(R.id.user);
		final EditText password=(EditText) findViewById(R.id.password);
		Button bt=(Button) findViewById(R.id.ok);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if((user.getText().toString()=="wangguo")&&(password.getText().toString()=="2034110399")){
					Intent intent=new Intent(submit.this,MainActivity.class);
					intent.setClass(submit.this,MainActivity.class);
					startActivity(intent); 
				}else{
					Toast.makeText(submit.this, "此账号不是管理员账号！", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
