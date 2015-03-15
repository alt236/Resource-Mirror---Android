package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.TextUtils;

import uk.co.alt236.resourcemirror.reflectors.Mirror;
import uk.co.alt236.resourcemirror.util.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.activities.MainActivity;

public abstract class BaseListActivity extends ListActivity{
	private ResourceType mResourceType;

	protected Mirror geMirror(){
		//return Mirror.on("android");
		return Mirror.with(this);
	}

	protected ResourceType getResourceType(){
		return mResourceType;
	}

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		final Bundle b = getIntent().getExtras();
		if(b != null && !TextUtils.isEmpty(b.getString(MainActivity.EXTRA_RESOURCE_NAME))){
			mResourceType = ResourceType.fromString(b.getString(MainActivity.EXTRA_RESOURCE_NAME));
			setTitle(mResourceType.getResourceName());
		}
	}
}
