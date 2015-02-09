package com.somnus.androidszloadingdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.somnus.androidszloadingdemo.util.DialogUtil;

public class MainActivity extends ActionBarActivity {

	private Dialog mConnectServerDialog;
	private int recLen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onAction(View v) {
		mConnectServerDialog = DialogUtil.getLoginDialog(this);
		mConnectServerDialog.show();
		mConnectServerDialog.setCancelable(false);// 返回键不能取消

		handler.postDelayed(runnable, 1000);
	}

	Handler handler = new Handler();
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			recLen++;
			handler.postDelayed(this, 1000);
			
			if (recLen == 3) {
				// Dialog dismiss cacel 有什么区别：http://blog.csdn.net/ramondlee/article/details/6757843
				mConnectServerDialog.dismiss();
//				mConnectServerDialog.cancel();
			}
		}
	};

}
