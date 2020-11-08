package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView valueTextView;
    private Double resultFinal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueTextView = findViewById(R.id.resultado_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zero_bt:
                valueTextView.setText(String.format("%s0", valueTextView.getText()));
                break;
            case R.id.um_bt:
                valueTextView.setText(String.format("%s1", valueTextView.getText()));
                break;
            case R.id.dois_bt:
                valueTextView.setText(String.format("%s2", valueTextView.getText()));
                break;
            case R.id.tres_bt:
                valueTextView.setText(String.format("%s3", valueTextView.getText()));
                break;
            case R.id.quatro_bt:
                valueTextView.setText(String.format("%s4", valueTextView.getText()));
                break;
            case R.id.cinco_bt:
                valueTextView.setText(String.format("%s5", valueTextView.getText()));
                break;
            case R.id.seis_bt:
                valueTextView.setText(String.format("%s6", valueTextView.getText()));
                break;
            case R.id.sete_bt:
                valueTextView.setText(String.format("%s7", valueTextView.getText()));
                break;
            case R.id.oito_bt:
                valueTextView.setText(String.format("%s8", valueTextView.getText()));
                break;
            case R.id.nove_bt:
                valueTextView.setText(String.format("%s9", valueTextView.getText()));
                break;
            case R.id.limpar_bt:
                valueTextView.setText("");
                break;
            case R.id.multi_bt:
                valueTextView.setText(String.format("%s*", valueTextView.getText()));
                break;
            case R.id.dividi_bt:
                valueTextView.setText(String.format("%s/", valueTextView.getText()));
                break;
            case R.id.menos_bt:
                valueTextView.setText(String.format("%s-", valueTextView.getText()));
                break;
            case R.id.mais_bt:
                valueTextView.setText(String.format("%s+", valueTextView.getText()));
                break;

            case R.id.igual_bt:
                separateString((valueTextView.getText().toString()));
                break;

            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
    }

    private List separateString(String s){
        char[] str = s.toCharArray();
        ArrayList<String> listString = new ArrayList<>();
        String string = "";
        int contInicial=0;
        int contFinal=0;
        for (char i : str) {
            if (i == '*') {
                for (int z = contInicial; z < contFinal; z++) {
                    string += i;
                }
                listString.add(string);
                listString.add("*");
                System.out.println(string);
                contInicial = contFinal + 1;
                string="";
            }

            if (i == '/') {
                for (int z = contInicial; z < contFinal; z++) {
                    string += i;
                }
                listString.add(string);
                listString.add("/");
                System.out.println(string);
                contInicial = contFinal + 1;
                string="";
            }
            if (i == '+') {
                for (int z = contInicial; z < contFinal; z++) {
                    string += i;
                }
                listString.add(string);
                listString.add("+");
                System.out.println(string);
                contInicial = contFinal + 1;
                string="";
            }
            if (i == '-') {
                for (int z = contInicial; z < contFinal; z++) {
                    string += i;
                }
                listString.add(string);
                listString.add("-");
                System.out.println(string);
                contInicial = contFinal + 1;
                string="";
            }
            contFinal++;
        }
        return listString;
    }
 }

