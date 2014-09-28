package com.itcode.HighLight.util;

import java.io.UnsupportedEncodingException;

import org.eclipse.egit.github.core.util.EncodingUtils;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 源码编辑器
 * @author sunalong
 *
 */
@SuppressLint("JavascriptInterface") public class SourceEditor {

	private static final String URL_PAGE = "file:///android_asset/source-editor.html";
	private static final String TAG = "SourceEditor";
	private static final String CHARSET_UTF8 = "UTF-8";
	public WebView webView;
	public String name;
	private boolean encoded;
	public String content;
	/**
	 * 使用给定的webView创建一个源码编辑器
	 * @param wvCodeView
	 */
	public SourceEditor(WebView webView) {
		WebViewClient client = new WebViewClient();
		webView.setWebViewClient(client);
		
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setBuiltInZoomControls(true);//可缩放
		settings.setUseWideViewPort(true);
		webView.addJavascriptInterface(this, "SourceEditor");
		this.webView = webView;
	}

	public SourceEditor setSource(String name,String content,boolean encoded){
		this.name = name;
		this.content = content;
		this.encoded = encoded;
		Log.i(TAG,"MysetSourceContent:"+this.content);
		webView.loadUrl(URL_PAGE);
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEncoded() {
		return encoded;
	}
	

	public void setEncoded(boolean encoded) {
		this.encoded = encoded;
	}

	public String getContent() {
        if (encoded)
            try {
                return new String(EncodingUtils.fromBase64(content),
                        CHARSET_UTF8);
            } catch (UnsupportedEncodingException e) {
                return getRawContent();
            }
        else
            return getRawContent();
	}

	public String getRawContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public boolean wrap;
	public boolean getWrap() {
		return wrap;
	}

	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}
	
}
