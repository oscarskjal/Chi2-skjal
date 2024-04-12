package fi.arcada.projekt_chi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button button1, button2, button3, button4;
    public int val1 = 0, val2 = 0, val3 = 0, val4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }

    public void buttonClick(View view) {
        Button clickedButton = (Button) view;

        if (clickedButton.getId() == R.id.button1) {
            val1++;
        } else if (clickedButton.getId() == R.id.button2) {
            val2++;
        } else if (clickedButton.getId() == R.id.button3) {
            val3++;
        } else if (clickedButton.getId() == R.id.button4) {
            val4++;
        }


        button1.setText("Val 1: " + val1);
        button2.setText("Val 2: " + val2);
        button3.setText("Val 3: " + val3);
        button4.setText("Val 4: " + val4);


        calculate();
    }


    public void calculate() {

        int totalResponses = val1 + val2 + val3 + val4;


        button1.setText("Val 1: " + val1);
        button2.setText("Val 2: " + val2);
        button3.setText("Val 3: " + val3);
        button4.setText("Val 4: " + val4);

        double percentageOfButton1 = ((double) val1 / (val1 + val3)) * 100;


        double percentageOfButton2 = ((double) val2 / (val2 + val4)) * 100;


        TextView percentageTextView1 = findViewById(R.id.percentage_textview);
        percentageTextView1.setText("Andelen män som sover över 8h: " + percentageOfButton1 + "%");

        TextView percentageTextView2 = findViewById(R.id.percentage_textview_2);
        percentageTextView2.setText("Andelen kvinnor som sover över 8h: " + percentageOfButton2 + "%");


        double chi2 = Significance.chiSquared(val1, val2, val3, val4);
        double pValue = Significance.getP(chi2);


        double significanceLevel = 0.05;
        String significanceMessage;
        if (pValue < significanceLevel) {
            significanceMessage = "Resultatet är signifikant på signifikansnivån " + significanceLevel;
        } else {
            significanceMessage = "Resultatet är inte signifikant på signifikansnivån " + significanceLevel;
        }


        String resultMessage = "Chi^2: " + chi2 + "\n" +
                "p-värde: " + pValue + "\n" +
                significanceMessage;


        TextView resultTextView = findViewById(R.id.result_textview);
        resultTextView.setText(resultMessage);
    }


    public void resetValues(View view) {
        val1 = 0;
        val2 = 0;
        val3 = 0;
        val4 = 0;
        calculate();
    }

}