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

        // Add Token to Database
        sendRegistrationToServer(refreshedToken, 1);

        //Displaying token on logcat
        Log.d(TAG, "Refreshed token: " + refreshedToken);

    }

    private void sendRegistrationToServer(String token, Integer userId) {
        Log.d(TAG, "XXXXXXX Request Send");
        //TODO userId is set in Php code change it if userlogin exitsts
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("token",token)
                .build();

        Request request = new Request.Builder()
                .url("http://www.app.dev/app?appVerifier=eduardFlorianMotherfuckergang&appCall=addToken")
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
