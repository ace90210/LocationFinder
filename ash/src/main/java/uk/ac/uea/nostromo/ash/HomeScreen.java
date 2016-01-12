/*
 * HomeScreen.java	v0.1.1	2016-01-12
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;

/**
 * The initial screen that is created and used by {@code MainActivity}.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.1.1
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
		final MainActivity activity;

		Button amenitiesButton, generalButton, residenceButton, schoolsButton;

		/* This is such a great example of poor design (both on our
		 * part, and the part of the original framework).
		 */
		activity = (MainActivity) game;
		activity.setContentView(R.layout.home_screen);

		amenitiesButton = (Button) activity.findViewById(R.id.category_amenities);
		amenitiesButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Screen newScreen;

				newScreen = new AmenitiesScreen(game, context);
				if (newScreen != null) {
					activity.setScreen(newScreen);
				}
			}
		});

		generalButton = (Button) activity.findViewById(R.id.category_general);
		generalButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Screen newScreen;

				newScreen = new ServicesScreen(game, context);
				if (newScreen != null) {
					activity.setScreen(newScreen);
				}
			}
		});

		residenceButton = (Button) activity.findViewById(R.id.category_residences);
		residenceButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Screen newScreen;

				newScreen = new ResidencesScreen(game, context);
				if (newScreen != null) {
					activity.setScreen(newScreen);
				}
			}
		});

		schoolsButton = (Button) activity.findViewById(R.id.category_schools);
		schoolsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Screen newScreen;

				newScreen = new SchoolsScreen(game, context);
				if (newScreen != null) {
					activity.setScreen(newScreen);
				}
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
	}
}
