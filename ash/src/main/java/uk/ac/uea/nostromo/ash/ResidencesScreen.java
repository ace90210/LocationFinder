/*
 * ResidencesScreen.java	v0.4.0	2016-01-13
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.widget.ExpandableListView;
import uk.ac.uea.nostromo.mother.DataObject;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;
import uk.ac.uea.nostromo.mother.XMLDatastrategy;

/**
 * Present a list of all the residences found on campus.
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v0.4.0
 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
 */
public class ResidencesScreen extends Screen {
    /**
     * @param	game	{@inheritDoc}
     * @param	context	{@inheritDoc}
     * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
     */
    public ResidencesScreen(Game game, Context context) {
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
		ExpandableListView listView;
		ExpandableListAdapter listAdapter;
		XMLDatastrategy dataStrategy;
		DataObject<XMLDatastrategy.MapRow> mapTable, accomodations;

		activity = (MainActivity) game;
        activity.setContentView(R.layout.category_list_screen);

		listAdapter = new ExpandableListAdapter(context);

		dataStrategy = new XMLDatastrategy("mapdata.xml", context);
		mapTable = game.getDataIO().readDataList(dataStrategy);
		accomodations = mapTable.search(new Comparable<XMLDatastrategy.MapRow>() {
			@Override
			public int compareTo(XMLDatastrategy.MapRow o) {
				String requiredType, comparedType;

				requiredType = "accommodation";
				comparedType = o.getType();

				return requiredType.equalsIgnoreCase(comparedType) == true ? 1 : 0;
			}
		});

		for (DataObject dataObject : accomodations) {
			XMLDatastrategy.MapRow row;
			String title, caption;

			row = ((XMLDatastrategy.MapRow)((DataObject)dataObject.getData()).getData());
			title = row.getName();
			caption = row.getDescription();

			listAdapter.addEntry(title, caption);
		}

		listView = (ExpandableListView) activity.findViewById(R.id.category_list);
		listView.setAdapter(listAdapter);
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
