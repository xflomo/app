package de.fb_dev.app.eduardflo;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {

        //Getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX  Refresh Called");

        //Displaying token on logcat
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }

}
