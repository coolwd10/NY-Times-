package info.com.NyTimes.android.mvp.main.detail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import info.com.NyTimes.R;
import info.com.NyTimes.android.NyApp;
import info.com.NyTimes.android.mvp.core.base.BaseActivity;
import info.com.NyTimes.android.mvp.main.home.MyDividerItemDecoration;
import info.com.NyTimes.android.mvp.main.home.NyAdapter;
import info.com.NyTimes.android.mvp.main.home.model.Result;
import info.com.NyTimes.android.mvp.main.home.mvp.HomePresenter;
import info.com.NyTimes.android.mvp.main.home.mvp.IHomeView;

public class NyDetailActivity extends Activity {


    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ny_detail_view);
        webView =  findViewById(R.id.webview);

        String url= getIntent().getStringExtra("NY_DETAIL_VIEW");
        startWebView(url);
    }

    private void startWebView(String url) {

        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;

            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(NyDetailActivity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }

        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);


    }

}
