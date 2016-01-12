/*
 * HomeScreen.java	v0.1.0	2016-01-12
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;

/**
 * The initial screen that is created and used by {@code MainActivity}.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.1.0
 * @see		MainActivity#getInitScreen()
 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
 */
public class HomeScreen extends Screen {
	/**
	 * @param	game	{@inheritDoc}
	 * @param	context	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	public HomeScreen(Game game, Context context) {
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

		/* This is such a great example of poor design (both on our
		 * part, and the part of the original framework).
		 */
		activity = (MainActivity) game;
		activity.setContentView(R.layout.home_screen);
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
	}
}
