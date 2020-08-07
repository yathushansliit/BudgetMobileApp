package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventCardView extends AppCompatActivity implements View.OnClickListener{

    private CardView cardView01,cardView02,cardView03,cardView04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_card_view);

        //Defining
        cardView01 = (CardView) findViewById(R.id.BirthdayCard);
        cardView02 = (CardView) findViewById(R.id.ReunionCard);
        cardView03 = (CardView) findViewById(R.id.FarewellCard);
        cardView04 = (CardView) findViewById(R.id.otherCard);

        //Add Click Listner
        cardView01.setOnClickListener(this);
        cardView02.setOnClickListener(this);
        cardView03.setOnClickListener(this);
        cardView04.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            case R.id.BirthdayCard:
                intent = new Intent(this, EventBirthday.class);
                startActivity(intent);
                break;
            case R.id.ReunionCard:
                intent = new Intent(this, EventReunion.class);
                startActivity(intent);
                break;
            case R.id.FarewellCard:
                intent = new Intent(this, EventFarewell.class);
                startActivity(intent);
                break;
            case R.id.otherCard:
                intent = new Intent(this, EventOther.class);
                startActivity(intent);
                break;
            default:
                break;

        }
        }
}