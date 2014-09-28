/*
 * Copyright 2012 GitHub Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.itcode.HighLight.util;

import static org.eclipse.egit.github.core.client.IGitHubConstants.CHARSET_UTF8;

import java.io.UnsupportedEncodingException;

import org.eclipse.egit.github.core.util.EncodingUtils;

import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Utilities for displaying source code in a {@link WebView}
 */
public class CopyOfSourceEditor {

    private static final String URL_PAGE = "file:///android_asset/source-editor.html";

    private static final String TAG = "SourceEditor";

    private final WebView view;

    private boolean wrap;

    private String name;

    private String content;

    private boolean encoded;

    private boolean markdown;

    /**
     * Create source editor using given web view
     *
     * @param view
     */
    public CopyOfSourceEditor(final WebView view) {
    	WebViewClient client = new WebViewClient();
        view.setWebViewClient(client);

        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        view.addJavascriptInterface(this, "CopyOfSourceEditor");

        this.view = view;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return content
     */
    public String getRawContent() {
        return content;
    }

    /**
     * @return content
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
     * @return wrap
     */
    public boolean isWrap() {
        return wrap;
    }

    /**
     * @return markdown
     */
    public boolean isMarkdown() {
        return markdown;
    }
    /**
     * Bind content to current {@link WebView}
     *
     * @param name
     * @param content
     * @param encoded
     * @return this editor
     */
    public CopyOfSourceEditor setSource(final String name, final String content,
            final boolean encoded) {
        this.name = name;
        this.content = content;
        this.encoded = encoded;
        Log.i(TAG,"setSource content:"+this.content);
        view.loadUrl(URL_PAGE);
        return null;
    }
}
