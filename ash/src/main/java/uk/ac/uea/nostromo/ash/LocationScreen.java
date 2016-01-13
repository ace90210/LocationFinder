/*
 * LocationScreen.java	v0.2.1	2016-01-13
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;
import uk.ac.uea.nostromo.mother.implementation.Graphics;

/**
 * Take a location from another screen and display it via Google Maps
 * to the user.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.2.1
 * @since	!_TODO__ [Alex Melbourne] : Modify this values when forking a release later.
 */
public class LocationScreen extends Screen {
	/**
	 * @since	!_TODO__ [Alex Melbourne] : Modify this values when forking a release later.
	 */
	private static final String TAG = "LocationScreen";

	/**
	 * @param	game	{@inheritDoc}
	 * @param	context	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Modify this values when forking a release later.
	 */
	public LocationScreen(Game game, Context context) {
		super(game, context);
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
		Graphics.MyGoogleMap googleMapFragment;
		Graphics graphics;

		activity = (MainActivity) game;
		activity.setContentView(R.layout.location_display_screen);

		graphics = game.getGraphics();
		googleMapFragment = graphics.newMap(activity, R.id.google_map_container,
				new OnMapReadyCallback() {
					@Override
					public void onMapReady(GoogleMap googleMap) {
						Log.i(TAG, "Our `GoogleMap` object is ready for us " +
								"to make use of.");
					}
				});
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
