package edu.udayton.travelapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class travel extends AppCompatActivity {

    private final double ARIZONACOST = 180;
    private final double CALICOST = 20;
    private final double DCCOST = 49;
    private final double FLORIDACOST = 38;
    private final double HAWAIICOST = 130;
    private final double KENTUCKYCOST = 36;
    private final double MISSISSIPPICOST = 10;
    private final double NEVADACOST = 137;
    private final double NYCOST = 37;
    private final double OREGONCOST = 60;
    private final double TEXASCOST = 38;
    private final double WASHINGTONCOST = 38;

    private int numberOfTickets;
    private double totalCost;
    private String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        final Button btnCost = (Button)findViewById(R.id.btnCost);

        Button btnExplore1 = (Button)findViewById(R.id.btnExplore);

        btnExplore1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://time.com/money/5186719/travel-tourist-attraction-every-state/"));
                startActivity(viewIntent);
            }
        });


        assert btnCost != null;

        View.OnClickListener costListener = new View.OnClickListener() {

            final EditText tickets = (EditText)findViewById(R.id.txtTickets);
            final Spinner group = (Spinner)findViewById(R.id.txtGroup);
            final TextView result = (TextView)findViewById(R.id.txtResult);

            @Override
            public void onClick(View v) {

                Editable Input = tickets.getText();
                String InputStr = Input.toString();

                try {

                    numberOfTickets = Integer.parseInt(InputStr);

                    totalCost = CALICOST*numberOfTickets;

                    groupChoice = group.getSelectedItem().toString();

                    DecimalFormat currency = new DecimalFormat("$###,###.##");

                    if(groupChoice.equals("Arizona"))
                    {

                        totalCost = ARIZONACOST*numberOfTickets;
                        String Output = "Estimated cost for " + groupChoice + "is" + currency.format(totalCost) + "\n\n";
                        result.setText(Output);

                    } else
                    if(groupChoice.equals("California"))
                    {
                        totalCost = CALICOST*numberOfTickets;
                        String Output = "Estimated cost for " + groupChoice + "is" + currency.format(totalCost) + "\n\n";
                        result.setText(Output);

                    } else
                    if(groupChoice.equals("Washington D.C."))
                    {
                        totalCost = DCCOST*numberOfTickets;
                        String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                        result.setText(Output);
                    } else
                    if(groupChoice.equals("Florida"))
                    {
                        totalCost = FLORIDACOST*numberOfTickets;
                        String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                        result.setText(Output);
                    } else
                        if(groupChoice.equals("Hawaii"))
                    {
                        totalCost = HAWAIICOST*numberOfTickets;
                        String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                        result.setText(Output);
                    } else
                        if(groupChoice.equals("Kentucky"))
                        {
                            totalCost = KENTUCKYCOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        } else
                        if(groupChoice.equals("Mississippi"))
                        {
                            totalCost = MISSISSIPPICOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        } else
                        if(groupChoice.equals("Nevada"))
                        {
                            totalCost = NEVADACOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        } else
                        if(groupChoice.equals("New York"))
                        {
                            totalCost = NYCOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        }else
                        if(groupChoice.equals("Oregon"))
                        {
                            totalCost = OREGONCOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        } else
                        if(groupChoice.equals("Texas"))
                        {
                            totalCost = TEXASCOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        } else
                        if(groupChoice.equals("Washington"))
                        {
                            totalCost = WASHINGTONCOST*numberOfTickets;
                            String Output = "Estimated cost for " + groupChoice + " " + " is" + " " + currency.format(totalCost) + "\n\n";
                            result.setText(Output);
                        }
                }catch (Exception e){
                    Log.e(e.getMessage(), e.toString());
                }


            }
        };

        btnCost.setOnClickListener(costListener);



        }
}
