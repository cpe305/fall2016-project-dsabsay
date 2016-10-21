package com.dsabsay.application;

import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NotationWebView extends Region {
	private WebView webView;
	private WebEngine webEngine;
	
	public NotationWebView() {
		webView = new WebView();
		webEngine = new WebEngine();
		webEngine.load("notation.html");
	}
}
