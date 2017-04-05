package demo.webview.xing.webviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyAppWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("whatsmyua.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
    @Override
    public void onReceivedError(final WebView view, int errorCode, String description,
                                final String failingUrl) {
        //control you layout, show something like a retry button, and
        //call view.loadUrl(failingUrl) to reload.
        Log.i("webview", " onReceivedError errorCode=" + errorCode + "; description=" + description + "; failingUrl=" + failingUrl);
        super.onReceivedError(view, errorCode, description, failingUrl);

    }
    @Override
    public WebResourceResponse shouldInterceptRequest (final WebView view, String url) {
        Log.i("webview", " shouldInterceptRequest url=" + url);
        return super.shouldInterceptRequest(view, url);
    }

}