package com.itcode.HighLight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import com.itcode.HighLight.util.SourceEditor;

/**
 * 展示代码高亮
 * 
 * @author sunalong
 * 
 */
public class ViewCodeActivity extends Activity implements OnClickListener {

	private static final String TAG = "ViewCodeActivity";
	private static com.itcode.HighLight.Intents.Builder builder;
	private ProgressBar pbDataLoading;
	private WebView wvCodeView;
	private SourceEditor sourceEditor;
	private String content;
	private Button btSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_code);
		content = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KCjxwcm9qZWN0IHhtbG5zPSJodHRwOi8vbWF2ZW4uYXBhY2hlLm9yZy9QT00vNC4wLjAiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTpzY2hlbWFMb2NhdGlvbj0iaHR0cDovL21hdmVuLmFwYWNoZS5vcmcvUE9NLzQuMC4wIGh0dHA6Ly9tYXZlbi5hcGFjaGUub3JnL21hdmVuLXY0XzBfMC54c2QiPgogIDxtb2RlbFZlcnNpb24+NC4wLjA8L21vZGVsVmVyc2lvbj4KCiAgPHBhcmVudD4KICAgIDxncm91cElkPm9yZy5zb25hdHlwZS5vc3M8L2dyb3VwSWQ+CiAgICA8YXJ0aWZhY3RJZD5vc3MtcGFyZW50PC9hcnRpZmFjdElkPgogICAgPHZlcnNpb24+NzwvdmVyc2lvbj4KICA8L3BhcmVudD4KCiAgPGdyb3VwSWQ+Y29tLmFjdGlvbmJhcnNoZXJsb2NrPC9ncm91cElkPgogIDxhcnRpZmFjdElkPnBhcmVudDwvYXJ0aWZhY3RJZD4KICA8cGFja2FnaW5nPnBvbTwvcGFja2FnaW5nPgogIDx2ZXJzaW9uPjQuNC4wPC92ZXJzaW9uPgoKICA8bmFtZT5BY3Rpb25CYXJTaGVybG9jayAoUGFyZW50KTwvbmFtZT4K";
		initView();
//		selectFile();
//		setSource();
	}

	private void selectFile() {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setType("*/*");
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(data !=null){
			content = data.getDataString();
			// onActivityResult:file:///mnt/sdcard/2/LightAlertDialog.java
			try {
				FileReader fr = new FileReader("mnt/sdcard/2/LightAlertDialog.java");
				BufferedReader br = new BufferedReader(fr);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while((line = br.readLine())!=null){
					sb.append(line).append("\n");
				}
				content = sb.toString();
				Log.i(TAG,"onActivityResult:"+content);
				setSource();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void setSource() {
		sourceEditor = new SourceEditor(wvCodeView);// 设置代码编辑器//设置内容//设置文件名后缀
		// TODO:打开文件读取内容
		// TODO:注册此类打开文件的选择：如同打开视频时选择播放器一样
		sourceEditor.setSource("fuck.java", content, false);
	}

	private void initView() {
		pbDataLoading = (ProgressBar) findViewById(R.id.pbLoading);
		wvCodeView = (WebView) findViewById(R.id.wvCode);
		btSelect = (Button) findViewById(R.id.btSelect);
		btSelect.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		selectFile();
	}

}
