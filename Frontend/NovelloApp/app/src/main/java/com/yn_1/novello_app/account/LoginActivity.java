package com.yn_1.novello_app.account;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.yn_1.novello_app.NavBarActivity;
import com.yn_1.novello_app.R;
import com.yn_1.novello_app.volley_requests.VolleyCommand;
import com.yn_1.novello_app.volley_requests.JsonObjectRequester;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Activity for logging in. Start screen upon opening app.
 */
public class LoginActivity extends AppCompatActivity {

    EditText usernameInputView;
    EditText passwordInputView;
    Button login;
    Button createAccount;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInputView = findViewById(R.id.inputUsername);
        passwordInputView = findViewById(R.id.inputPassword);
        login = findViewById(R.id.login);
        createAccount = findViewById(R.id.createAccount);

        login.setOnClickListener(v -> {
            JsonObjectRequester userRequester = new JsonObjectRequester();
            JsonObjectCommand command = new JsonObjectCommand();
            username = usernameInputView.getText().toString();
            password = passwordInputView.getText().toString();
            JSONObject accountCredentialsJson = new JSONObject();
            try {
                accountCredentialsJson.put("username", username);
                accountCredentialsJson.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            userRequester.getRequest("person", accountCredentialsJson, command, null, null);
        });

        createAccount.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateAccountActivity.class);
            startActivity(intent);
        });

    }

    /**
     * Moves to starting screen after login (dashboard)
     * @param userID is the user's ID. It is 0 if the login failed.
     */
    private void loginResult(int userID) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if (userID != 0) {
            AdultUser user = new AdultUser(username, password, userID);
            Intent intent = new Intent(this, NavBarActivity.class);
            intent.putExtra("USER", (Serializable) user);
            startActivity(intent);
            alert.setMessage("Login succeeded! Pretend like this went to the dashboard like it's supposed to!");
        }
        else {
            alert.setMessage("Login failed. Try again!");
        }
        alert.show();

    }

    /**
     * Class used to get result of request
     */
    private class JsonObjectCommand implements VolleyCommand<JSONObject> {

        @Override
        public void execute(JSONObject data) {
            try {
                int userID;
                if (data != null) {
                    userID = data.getInt("userID");
                }
                else {
                    userID = 0;
                }
                loginResult(userID);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(VolleyError error) {

        }

    }

}