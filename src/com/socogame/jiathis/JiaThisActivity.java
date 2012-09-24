package com.socogame.jiathis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class JiaThisActivity extends Activity {
	private Button btnShare = null;
	private TextView tvContent = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jia_this);
		tvContent = (TextView) this.findViewById(R.id.tv_content);
		btnShare = (Button) this.findViewById(R.id.btn_share);
		btnShare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_SUBJECT, tvContent.getText());
				intent.putExtra(Intent.EXTRA_TEXT, tvContent.getText());
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, "分享"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_jia_this, menu);
		return true;
	}
}
