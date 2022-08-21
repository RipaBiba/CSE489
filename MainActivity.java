package edu.bd.ewu.cse489_project03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, place, date, capacity, budget, email, phone, description;
    RadioButton indoor, outdoor, online;
    Button cancel, share, save;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        place = findViewById(R.id.place);
        date = findViewById(R.id.datetime);
        capacity = findViewById(R.id.capacity);
        budget = findViewById(R.id.budget);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phonenumber);
        description = findViewById(R.id.description);

        indoor =  findViewById(R.id.indoor);
        outdoor =  findViewById(R.id.outdoor);
        online =  findViewById(R.id.online);

        cancel =  findViewById(R.id.cancel_button);
        share =  findViewById(R.id.share_button);
        save =  findViewById(R.id.save_button);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Canceled!", Toast.LENGTH_LONG).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Shared!", Toast.LENGTH_LONG).show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Saved!", Toast.LENGTH_LONG).show();
                String errormessage = "";

                if (name.length() < 5){
                    errormessage += "Name is not Valid\n";
                }
                if (place.length() < 6){
                    errormessage += "Place is not Valid\n";

                }
                if (email.length() < 13){
                    errormessage += "Email is not Valid\n";

                }

                String type="";
                if(indoor.isSelected()){
                    String ind = indoor.getText().toString();
                    type+="Indoor";
                }

                if(outdoor.isSelected()){
                    String ind = outdoor.getText().toString();
                    type+="Outdoor";
                }

                if(online.isSelected()){
                    String ind = online.getText().toString();
                    type+="Online";
                }

                if(budget.length() == 0){
                    errormessage += "Invalid Type\n";
                }
                if(date.length() < 8){
                    errormessage += "Date is not Valid\n";

                }

                String Capacity = capacity.getText().toString();
                if(capacity.getText().toString() == ""){
                    errormessage += "Capacity should  filled\n";
                }
                else{
                    Integer integerCapacity = Integer.parseInt(Capacity);
                    if(integerCapacity == 0){
                        errormessage += "Capacity should minimum 1\n";
                    }
                }


                if (phone.length() < 11){
                    errormessage += "Invalid Type\n";

                }
                if (description.length() < 10){
                    errormessage += "Description is not Valid\n";

                }
                if (errormessage.length() == 0){
                    showDialog("Do you want to save this event info?", "info", "Yes","No");
                }
                else{
                    showDialog(errormessage, "Error", "Ok", "Back");
                }
            }
        });

        capacity.setText("Capacity22222");
        capacity.getText().toString();

    }

    private void showDialog(String message, String title, String btn01, String btn02){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);

        builder.setCancelable(false).setPositiveButton(btn01, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                System.out.println("Button was clicked");
                //Util.getInstance().deleteByKey(MainActivity.this, key);
                dialog.cancel();
                //loaddata();
                //adapter.notifydataSetChanged();
                //lvEvents.notifyAll();
            }
        }).setNegativeButton(btn02, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        //alert.setTitle("Error Dialog");
        alert.show();
    }
}