package com.chavan.ranjit.cars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CarsInfo extends AppCompatActivity {
    TextView carname,price;
    ImageView img;
    EditText desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_info);
        Intent i=getIntent();
        String SelectedItem=i.getExtras().getString("keys");
        carname=(TextView)findViewById(R.id.cars_name);
        price=(TextView)findViewById(R.id.price);
        img=(ImageView)findViewById(R.id.imageView2);
        desc=(EditText)findViewById(R.id.editText);
        String value;
        if(SelectedItem.equals("Audi R8")){
        value="Thrilling performance and a Breathtaking handling experience, the second generation all-new R8 has arrived. Redesigned from the ground up, no model bearing the four Audi rings comes closer to giving you the adrenalin rush of the track in a series production vehicle. With Motorsport in its genes we have taken the R8 V10 plus to a whole new level.\n";
        carname.setText(carname.getText().toString()+"  \tAudi R8");
        price.setText(price.getText().toString()+"  \t$25Million");
        img.setImageResource(R.drawable.audi);
        desc.setText(desc.getText().toString()+" "+value);

        }else if(SelectedItem.equals("Tesla")){

            carname.setText(carname.getText().toString()+"  \tTesla x");
            price.setText(price.getText().toString()+" \t $4Million");
            img.setImageResource(R.drawable.tesla);
            value="Model X is the safest, quickest, and most capable sport utility vehicle in history. Designed as a family car without compromise, Model X comes standard with all-wheel drive, ample seating for up to seven adults, standard active safety features, and up to 295 miles of range on a single charge. And it's the quickest SUV in production, capable of accelerating from zero to 60 miles per hour in 2.9 seconds.";
            desc.setText(desc.getText().toString()+" "+value);

        }else if(SelectedItem.equals("Rolls Royce")){
            carname.setText(carname.getText().toString()+" \tRolls Royce");
            price.setText(price.getText().toString()+"  \t$60Million");
            img.setImageResource(R.drawable.rolls);
            value="There are those who measure success not just in material wealth, but in richness of experience and appreciation of beauty. For these few, Ghost’s dramatic elegance and purity of design represents one of life’s finest rewards.";
            desc.setText(desc.getText().toString()+" "+value);
        }else if(SelectedItem.equals("Land Rover")){
            carname.setText(carname.getText().toString()+"  \tLand Rover");
            price.setText(price.getText().toString()+"  \t$2Million");
            img.setImageResource(R.drawable.landrover);
            value="InControl Touch Pro is Land Rover’s next-generation infotainment system that advances Range Rover’s connectivity and entertainment to the very highest level. Find a parking space, stream your favourite music and even track a stolen vehicle - InControl can make your life easier.";
            desc.setText(desc.getText().toString()+" "+value);

        }else{

            carname.setText(carname.getText().toString()+"  \tJaguar");
            price.setText(price.getText().toString()+" \t $0.5Million");
            img.setImageResource(R.drawable.jaguar);
            value="XE immediately catches the eye - standing out from the competition with the great proportions and clean surfaces that form the core of Jaguar design.";
            desc.setText(desc.getText().toString()+" "+value);
        }
            desc.setEnabled(false);

    }
}
