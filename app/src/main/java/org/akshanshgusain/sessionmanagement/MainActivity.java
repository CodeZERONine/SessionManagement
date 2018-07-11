package org.akshanshgusain.sessionmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import static org.akshanshgusain.sessionmanagement.SessionManager.KEY_EMAIL;
import static org.akshanshgusain.sessionmanagement.SessionManager.KEY_NAME;

//Session management using shared preference
public class MainActivity extends AppCompatActivity {
    private TextView mName,mEmail;
    private Button mButton;
    private AlertDialogManager mAlert=new AlertDialogManager();
    private SessionManager mSessionManager;//v1 end
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName=findViewById(R.id.main_name);
        mEmail=findViewById(R.id.main_email);
        mButton=findViewById(R.id.main_logout_btn);
        mSessionManager=new SessionManager(this);
        mSessionManager.checkLogin();

        HashMap<String,String> user=mSessionManager.getUserDetails();
        mName.setText(user.get(KEY_NAME));
        mEmail.setText(user.get(KEY_EMAIL));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSessionManager.logoutUser();
            }
        });


    }
}
