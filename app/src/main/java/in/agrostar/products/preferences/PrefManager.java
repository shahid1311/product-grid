package in.agrostar.products.preferences;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/**
 * Created by Shahid on 1/15/2016.
 * This class is used for handling user's shared preferences
 */
class PrefManager {
	private Context context;
	private String prefName;

	public PrefManager(Context context, String prefName) {
		this.context = context;
		this.prefName = prefName;
	}

	/**
	 * Puts given key-value pair to the Shared Preferences.
	 * @param key - String
	 * @param value - String
	 */
	public void put(String key, String value) {
		Editor edit = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
		edit.putString(key, value).apply();
	}

	/**
	 * Puts given key-value pair to the Shared Preferences.
	 * @param key - String
	 * @param value - boolean
	 */
	public void put(String key, boolean value) {
		Editor edit = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
		edit.putBoolean(key, value).apply();
	}

	/**
	 * Puts given key-value pair to the Shared Preferences.
	 * @param key - String
	 * @param value - long
	 */
	public void put(String key, long value) {
		Editor edit = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
		edit.putLong(key, value).apply();
	}

	/**
	 * Puts given key-value pair to the Shared Preferences.
	 * @param key - String
	 * @param value - int
	 */
	public void put(String key, int value) {
		Editor edit = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
		edit.putInt(key, value).apply();
	}

	/**
	 * Puts given key-value pair to the Shared Preferences.
	 * @param key - String
	 * @param value - float
	 */
	public void put(String key, float value) {
		Editor edit = context.getSharedPreferences(prefName, Context.MODE_PRIVATE).edit();
		edit.putFloat(key, value).apply();
	}

	/**
	 * Returns String value for the given key, null if no value is found.
	 * @param key - String
	 * @return String
	 */
	public String getString(String key) {
		if(context!=null){
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getString(key, null);
		}
		return null;
	}

	/**
	 * Returns String value for the given key, null if no value is found.
	 * @param key  - String
	 * @param defaultValue
	 * @return
	 */
	public String getString(String key, String defaultValue) {
		if(context!=null){
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getString(key, defaultValue);
		}
		return null;
	}


	/**
	 * Returns boolean value for the given key, can set default value as well.
	 * @param key  - String
	 * @param defaultValue - boolean
	 * @return boolean
	 */
	public boolean getBoolean(String key, boolean defaultValue) {
		if(context!=null) {
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getBoolean(key, defaultValue);
		}
		return defaultValue;
	}

	/**
	 * Returns long value for the given key, -1 if no value is found.
	 * @param key - String
	 * @return long
	 */
	public long getLong(String key, long defaultValue) {
		if(context!=null){
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getLong(key, defaultValue);
		}
		return defaultValue;
	}

	/**
	 * Returns int value for the given key.
	 * @param key - String
	 * @return long
	 */
	public int getInt(String key, int defaultVal) {
		if(context!=null){
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getInt(key, defaultVal);
		}
		return defaultVal;
	}

	/**
	 * Returns float value for the given key, defaultValue if no value is found.
	 * @param key - String
	 * @param defaultValue
	 * @return float
	 */
	public float getFloat(String key, float defaultValue) {
		if(context!=null){
			return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
					.getFloat(key, defaultValue);
		}
		return defaultValue;
	}
}
