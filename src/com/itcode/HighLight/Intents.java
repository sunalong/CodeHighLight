package com.itcode.HighLight;

import android.content.Intent;

public class Intents {
	private static final String INTENT_PREFIX = "com.itcode.HighLight";
	public static class Builder{

		private Intent intent;

		public Builder(String actionSuffix){
			intent = new Intent(INTENT_PREFIX + actionSuffix);
		}

		public Intent toIntent() {
			// TODO Auto-generated method stub
			return intent;
		}
		
	}
}
