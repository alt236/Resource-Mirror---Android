package uk.co.alt236.resourcemirror.testing;

import android.content.Context;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = {16, 17, 18, 19, 21, 22, 23, 24, 25})
public abstract class BaseRobolectricTest {

    protected Context getContext() {
        return RuntimeEnvironment.application;
    }
}