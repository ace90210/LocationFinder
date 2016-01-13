/*
 * LocationScreen.java	v0.1.0	2016-01-31
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;

/**
 * Take a location from another screen and display it via Google Maps
 * to the user.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.1.0
 * @since	!_TODO__ [Alex Melbourne] : Modify this values when forking a release later.
 */
public class LocationScreen extends Screen {
	/**
	 * @param	game	{@inheritDoc}
	 * @param	context	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Modify this values when forking a release later.
	 */
	public LocationScreen(Game game, Context context) {
		super(game, context);

		resume();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	deltaTime	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void update(float deltaTime) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	deltaTime	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void paint(float deltaTime) {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void pause() {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void resume() {
		MainActivity activity;

		activity = (MainActivity) game;
		activity.setContentView(R.layout.location_display_screen);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public void backButton() {
		Screen newScreen;

		newScreen = new HomeScreen(game, context);
		if (newScreen != null) {
			((MainActivity) game).setScreen(newScreen);
		}
	}
}
