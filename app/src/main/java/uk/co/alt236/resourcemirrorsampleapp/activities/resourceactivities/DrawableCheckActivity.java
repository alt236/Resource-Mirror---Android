package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;

import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.util.DrawableAdapter;
import uk.co.alt236.resourcemirrorsampleapp.util.IconArray;

public class DrawableCheckActivity extends BaseListActivity{
	private static final int RESULT_SET_SIZE = 500;

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawables);
		getListView().setBackgroundColor(Color.parseColor("#c0c0c0"));
		onRandomiseClick(null);
	}

	public void onRandomiseClick(final View v){
        final ListAdapter adapter = new DrawableAdapter(this, geMirror(), IconArray.getSimpleDrawableList(RESULT_SET_SIZE));
		getListView().setAdapter(adapter);
	}
}
