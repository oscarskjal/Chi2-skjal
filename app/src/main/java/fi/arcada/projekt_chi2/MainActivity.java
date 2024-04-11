package fi.arcada.projekt_chi2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4;
    private int val1, val2, val3, val4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

    }

    /**
     *  Klickhanterare för knapparna
     */
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

        calculate();
    }

    /**
     * Metod som uppdaterar layouten och räknar ut själva analysen.
     */
    public void calculate() {

        button1.setText("Val 1: " + val1);
        button2.setText("Val 2: " + val2);
        button3.setText("Val 3: " + val3);
        button4.setText("Val 4: " + val4);


        double chi2 = Significance.chiSquared(val1, val2, val3, val4);


        double pValue = Significance.getP(chi2);

        String resultMessage = "Chi^2: " + chi2 + "\n" +
                "p-värde: " + pValue;

        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();

        /**
         *  - Visa chi2 och pValue åt användaren på ett bra och tydligt sätt!
         *
         *  - Visa procentuella andelen jakande svar inom de olika grupperna.
         *    T.ex. (val1 / (val1+val3) * 100) och (val2 / (val2+val4) * 100
         *
         *  - Analysera signifikansen genom att jämföra p-värdet
         *    med signifikansnivån, visa reultatet åt användaren
         *
         */

    }


}