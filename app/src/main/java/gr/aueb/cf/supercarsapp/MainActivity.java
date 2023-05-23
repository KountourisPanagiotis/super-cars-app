package gr.aueb.cf.supercarsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Simple login page with credentials validation.
 * Author: Kountouris Panagiotis
 */
public class MainActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView forgotTV;
    private TextView signUpHereTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        forgotTV = findViewById(R.id.forgotTV);
        signUpHereTV = findViewById(R.id.signUpHereTV);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = usernameET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();

                if (isValidCredentials(username, password)){
                    displayWelcomeMessage(username);
                }else{
                    displayErrorMessage();
                }
            }
        });
    }

    private boolean isValidCredentials(String username, String password){
        return username.equals("admin") && password.equals("password");
    }

    private void displayWelcomeMessage(String username){
        String message = "Welcome " + username;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public void displayErrorMessage(){
        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}