package com.example.calculadorapdm20202;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String VALUE_TV_RESULT = "VALOR_TV_RESULT";
    private final String VALUE_TV_VISOR = "VALOR_TV_VISOR";
    private TextView valueTextView, valueVisor;
    private StringBuilder digitScreen = new StringBuilder();
    private StringBuilder digitScreenAll = new StringBuilder();
    private char operation = 'a';
    private Double value1=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(getString(R.string.app_name), "onCreate executado - iniciando");
        setContentView(R.layout.activity_main);
        valueTextView = findViewById(R.id.resultado_tv);
        valueVisor = findViewById(R.id.visor_tv);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(getString(R.string.app_name), "onSaveInstanceState executado - salvando ai ai");
        outState.putString(VALUE_TV_RESULT, valueTextView.getText().toString());
        outState.putString(VALUE_TV_VISOR, valueVisor.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(getString(R.string.app_name), "onRestoreInstanceState executado - restaurando ai ai");
        valueTextView.setText(savedInstanceState.getString(VALUE_TV_RESULT, "0"));
        valueVisor.setText(savedInstanceState.getString(VALUE_TV_VISOR, ""));

    }

    protected void onStart() {
        super.onStart();
        Log.v(getString(R.string.app_name), "onStart executado - ciclo visivel");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getString(R.string.app_name), "onResume executado - ciclo primeiro plano");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getString(R.string.app_name), "onPause executado - ciclo primeiro plano parado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getString(R.string.app_name), "onStop executado - ciclo parado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getString(R.string.app_name), "onDestroy executado - ciclo encerrado");
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
                digitScreen.setLength(0);
                digitScreenAll.setLength(0);
                setTextViewInEmpty();
                value1 =  0.0;
                break;
            case R.id.multi_bt:
                if (digitScreen.length() > 0) {
                    selectOperation('*');
                    digitScreenAll.append('*');
                }
                break;
            case R.id.divide_bt:
                if (digitScreen.length() > 0) {
                    selectOperation('/');
                    digitScreenAll.append('/');
                }
                break;
            case R.id.menos_bt:
                if(digitScreen.length() == 0){
                    digitScreen.append("-");
                    }else{
                        selectOperation('-');
                    }
                    digitScreenAll.append('-');
                break;
            case R.id.mais_bt:
                if (digitScreen.length() > 0) {
                    selectOperation('+');
                    digitScreenAll.append('+');
                }
                break;
            case R.id.ponto_bt:
                if (digitScreen.length() > 0){
                    if (digitScreen.indexOf(".") == -1){
                        digitScreen.append('.');
                        digitScreenAll.append('.');
                    }
                }
                break;
            case R.id.modulo_bt:
                if (digitScreen.length() > 0) {
                    selectOperation('%');
                    digitScreenAll.append('/');
                }
                break;
            case R.id.backspace_bt:
                clearDigit();
                break;
            case R.id.igual_bt:
                if (value1 != 0.0 && operation != 'a'){
                    performMathOp();
                }
                break;
            default:
                Toast.makeText(this, "Sinto muito, esse app falhou", Toast.LENGTH_SHORT).show();
        }
        valueTextView.setText(digitScreen);
        valueVisor.setText(digitScreenAll);
    }

    private void deleteStringBuilder(int start, int end, StringBuilder str){
        str.delete(start, end);
    }

    private void performMathOp() {
            Double value2 = Double.parseDouble(String.valueOf(valueTextView.getText()));
            double result = 0.0;
            digitScreenAll.setLength(0);
            digitScreen.setLength(0);
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
            valueVisor.setText(digitScreenAll);
    }

    private void clearDigit() {
        if (digitScreen.length() > 1){
            deleteStringBuilder(digitScreen.length()-1, digitScreen.length(), digitScreen) ;
            deleteStringBuilder(digitScreenAll.length()-1, digitScreenAll.length(), digitScreenAll) ;
        }
        else if(digitScreen.length() == 1){
            deleteStringBuilder(0, digitScreen.length(), digitScreen);
            deleteStringBuilder(0, digitScreenAll.length(), digitScreenAll);
            digitScreen.append("");
            digitScreenAll.append("");
        }
        setTextViewInEmpty();
        valueTextView.setText(digitScreen);
        valueVisor.setText(digitScreenAll);
    }

    private void setTextViewInEmpty(){
        valueVisor.setText("");
        valueTextView.setText("");
    }

    private void selectOperation(char c){
        operation = c;
        if (valueTextView.toString().equals("")){
            Toast.makeText(this, "Você não digitou nenhum número", Toast.LENGTH_SHORT).show();
        }
        else{
           try {
               value1 = Double.parseDouble(String.valueOf(valueTextView.getText()));
               value1 = Double.parseDouble(String.valueOf(valueTextView.getText()));
               digitScreen.delete(0, digitScreen.length());
               valueTextView.setText(digitScreen);
           }catch (NumberFormatException e){
               Toast.makeText(this, "Você não digitou um número válido", Toast.LENGTH_SHORT).show();
           }
        }
    }
 }

