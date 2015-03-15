package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities;

import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.List;

import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.util.GenericAdapter;

public class GenericCheckActivity extends BaseListActivity{


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_generic_list);

		final List<String> resourceList = geMirror().getReflector(getResourceType()).getResourceList();
		final ListAdapter adapter = new GenericAdapter(
				this,
                geMirror(),
				getResourceType(),
				resourceList);

		setListAdapter(adapter);
	}
}
