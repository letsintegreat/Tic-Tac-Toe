package com.android.zlytherin.game.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("MODE_TYPE", 1);
                Intent main = new Intent(AskActivity.this, MainActivity.class);
                main.putExtras(bundle);
                startActivity(main);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("MODE_TYPE", 2);
                Intent main = new Intent(AskActivity.this, MainActivity.class);
                main.putExtras(bundle);
                startActivity(main);
            }
        });
    }
}
