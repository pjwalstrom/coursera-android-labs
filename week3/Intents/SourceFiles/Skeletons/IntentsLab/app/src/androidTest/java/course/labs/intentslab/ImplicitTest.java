package course.labs.intentslab;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.robotium.solo.Solo;

import course.labs.intentslab.ActivityLoaderActivity;

public class ImplicitTest extends
		ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
	private Solo solo;
    static private final String TAG = "Lab-Intents";

	public ImplicitTest() {
		super(ActivityLoaderActivity.class);
	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation());
		getActivity();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}
	
	// Executes the ImplicitTest
	public void testRun() {

        Log.i(TAG, "Entered testRun()");
		// =================== Section One =====================

		// Wait for activity: 'course.labs.intentslab.ActivityLoaderActivity'
		assertTrue(
				"ImplicitTest:" +
				"Section One:" +
				"ActivityLoaderActivity did not load correctly",
				solo.waitForActivity(ActivityLoaderActivity.class));
        Log.i(TAG, "Entered testRun() 2");

		// Click on Implicit Activation Button
		solo.clickOnView(solo
				.getView(R.id.implicit_activation_button));

        Log.i(TAG, "Entered testRun() 3");


        // Wait for activity: 'com.android.internal.app.ChooserActivity'
		assertTrue(
				"ImplicitTest:" +
				"Section One:" +
				"ChooserActivity was not launched correctly",
				solo.waitForActivity("ChooserActivity"));

        Log.i(TAG, "Entered testRun() 4");

        // Click on MyBrowser
		solo.clickInList(2, 0);
		
		

	}
}
