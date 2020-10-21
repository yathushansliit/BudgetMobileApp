package com.example.budgetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity implements View.OnClickListener {

      private CardView cardView01,cardView02,cardView03,cardView04,cardView05,cardView06,cardView07,cardView08;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Defining
        cardView01 = (CardView) findViewById(R.id.individualCard);
        cardView02 = (CardView) findViewById(R.id.familyCard);
        cardView03 = (CardView) findViewById(R.id.ExpensesCard);
        cardView04 = (CardView) findViewById(R.id.incomeCard);
        cardView05 = (CardView) findViewById(R.id.LogoutCard);
        cardView06 = (CardView) findViewById(R.id.eventCard);
        cardView07 = (CardView) findViewById(R.id.BudgetHistoryCard);
        cardView08 = (CardView) findViewById(R.id.reminderCard);

        //Add Click Listner
        cardView01.setOnClickListener(this);
        cardView02.setOnClickListener(this);
        cardView03.setOnClickListener(this);
        cardView04.setOnClickListener(this);
        cardView05.setOnClickListener(this);
        cardView06.setOnClickListener(this);
        cardView07.setOnClickListener(this);
        cardView08.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){

            case R.id.individualCard:
                    intent = new Intent(this,Individual1.class);
                    startActivity(intent);
                    break;
            case R.id.familyCard: intent = new Intent(this,Family.class); startActivity(intent); break;
            case R.id.ExpensesCard: intent = new Intent(this,Expenses.class); startActivity(intent);  break;
            case R.id.incomeCard: intent = new Intent(this,Income.class); startActivity(intent); break;
            case R.id.LogoutCard: SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("remember","False");editor.apply();finish();break;
            case R.id.eventCard: intent = new Intent(this,EventCardView.class); startActivity(intent); break;
            case R.id.BudgetHistoryCard: intent = new Intent(this, BudgetHistory.class); startActivity(intent); break;
            case R.id.reminderCard: intent = new Intent(this,AlarmMainActivity.class); startActivity(intent); break;
            default: break;

        }












    }
}