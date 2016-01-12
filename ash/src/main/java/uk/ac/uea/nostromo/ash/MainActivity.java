/*
 * MainActivity.java	v0.2.1	2016-01-12
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import uk.ac.uea.nostromo.mother.Screen;
import uk.ac.uea.nostromo.mother.implementation.AndroidGame;

/**
 * The main activity for Ash that is launch when the app is launched
 * for the first time.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.2.1
 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
 */
public class MainActivity extends AndroidGame {
	/**
	 * Constant runtime representation of the class name that is used
	 * when logging information.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 * @see		android.util.Log
	 */
	static final String TAG = "MainActivity";

	/**
	 * {@inheritDoc}
	 *
	 * @param	savedInstanceState	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Screen initialScreen;

		Log.v(TAG, "Our application is being created.");

		/* We do not make the call to `Activity.onCreate(Bundle)` because that
		 * call is made in `AndroidGame.onCreate(Bundle, int, int)`.
		 */
		super.onCreate(savedInstanceState, R.layout.home_screen, R.id.table_layout);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	protected void onStart() {
		Log.v(TAG, "Our application has started.");

		super.onStart();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	protected void onRestart() {
		Log.v(TAG, "Our application has been restarted.");

		super.onRestart();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onResume() {
		Log.v(TAG, "Out application has been resumed.");

		super.onResume();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public void onPause() {
		Log.v(TAG, "Our application has been paused.");

		super.onPause();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	protected void onStop() {
		Log.v(TAG, "Our application has been stopped.");

		super.onStop();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	protected void onDestroy() {
		Log.v(TAG, "Our application is begin destroyed.");

		super.onDestroy();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this label before new release.
	 */
	@Override
	public Screen getInitScreen() {
		Context context;
		Screen homeScreen;

		context = getBaseContext();
		if (context == null) {
			Log.w(TAG, "The context we're receiving for the system is `null`.");
		}

		homeScreen = new HomeScreen(this, context);

		return homeScreen;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void onBackPressed() {
		Screen currentScreen;

		currentScreen = getCurrentScreen();
		if (currentScreen != null) {
			currentScreen.backButton();
		} else {
			Log.e(TAG, "`MainActivity.getCurrentScreen()` has returned a " +
					"`null` reference for our current screen.");
		}
	}
}
