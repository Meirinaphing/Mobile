package com.a12234.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    private EditText edtEmail;
//    private EditText edtPass;
//
//    private static final String TAG = "EmailPassword";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        edtEmail = (EditText) findViewById(R.id.edtEmail);
//        edtPass = (EditText) findViewById(R.id.edtPass);
//        findViewById(R.id.btnLogin).setOnClickListener(this);
//
//        mAuth = FirebaseAuth.getInstance();
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void signIn(String email, String password) {
//        Log.d(TAG, "signIn:" + email);
//
//        // [START sign_in_with_email]
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(MainActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//        // [END sign_in_with_email]
//    }
//
//    private void updateUI(FirebaseUser user) {
//        if (user != null) {
//            Toast.makeText(this, "MASUK", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(getApplicationContext(), home_menu_page.class));
//        } else {
//            Toast.makeText(this, "GAGAL MASUK", Toast.LENGTH_LONG).show();
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        int i = v.getId();
//        if (i == R.id.btnLogin) {
//            signIn(edtEmail.getText().toString(), edtPass.getText().toString());
//        }
//    }
//}

    //Defining view Object - Mei
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLogin;

//    private ProgressBar progressBar;

    //defining firebaseAuth object
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authListener;

    private static final String TAG = "EmailPassword";

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(authListener != null){
            firebaseAuth.removeAuthStateListener(authListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        progressBar.setVisibility(View.INVISIBLE);

        firebaseAuth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    // User is Signin
                    finish();
                    startActivity(new Intent(getApplicationContext(), home_menu_page.class));
                }else{
                    //user is sign Out
                }
            }
        };



//        if(firebaseAuth.getCurrentUser() != null){
////             Start home_menu_page - activity_home - Mei
//            finish();
//            startActivity(new Intent(getApplicationContext(), home_menu_page.class));
//        }

        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPass = (EditText)findViewById(R.id.edtPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        //action saat tombol login diklik - Mei
        btnLogin.setOnClickListener(this);
    }

    private void userLogin(){
        // get email and pass from editText - Mei
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();

        //Checking email and pass are empty - Mei
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Masukkan Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Masukkan password", Toast.LENGTH_SHORT).show();
            return;
        }


        //Jika email dan pass tdk empty munculkan progress dialog - Mei
//            progressBar = (ProgressBar)findViewById(R.id.progressBar);
//            progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressBar.setVisibility(View.INVISIBLE);

                        if(task.isSuccessful()){
                            Log.d(TAG, "signInWithEmail:onComplete"+task.isSuccessful());
                            Toast.makeText(getApplicationContext(), "~~", Toast.LENGTH_LONG).show();
//                            Toast.makeText(getApplicationContext(), "Masuk", Toast.LENGTH_SHORT).show();
//                            // Start home_menu_page - activity_home - Mei
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), home_menu_page.class));
                        }else{
                            Log.w(TAG, "signInWithEmail:onComplete"+task.getException());
                            Toast.makeText(getApplicationContext(), "Email/Password Salah !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            userLogin();
        }
    }
}
