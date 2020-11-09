package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView valueTextView;
    private Double value1=0.0;
    private Double value2=0.0;
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

            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
    }
    private void separeteString(String textView, String operador){
        if (verificaLen(textView)){
            String[] separador = textView.split(operador);
            value1= Double.valueOf(String.valueOf(Double.parseDouble(separador[0])));
        }

    }

    private boolean verificaLen(String textView){
        return textView.length() > 1;
    }

    private boolean verificaValue(){
        return value1 != 0.0;
    }

 }

