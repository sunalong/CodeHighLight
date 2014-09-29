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

	/**
	 * 设置webView要显示的内容及此内容的类型(由文件名后缀决定)，是否已被加密
	 * @param name	文件名
	 * @param content 要显示的内容
	 * @param encoded 是否已被加密
	 * @return
	 */
	public SourceEditor setSource(String name,String content,boolean encoded){
		this.name = name;
		this.content = content;
		this.encoded = encoded;
		Log.i(TAG,"MysetSourceContent:"+this.content);
		webView.loadUrl(URL_PAGE);//由此页面的规则来显示加进去的body,达到高亮效果
		return null;
	}

	/**
	 * 获取文件名<br>
	 * 供source-editor.js中获取后缀名用
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取内容<br>
	 * 若已经加密，则返回解密的内容<br>
	 * 若未加密，则返回传进来的内容
	 * @return
	 */
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

	/**
	 * 返回传进来的内容
	 * @return
	 */
	public String getRawContent() {
		return content;
	}

	public boolean wrap;
	/**
	 * 判断是否折行
	 * @return
	 */
	public boolean getWrap() {
		return wrap;
	}

	/**
	 * 设置折行标记
	 * @param wrap
	 */
	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}
	
}
