package demo.webview.xing.webviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class WebViewDemoActivity extends ActionBarActivity  implements View.OnClickListener {
    private WebView mWebView;
    private Button mRefreshButton;
    private Button mGoButton;
    private EditText mUrlText;
    private int ENABLE_URL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyAppWebViewClient());
        mWebView.loadUrl("http://www.baidu.com/");
        mRefreshButton = (Button) findViewById(R.id.webview_refresh_btn);
        mRefreshButton.setOnClickListener(this);
        /*
        if (ENABLE_URL == 1) {
            mGoButton = (Button) findViewById(R.id.webview_go_btn);
            mGoButton.setOnClickListener(this);
            mUrlText = (EditText) findViewById(R.id.webview_url);
        }
        */
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mRefreshButton.getId()) {
            Log.i("webview", "reload clicked");
            mWebView.reload();
        }
        /*
        if (v.getId() == mGoButton.getId()) {
            mWebView.loadUrl(mUrlText.getText().toString());
            Log.i("webview", mUrlText.getText().toString());
        }
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
