package com.example.moocdemo1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button 	btnSearch;
	private Button	btnOpenActivity;
	public static final String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        btnSearch 		= (Button) findViewById(R.id.btnSearch);
        btnOpenActivity	= (Button) findViewById(R.id.btnOpenActivity);
        
        ButtonListener listener = new ButtonListener();
        
        btnSearch.setOnClickListener(listener);
        btnOpenActivity.setOnClickListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			EditText searchQuery = (EditText)findViewById(R.id.editTextSearchQuery);
			String searchQuerytext = searchQuery.getText().toString();
			String url = "https://www.google.com/?q=" + searchQuerytext + "#q=" + searchQuerytext;
			Intent intent = null;
			if( view.getId() == btnOpenActivity.getId()) {
				intent = new Intent(getApplicationContext(),
						ShowSearchQueryActivity.class);
				intent.putExtra(ShowSearchQueryActivity.QUERY, searchQuerytext);
			} else {
				intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
			}
			startActivity(intent);
		}
    	
    }
    
}
