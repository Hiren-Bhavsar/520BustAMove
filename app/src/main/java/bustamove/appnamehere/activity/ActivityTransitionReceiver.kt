package bustamove.appnamehere.activity

import android.content.Context
import android.content.Intent
import com.google.android.gms.location.ActivityTransitionResult

//Code based on android examples provided by Google
//https://developer.android.com/guide/topics/location/transition

class ActivityTransitionReceiver {

    fun onReceive(context: Context, intent: Intent) {
        if (ActivityTransitionResult.hasResult(intent)) {
            val activityResult = ActivityTransitionResult.extractResult(intent)!!
            activityResult.let {
                activityResult.transitionEvents.forEach{activityEvent ->
                    val activityInfo = ActivityTransitionsUtility.toTransitionType(activityEvent.transitionType) + " " + ActivityTransitionsUtility.toActivityString(activityEvent.activityType);
                }
            }
        }
    }
}