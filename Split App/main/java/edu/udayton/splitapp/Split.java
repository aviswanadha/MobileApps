package edu.udayton.splitapp;

import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.security.acl.Group;
import java.text.DecimalFormat;

public class Split extends AppCompatActivity {

    private int totalBillAmt;
    private int numberOfPersons;
    private String groupChoice;
    private double costPerHead;
    private double tip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.split);


        final Button btnCost = (Button)findViewById(R.id.btncost);

        assert btnCost != null;
        View.OnClickListener costListner = new View.OnClickListener() {

            final EditText billAmt = (EditText)findViewById(R.id.txtBill);
            Spinner group = (Spinner)findViewById(R.id.txtGroup);
            final EditText noOfPpl = (EditText)findViewById(R.id.txtNumber);
            final TextView result = (TextView)findViewById(R.id.txtResult);


            @Override
            public void onClick(View v) {
                Editable input = billAmt.getText();
                Editable input1 = noOfPpl.getText();
                String InputStr = input.toString();
                String InputStr1 = input1.toString();


                try{
                    totalBillAmt = Integer.parseInt(InputStr);
                    numberOfPersons = Integer.parseInt(InputStr1);
                    groupChoice = group.getSelectedItem().toString();
                    DecimalFormat currency = new DecimalFormat("$###,###.##");

                    if(groupChoice.equals("Excellant Service"))
                    {
                        tip = 0.2*totalBillAmt;
                        costPerHead = (tip + totalBillAmt)/ numberOfPersons;
                        String output = "Cost per head " + "is" + currency.format(costPerHead) + "\n\n" + "One of the best meals ever!  I will recommend this place to everyone I know!";
                        result.setText(output);

                    } else
                        if(groupChoice.equals("Average Service"))
                        {
                            tip = 0.15*totalBillAmt;
                            costPerHead = (tip + totalBillAmt)/ numberOfPersons;
                            String output = "Cost per head" + groupChoice + "is" + currency.format(costPerHead) + "\n\n" + "Everything was OK.";
                            result.setText(output);
                        } else
                            if(groupChoice.equals("Poor Service"))
                            {
                                tip = 0.05*totalBillAmt;
                                costPerHead = (tip + totalBillAmt)/ numberOfPersons;
                                String output = "Cost per head" + "" + groupChoice + "" + "is" + "" + currency.format(costPerHead) + "\n\n" + "Awful!  The worst!  I can't wait to give negative reviews on Yelp!";
                                result.setText(output);
                            }


                } catch (Exception e){
                    Log.e(e.getMessage(), e.toString());
                }
            }
        };

        btnCost.setOnClickListener(costListner);
    } //end onCreate Method
} // end MainActivity class
