package ro.pub.cs.systems.eim.Colocviu1_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private TextView text;
    private int number;

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            number++;
            if (view.getId() == R.id.button_north) {
                if (text.getText() == "") {
                    text.setText("North");
                } else {
                text.setText(text.getText() + ", North");}
            } else if (view.getId() == R.id.button_east) {
                if (text.getText() == "") {
                    text.setText("East");
                } else {
                text.setText(text.getText() + ", East");}
            } else if (view.getId() == R.id.button_west) {
                if (text.getText() == "") {
                    text.setText("West");
                } else {
                text.setText(text.getText() + ", West");}
            } else if (view.getId() == R.id.button_south) {
                if (text.getText() == "") {
                    text.setText("South");
                } else {
                text.setText(text.getText() + ", South");}
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);

        text = (TextView) findViewById(R.id.textView);
        Button north_b = (Button) findViewById(R.id.button_north);
        north_b.setOnClickListener(buttonClickListener);

        Button east_b = (Button) findViewById(R.id.button_east);
        east_b.setOnClickListener(buttonClickListener);

        Button west_b = (Button) findViewById(R.id.button_west);
        west_b.setOnClickListener(buttonClickListener);

        Button south_b = (Button) findViewById(R.id.button_south);
        south_b.setOnClickListener(buttonClickListener);

        if (savedInstanceState.containsKey("Total")) {
            number = Integer.valueOf(savedInstanceState.getString("Total"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Total", String.valueOf(number));
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("Total")) {
            number = Integer.valueOf(savedInstanceState.getString("Total"));
        }
    }
}