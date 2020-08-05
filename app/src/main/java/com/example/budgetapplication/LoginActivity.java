package com.example.budgetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    TextView textView01;
    Button button;
    EditText mEmail,mPassword;
    CheckBox rememberme;
    FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail= findViewById(R.id.userEmail);
        mPassword= findViewById(R.id.pwd);
        rememberme=findViewById(R.id.checkBox2);
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox= preferences.getString("remember","");
        if (checkbox.equals("True")){
            Toast.makeText(LoginActivity.this,"Logged in Successfully", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(LoginActivity.this,Home.class);
            startActivity(intent);

        }else if (checkbox.equals("False")){

        }

        fAuth=FirebaseAuth.getInstance();
        textView = (TextView) findViewById(R.id.Signup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        rememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor =preferences.edit();
                    editor.putString("remember","True");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"Checked",Toast.LENGTH_LONG).show();
                }else if(!buttonView.isChecked()){
                    SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                    SharedPreferences.Editor editor =preferences.edit();
                    editor.putString("remember","False");
                    editor.apply();
                    Toast.makeText(LoginActivity.this,"UnChecked",Toast.LENGTH_LONG).show();
                }
            }
        });
        textView01 = (TextView) findViewById(R.id.TVforgotPwd);
        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail =new EditText((v.getContext()));
                AlertDialog.Builder passwordResetdialogue = new AlertDialog.Builder(v.getContext());
                passwordResetdialogue.setTitle("Reset Password?");
                passwordResetdialogue.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetdialogue.setView(resetMail);
                passwordResetdialogue.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail =resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this,"Reset Link Sent To Your Email",Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this,"Error ! Reset Link is not Sent" + e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                passwordResetdialogue.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordResetdialogue.create().show();
            }
        });
        button = findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String email =mEmail.getText().toString().trim();
                String password =mPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required.");
                    return;
                }
                if (password.length()<6){
                    mPassword.setError("Password must be greater or equal to 6 characters");
                    return;
                }

                //Authenticate User
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(fAuth.getCurrentUser().isEmailVerified()){

                                Toast.makeText(LoginActivity.this,"Logged in Successfully", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),Home.class));
                                mPassword.getText().clear();
                                mEmail.getText().clear();
                            }else{
                                Toast.makeText(LoginActivity.this,"Please Verify Your Email Address to Login", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Error !!" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });



    }
}

