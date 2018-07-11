package org.akshanshgusain.sessionmanagement;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText mName,mEmail;
    private Button mButton;
    private SessionManager mSessionManager;
    private AlertDialogManager mAlert=new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName=(TextInputEditText) findViewById(R.id.login_name_et);
        mEmail=(TextInputEditText) findViewById(R.id.login_email_et);
        mButton=findViewById(R.id.login_loginBtn);
        mSessionManager=new SessionManager(this);
        Toast.makeText(this, "UserLogin Status:"+mSessionManager.isLoggedIn(), Toast.LENGTH_SHORT).show();
         mButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String username=mName.getText().toString();
                  String email=mEmail.getText().toString();
                       //Check wether the username or password is empty
                    if(username.trim().length()>0 && email.trim().length()>0){
                            if(username.equalsIgnoreCase("test") && email.equalsIgnoreCase("test")){
                                //Creating new session
                                mSessionManager.createLoginSession(username,email);
                                  //Redirecting to main activity
                                Intent i=new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();
                                }else
                            {
                                mAlert.showAlertDialog(LoginActivity.this,"Login Failed","Invalid Username or password",false);

                            }
                    }else{
                        mAlert.showAlertDialog(LoginActivity.this,"Login Failed","Enter username and/or password",false);
                    }

             }
         });
    }
}
