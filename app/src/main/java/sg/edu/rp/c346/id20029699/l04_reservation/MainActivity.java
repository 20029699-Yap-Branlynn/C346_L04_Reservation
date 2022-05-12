package sg.edu.rp.c346.id20029699.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText number;
    EditText pax;
    DatePicker dp;
    TimePicker tp;
    CheckBox cb;
    Button confirm;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        number = findViewById(R.id.editTextPhoneNum);
        pax = findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cb = findViewById(R.id.checkBoxSmoking);
        confirm = findViewById(R.id.buttonConfirm);
        reset = findViewById(R.id.buttonReset);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();

                String nameData = name.getText().toString();
                String phoneData = number.getText().toString();
                String paxData = pax.toString();
                if(nameData.isEmpty() == true){
                    Toast.makeText(MainActivity.this, "Name should not be empty", Toast.LENGTH_LONG).show();
                }else if (phoneData.isEmpty() == true){
                    Toast.makeText(MainActivity.this, "Phone number should not be empty", Toast.LENGTH_LONG).show();
                }else if (paxData.isEmpty() == true){
                    Toast.makeText(MainActivity.this, "Pax should not be empty", Toast.LENGTH_LONG).show();
                }else if (nameData.isEmpty() == false && phoneData.isEmpty() == false && paxData.isEmpty() == false){
                    if (cb.isChecked() == true){
                        String msg = name + " Your reservation for "
                                + pax + " on " + day+ "/" + month + "/" + year + " at " + hour + ":" + min +
                                " in the smoking area has been confirmed. See you soon!";

                        Toast.makeText(MainActivity.this, "Reservation in smoking area Confirmed", Toast.LENGTH_LONG).show();
                    }else {
                        String msg = name + " Your reservation for "
                                + pax + " on " + day+ "/" + month + "/" + year + " at " + hour + ":" + min +
                                " has been confirmed. See you soon!";

                        Toast.makeText(MainActivity.this, "Reservation Confirmed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                number.setText("");
                pax.setText("");
                cb.setChecked(false);
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });



    }
}