package com.example.rushil.simplenotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.rushil.simplenotes.API.Client;

/**
 * Created by Rushil on 8/7/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;
    Button signUpButton;
    TextView emptyUserTextView;
    TextView emptyPasswordTextView;
    TextView emptyUserAndPasswordTextView;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        client=new Client();
        initViews();
    }

    private void initViews(){
        userNameEditText=(EditText)findViewById(R.id.registerNameEditText);
        passwordEditText=(EditText)findViewById(R.id.registerPasswordEditText);
        signUpButton=(Button)findViewById(R.id.signUpButton);
        emptyUserTextView=(TextView)findViewById(R.id.emptyUserNameTextView);
        emptyPasswordTextView=(TextView)findViewById(R.id.emptyPasswordTextView);
        emptyUserAndPasswordTextView=(TextView)findViewById(R.id.emptyUsernameAndPasswordTextView);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //username and password check
                if(!Util.usernameMatchRequirements(userNameEditText.getText().toString())
                        &&!Util.passwordMatchRequirements(passwordEditText.getText().toString())){
                    emptyUserAndPasswordTextView.setVisibility(View.VISIBLE);
                }else{
                    emptyUserAndPasswordTextView.setVisibility(View.INVISIBLE);
                }
                //username check
                if(!Util.usernameMatchRequirements(userNameEditText.getText().toString())
                        &&Util.passwordMatchRequirements(passwordEditText.getText().toString())){
                    emptyUserTextView.setVisibility(View.VISIBLE);
                }else{
                    emptyUserTextView.setVisibility(View.INVISIBLE);
                }
                //password check
                if(!Util.passwordMatchRequirements(passwordEditText.getText().toString())
                        &&Util.usernameMatchRequirements(userNameEditText.getText().toString())){
                    emptyPasswordTextView.setVisibility(View.VISIBLE);
                }else{
                    emptyPasswordTextView.setVisibility(View.INVISIBLE);
                }

                //New User
                Log.d("RegisterActivity-User",
                        String.valueOf(client.postUsername(userNameEditText.getText().toString()
                                ,passwordEditText.getText().toString())));
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
    }
}
