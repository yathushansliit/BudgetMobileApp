package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText mUsername,mPhoneNo,mEmail,mPassword,mRePassword;
    Button mSignUpBtn,mRadio_Single,mRadio_Married;
    TextView textView;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mUsername= findViewById(R.id.userNameSignup);
        mPhoneNo= findViewById(R.id.userPhoneNo);
        mEmail= findViewById(R.id.email);
        mPassword= findViewById(R.id.pwdSignup);
        mRePassword= findViewById(R.id.pwdReEnter);
        mSignUpBtn=findViewById(R.id.nextBtn);
        mRadio_Single=findViewById(R.id.radio_Single);
        mRadio_Married=findViewById(R.id.radio_married);
        fAuth=FirebaseAuth.getInstance();

        textView = (TextView)findViewById(R.id.Login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        //Already user is logged in
        /*if (fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class) );
            finish();
        }*/

        mSignUpBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final String email =mEmail.getText().toString().trim();
                String pwd =mPassword.getText().toString().trim();
                String repwd=mRePassword.getText().toString().trim();
                String username=mUsername.getText().toString().trim();
                final Intent intent= new Intent(Intent.ACTION_SEND);;

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if (TextUtils.isEmpty(repwd)){
                    mRePassword.setError("ReEnter your Password.");
                    return;
                }
                if (TextUtils.isEmpty(username)){
                    mUsername.setError("Username is required.");
                    return;
                }
                if (pwd.length()<6){
                    mPassword.setError("Password must be greater or equal to 6 characters");
                    return;
                }
                if (!pwd.equals(repwd)){
                    mRePassword.setError("Mis Matching");
                    return;
                }

                //Firebase
                fAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            composeEmail(email,"Email verfification for budget friend");

                            // Navigate to User Verification
                           // Intent intentVeri = new Intent(SignupActivity.this,UserVerify.class);
                            //startActivity(intentVeri);
                        } else{
                            Toast.makeText(SignupActivity.this, "Error !!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    public void composeEmail(String addresses, String subject) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("*/*");
                        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });


            }
        });


    }
}
