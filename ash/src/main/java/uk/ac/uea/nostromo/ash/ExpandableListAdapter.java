/*
 * ExpandableListAdapter.java	v1.0.0	2016-01-12
 */

package uk.ac.uea.nostromo.ash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.0.0
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
	public ExpandableListAdapter(Context currentContext) {
		titles = new ArrayList<String>();
		captions = new ArrayList<String>();

		context = currentContext;
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
		TextView textView;

		textView = new TextView(context);
		textView.setText(captions.get(childPosition));

		return textView;
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
	public void addEntry(String title, String caption) {
		titles.add(title);
		captions.add(caption);
	}
}
