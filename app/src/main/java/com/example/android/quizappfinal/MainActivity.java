package com.example.android.quizappfinal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int q1Answer= R.id.question_1_radio3;
    int q2Answer= R.id.question_2_radio1;
    String q4Answer= "network";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view){
        int numberOfCorrectAnswers = 0;
        ArrayList<String> wrongAnswers = new ArrayList<String> ();
        if(checkQuestion1()){
            numberOfCorrectAnswers++;}
        else{
            wrongAnswers.add("q1");}
        if(checkQuestion2()){
            numberOfCorrectAnswers++;}
        else{
            wrongAnswers.add("q2");}
        if(checkQuestion3()){
            numberOfCorrectAnswers++;}
        else{
            wrongAnswers.add("q3");}
        if(checkQuestion4()){
            numberOfCorrectAnswers++;}
        else{
            wrongAnswers.add("q4");}

        StringBuilder sb = new StringBuilder();
        for (String s : wrongAnswers)
        {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfCorrectAnswers + "/4 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    private boolean checkQuestion1() {
        RadioGroup radioGroup1 =(RadioGroup) findViewById(R.id.question_1_radio);

        if (radioGroup1.getCheckedRadioButtonId() == q1Answer){
            return true;}
        return false;
    }

    private boolean checkQuestion2() {
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question_2_radio);

        if( radioGroup2.getCheckedRadioButtonId() == q2Answer ) {
            return true;
        }
       return false;
    }

    private boolean checkQuestion3() {
        CheckBox checkBox1 =(CheckBox) findViewById(R.id.question_3_checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question_3_checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question_3_checkBox3);

        if(checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()) {
            return true;
        }
        else return false;
    }

    private boolean checkQuestion4() {
        EditText q4 = (EditText) findViewById(R.id.question4Answer);

        return q4.getText().toString().equalsIgnoreCase(q4Answer);

    }
}
