/*
 * MainActivity.java	v0.1.0	2016-01-11
 */

package uk.ac.uea.nostromo.ash;

import uk.ac.uea.nostromo.mother.Screen;
import uk.ac.uea.nostromo.mother.implementation.AndroidGame;

/**
 * The main activity for Ash that is launch when the app is launched
 * for the first time.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.1.0
 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
 */
class MainActivity extends AndroidGame {
	/**
	 * {@inheritDoc}
	 *
	 * @return	{@inheritDoc}
	 */
	@Override
	public Screen getInitScreen() {
		throw new UnsupportedOperationException("The method `MainActivity.getInitScreen()` is yet to be implemented.");
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
		currentScreen.backButton();
	}
};
