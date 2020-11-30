package com.example.calculadorapdm20202;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView valueTextView, valueVisor;
    private StringBuilder digitScreen = new StringBuilder();
    private StringBuilder digitScreenAll = new StringBuilder();
    private char operation;
    private Double value1=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueTextView = findViewById(R.id.resultado_tv);
        valueVisor = findViewById(R.id.visor_tv);
    }

    @Override
    public void onClick(View v) {
        System.out.println(digitScreen);
        switch (v.getId()) {
            case R.id.zero_bt:
                digitScreen.append("0");
                digitScreenAll.append("0");
                break;
            case R.id.um_bt:
                digitScreen.append("1");
                digitScreenAll.append("1");
                break;
            case R.id.dois_bt:
                digitScreen.append("2");
                digitScreenAll.append("2");
                break;
            case R.id.tres_bt:
                digitScreen.append("3");
                digitScreenAll.append("3");
                break;
            case R.id.quatro_bt:
                digitScreen.append("4");
                digitScreenAll.append("4");
                break;
            case R.id.cinco_bt:
                digitScreen.append("5");
                digitScreenAll.append("5");
                break;
            case R.id.seis_bt:
                digitScreen.append("6");
                digitScreenAll.append("6");
                break;
            case R.id.sete_bt:
                digitScreen.append("7");
                digitScreenAll.append("7");
                break;
            case R.id.oito_bt:
                digitScreen.append("8");
                digitScreenAll.append("8");
                break;
            case R.id.nove_bt:
                digitScreen.append("9");
                digitScreenAll.append("9");
                break;
            case R.id.limpar_bt:
                digitScreen.delete(0, digitScreen.length());
                digitScreenAll.delete(0, digitScreenAll.length());
                valueTextView.setText("");
                valueVisor.setText("");
                value1 =  0.0;
                break;
            case R.id.multi_bt:
                selectOperation('*');
                digitScreenAll.append('*');
                break;
            case R.id.divide_bt:
                selectOperation('/');
                digitScreenAll.append('/');
                break;
            case R.id.menos_bt:
                selectOperation('-');
                digitScreenAll.append('-');
                break;
            case R.id.mais_bt:
                selectOperation('+');
                digitScreenAll.append('+');
                break;
            case R.id.ponto_bt:
                digitScreen.append('.');
                digitScreenAll.append('.');
                break;
            case R.id.modulo_bt:
                selectOperation('%');
                digitScreenAll.append('/');
                break;
            case R.id.backspace_bt:
                clearDigit();
                break;
            case R.id.igual_bt:
                digitScreen.delete(0, digitScreen.length());
                digitScreenAll.delete(0, digitScreenAll.length());
                performMathOp();
                break;
            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
        valueTextView.setText(digitScreen);
        valueVisor.setText(digitScreenAll);
    }

    private void performMathOp() {
        Double value2 = Double.parseDouble(String.valueOf(valueTextView.getText()));
        double result = 0.0;
        switch (operation){
            case '+':
                result = value1 + value2;
                break;
            case '-':
                result = value1 - value2;
                break;
            case '*':
                result = value1 * value2;
                break;
            case '/':
                 result = value1 / value2;
                break;
            case '%':
                result = value1 % value2;
                break;
            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
        digitScreen.append(result);
        digitScreenAll.append(result);
        valueTextView.setText(digitScreen);
        valueVisor.setText("");
        valueVisor.setText(digitScreenAll);
    }

    private void clearDigit() {
        if (digitScreen.length() > 1){
            digitScreen.delete(digitScreen.length()-1, digitScreen.length()) ;
            digitScreenAll.delete(digitScreen.length()-1, digitScreen.length()) ;
        }
        else if(digitScreen.length() == 1){
            digitScreen.delete(0, digitScreen.length()) ;
            digitScreenAll.delete(0, digitScreen.length());
            digitScreen.append("0");
            digitScreenAll.append("");
        }
        valueTextView.setText("");
        valueVisor.setText("");
        valueTextView.setText(digitScreen);
        valueVisor.setText(digitScreenAll);
    }

    private void selectOperation(char c){
        operation = c;
        value1 = Double.parseDouble(String.valueOf(valueTextView.getText()));
        digitScreen.delete(0, digitScreen.length());
        valueTextView.setText(digitScreen);
    }


 }

