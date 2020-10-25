package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.resultado_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zero_bt:
                result.setText(String.format("%s0", result.getText()));
                break;
            case R.id.um_bt:
                result.setText(String.format("%s1", result.getText()));
                break;
            case R.id.dois_bt:
                result.setText(String.format("%s2", result.getText()));
                break;
            case R.id.tres_bt:
                result.setText(String.format("%s3", result.getText()));
                break;
            case R.id.quatro_bt:
                result.setText(String.format("%s4", result.getText()));
                break;
            case R.id.cinco_bt:
                result.setText(String.format("%s5", result.getText()));
                break;
            case R.id.seis_bt:
                result.setText(String.format("%s6", result.getText()));
                break;
            case R.id.sete_bt:
                result.setText(String.format("%s7", result.getText()));
                break;
            case R.id.oito_bt:
                result.setText(String.format("%s8", result.getText()));
                break;
            case R.id.nove_bt:
                result.setText(String.format("%s9", result.getText()));
                break;
            case R.id.limpar_bt:
                result.setText("");
                break;
            /*case R.id.multi_bt:
                resultado.setText(resultado.getText() + "*");
                break;
            case R.id.dividi_bt:
                resultado.setText(resultado.getText() + "/");
                break;
            case R.id.menos_bt:
                resultado.setText(resultado.getText() + "-");
                break;
            case R.id.mais_bt:
                resultado.setText(resultado.getText() + "+");
                break;

            case R.id.igual_bt:
                resultado.setText(resultado.getText() + "=");
                break;*/

            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
    }
}