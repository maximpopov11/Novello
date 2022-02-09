package com.example.e4_websocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    Socket socket;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView1);

        // Implementing a thread, because you can't do network stuff on the main thread.
        Thread thread = new Thread(() -> {
            try  {
                try {
                    // Create a web scoket and read the first line from the url
                    socket = new Socket("http://10.0.2.2", 80);
                    System.out.println("Connected");
                    socket.setKeepAlive(true);
                    inputStream = new DataInputStream(System.in);
                    outputStream = new DataOutputStream(System.out);
                    String line = inputStream.readUTF();
                    outputStream.writeUTF(line);
                    textView.setText("Websocket Testing:\n " + line);
                } catch (IOException e) {
                    e.printStackTrace();
                    this.finishActivity(-1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}