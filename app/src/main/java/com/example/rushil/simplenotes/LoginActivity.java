package com.example.rushil.simplenotes;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.example.rushil.simplenotes.API.Client;

/**
 * Created by Rushil on 8/6/2017.
 */

public class LoginActivity extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button registerButton;
    TextView emptyUserTextView;
    TextView emptyPasswordTextView;
    TextView emptyUserAndPasswordTextView;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        client= new Client();
        userNameEditText= (EditText) findViewById(R.id.userNameEditText);
        passwordEditText=(EditText) findViewById(R.id.passwordEditText);
        loginButton=(Button) findViewById(R.id.loginButton);
        registerButton=(Button) findViewById(R.id.registerButton);
        emptyUserTextView=(TextView)findViewById(R.id.emptyUserNameTextView);
        emptyPasswordTextView=(TextView)findViewById(R.id.emptyPasswordTextView);
        emptyUserAndPasswordTextView=(TextView)findViewById(R.id.emptyUsernameAndPasswordTextView);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
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
                client.loginUsername(userNameEditText.getText().toString(),passwordEditText.getText().toString());
            }
        });
    }
}
