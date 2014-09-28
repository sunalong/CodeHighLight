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
//		this.content= "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KCjxwcm9qZWN0IHhtbG5zPSJodHRwOi8vbWF2ZW4uYXBhY2hlLm9yZy9QT00vNC4wLjAiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTpzY2hlbWFMb2NhdGlvbj0iaHR0cDovL21hdmVuLmFwYWNoZS5vcmcvUE9NLzQuMC4wIGh0dHA6Ly9tYXZlbi5hcGFjaGUub3JnL21hdmVuLXY0XzBfMC54c2QiPgogIDxtb2RlbFZlcnNpb24+NC4wLjA8L21vZGVsVmVyc2lvbj4KCiAgPHBhcmVudD4KICAgIDxncm91cElkPm9yZy5zb25hdHlwZS5vc3M8L2dyb3VwSWQ+CiAgICA8YXJ0aWZhY3RJZD5vc3MtcGFyZW50PC9hcnRpZmFjdElkPgogICAgPHZlcnNpb24+NzwvdmVyc2lvbj4KICA8L3BhcmVudD4KCiAgPGdyb3VwSWQ+Y29tLmFjdGlvbmJhcnNoZXJsb2NrPC9ncm91cElkPgogIDxhcnRpZmFjdElkPnBhcmVudDwvYXJ0aWZhY3RJZD4KICA8cGFja2FnaW5nPnBvbTwvcGFja2FnaW5nPgogIDx2ZXJzaW9uPjQuNC4wPC92ZXJzaW9uPgoKICA8bmFtZT5BY3Rpb25CYXJTaGVybG9jayAoUGFyZW50KTwvbmFtZT4K";
		Log.i(TAG,"MysetSourceContent:"+this.content);
		webView.loadUrl(URL_PAGE);
//		webView.loadData(this.content, "text/html", null);
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

	private String getRawContent() {
		// TODO Auto-generated method stub
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
