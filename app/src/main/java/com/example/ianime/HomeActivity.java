package com.example.ianime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ianime.Common.Constant;
import com.example.ianime.databinding.ActivityHomeBinding;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private ActivityHomeBinding activityHomeBinding;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions googleSignInOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = activityHomeBinding.getRoot();
        setContentView(view);

//        googleSignInOptions = new GoogleSignInOptions
//                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        googleApiClient = new GoogleApiClient.Builder(this)
//                .enableAutoManage(this, this)
//                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();

        activityHomeBinding.logoutBtn.setOnClickListener(v -> executeLogout());
    }

    private void executeLogout() {
        if (LoginManager.getInstance() != null) {
            LoginManager.getInstance().logOut();
        } else {
            FirebaseAuth.getInstance().signOut();
        }
        logoutToLoginPage();

//        if (googleApiClient != null) {
//            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(status -> {
//                if (status.isSuccess()) {
//                    logoutToLoginPage();
//                } else {
//                    Toast.makeText(this, "Logout Failed", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void logoutToLoginPage() {
//        Constant.loginUsingFb = false;
//        Constant.loginUsingGg = false;
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

//    private void handleGoogleSignInResult(GoogleSignInResult googleSignInResult) {
//        if (googleSignInResult.isSuccess()) {
//            GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();
//            Log.d("Google Account", "" + googleSignInAccount);
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
//        OptionalPendingResult<GoogleSignInResult> signInResult =
//                Auth.GoogleSignInApi.silentSignIn(googleApiClient);
//        if (signInResult.isDone()) {
//            GoogleSignInResult googleSignInResult = signInResult.get();
//            handleGoogleSignInResult(googleSignInResult);
//        } else {
//            signInResult.setResultCallback(this::handleGoogleSignInResult);
//        }
//    }
    }
}