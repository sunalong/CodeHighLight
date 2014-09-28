package com.itcode.HighLight;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.itcode.HighLight.util.CopyOfSourceEditor;
import com.itcode.HighLight.util.SourceEditor;

/**
 * 展示代码高亮
 * 
 * @author sunalong
 * 
 */
public class ViewCodeActivity extends Activity {

	private static com.itcode.HighLight.Intents.Builder builder;
	private ProgressBar pbDataLoading;
	private WebView wvCodeView;
	private CopyOfSourceEditor sourceEditor;
//	private SourceEditor sourceEditor;

//	public static Intent createIntent() {
//		builder = new Builder("branch.file.VIEW");
//		// builder.repo(repository);
//
//		return builder.toIntent();
//	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_code);
		initView();
		setSource();

	}

	private void setSource() {
		sourceEditor = new CopyOfSourceEditor(wvCodeView);
//		sourceEditor = new SourceEditor(wvCodeView);
		String content = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KCjxwcm9qZWN0IHhtbG5zPSJodHRwOi8vbWF2ZW4uYXBhY2hlLm9yZy9QT00vNC4wLjAiIHhtbG5zOnhzaT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS9YTUxTY2hlbWEtaW5zdGFuY2UiIHhzaTpzY2hlbWFMb2NhdGlvbj0iaHR0cDovL21hdmVuLmFwYWNoZS5vcmcvUE9NLzQuMC4wIGh0dHA6Ly9tYXZlbi5hcGFjaGUub3JnL21hdmVuLXY0XzBfMC54c2QiPgogIDxtb2RlbFZlcnNpb24+NC4wLjA8L21vZGVsVmVyc2lvbj4KCiAgPHBhcmVudD4KICAgIDxncm91cElkPm9yZy5zb25hdHlwZS5vc3M8L2dyb3VwSWQ+CiAgICA8YXJ0aWZhY3RJZD5vc3MtcGFyZW50PC9hcnRpZmFjdElkPgogICAgPHZlcnNpb24+NzwvdmVyc2lvbj4KICA8L3BhcmVudD4KCiAgPGdyb3VwSWQ+Y29tLmFjdGlvbmJhcnNoZXJsb2NrPC9ncm91cElkPgogIDxhcnRpZmFjdElkPnBhcmVudDwvYXJ0aWZhY3RJZD4KICA8cGFja2FnaW5nPnBvbTwvcGFja2FnaW5nPgogIDx2ZXJzaW9uPjQuNC4wPC92ZXJzaW9uPgoKICA8bmFtZT5BY3Rpb25CYXJTaGVybG9jayAoUGFyZW50KTwvbmFtZT4K";
//		sourceEditor.setSource("fuck.xml", content );
		sourceEditor.setSource("fuck.xml", content,true);
		
	}

	private void initView() {
		pbDataLoading = (ProgressBar) findViewById(R.id.pbLoading);
		wvCodeView = (WebView) findViewById(R.id.wvCode);
	}

	
}
