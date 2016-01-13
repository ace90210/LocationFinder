/*
 * ExpandableListAdapter.java	v3.1.0	2016-01-13
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import uk.ac.uea.nostromo.mother.Location;
import uk.ac.uea.nostromo.mother.implementation.AndroidGame;

/**
 * {@inheritDoc}
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v3.1.0
 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {
	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	private Context context;

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	private AndroidGame game;

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	private List<String> titles;

	/**
	 * The {@code ExpandableListAdapter} interface is implied to have
	 * multiple children. This is not the case for this container.
	 *
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	private List<String> captions;

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	private List<Location> locations;

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	public ExpandableListAdapter(AndroidGame currentGame, Context currentContext) {
		titles = new ArrayList<String>();
		captions = new ArrayList<String>();
		locations = new ArrayList<Location>();

		context = currentContext;
		game = currentGame;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public int getGroupCount() {
		return titles.size();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public Object getGroup(int groupPosition) {
		return titles.get(groupPosition);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @param	childPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return captions.get(childPosition);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @param	childPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public boolean hasStableIds() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @param	isExpanded		{@inheritDoc}
	 * @param	convertView		{@inheritDoc}
	 * @param	parent			{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		TextView textView;

		textView = new TextView(context);
		textView.setText(titles.get(groupPosition));

		return textView;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @param	childPosition	{@inheritDoc}
	 * @param	isLastChild		{@inheritDoc}
	 * @param	convertView		{@inheritDoc}
	 * @param	parent			{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		LinearLayout linearLayout;
		TextView textView;
		Button button;

		linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.VERTICAL);

		textView = new TextView(context);
		textView.setText(captions.get(childPosition));

		button = new LocationButton(game, context, locations.get(childPosition), titles.get(groupPosition));
		button.setText("Take me here!");

		linearLayout.addView(textView);
		linearLayout.addView(button);

		return linearLayout;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param	groupPosition	{@inheritDoc}
	 * @param	childPosition	{@inheritDoc}
	 * @return	{@inheritDoc}
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	/**
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	public void addEntry(String title, String caption, Location location) {
		titles.add(title);
		captions.add(caption);
		locations.add(location);
	}

	/**
	 * Store a given location so that we can make use of it when the
	 * user interacts with us.
	 *
	 * <p>This is a horrendous hack. If there is a God hopefully he will
	 * have mercy on my fragile soul.</p>
	 *
	 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
	 * @version	v0.1.0
	 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
	 */
	public class LocationButton extends Button {
		/**
		 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
		 */
		private Location desiredLocation;

		/**
		 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
		 */
		private String desiredTag;

		/**
		 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
		 */
		private AndroidGame game;

		/**
		 *
		 */
		private Context context;

		/**
		 * @since	!_TODO__ [Alex Melbourne] : Update this value when forking a release.
		 */
		public LocationButton(AndroidGame currentGame, Context currentContext, Location location, String tag) {
			super(currentContext);

			game = currentGame;
			context = currentContext;
			desiredLocation = location;
			desiredTag = tag;

			super.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					LocationScreen newScreen;

					newScreen = new LocationScreen(game, context);
					if (newScreen != null) {
						newScreen.setLocation(desiredLocation);
						newScreen.setTagTitle(desiredTag);
						game.setScreen(newScreen);
					}
				}
			});
		}
	}
}
