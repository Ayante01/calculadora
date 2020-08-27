package cr.ac.ucr.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textSpace;
    private TextView textResult;
    private String text;
    private String secondText;
    private String resultText;
    private String constantNumber = "";
    private int firstNumber = 0;
    private int secondNumber= 0;
    private String action = "sinAccion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSpace = findViewById(R.id.btn_text_space);
        textResult = findViewById(R.id.btn_text_result);
        text = "";
        constantNumber = "";
        secondText = "";
        resultText = "";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cero:
                if(verificar("0") != true){
                    changeString("0");
                }
                break;
            case R.id.btn_uno:
                if(verificar("1") != true){
                    changeString("1");
                }
                break;
            case R.id.btn_dos:
                if(verificar("2") != true){
                    changeString("2");
                }
                break;
            case R.id.btn_tres:
                if(verificar("3") != true){
                    changeString("3");
                }
                break;
            case R.id.btn_cuatro:
                if(verificar("4") != true){
                    changeString("4");
                }
                break;
            case R.id.btn_cinco:
                if(verificar("5") != true){
                    changeString("5");
                }
                break;
            case R.id.btn_seis:
                if(verificar("6") != true){
                    changeString("6");
                }
                break;
            case R.id.btn_siete:
                if(verificar("7") != true){
                    changeString("7");
                }
                break;
            case R.id.btn_ocho:
                if(verificar("8") != true){
                    changeString("8");
                }
                break;
            case R.id.btn_nueve:
                if(verificar("9") != true){
                    changeString("9");
                }
                break;
            case R.id.btn_reiniciar:
                clear();
                break;
            case R.id.btn_sumar:
                if(!text.equals("")){
                    changeString("+");
                    if(constantNumber.equals("")){
                        constantNumber = text;
                    }else{
                        constantNumber = resultText;
                    }
                    if(action.equals("multiplicacion") || action.equals("division") ){
                        constantNumber = resultText;
                        resultText = "";
                        textResult.setHint(resultText);
                        text = constantNumber+"+";
                        textSpace.setHint(text);
                    }
                    action = "suma";
                    secondText = "";
                }
                break;
            case R.id.btn_restar:
                if(!text.equals("")){
                    changeString("-");
                    if(constantNumber.equals("")){
                        constantNumber = text;
                    }else{
                        constantNumber = resultText;
                    }
                    if(action.equals("multiplicacion") || action.equals("division") ){
                        constantNumber = resultText;
                        resultText = "";
                        textResult.setHint(resultText);
                        text = constantNumber+"-";
                        textSpace.setHint(text);
                    }
                    action = "resta";
                    secondText = "";
                }
                break;
            case R.id.btn_multiplicar:
                if(!text.equals("")){
                    changeString("*");
                    if(constantNumber.equals("")){
                        constantNumber = text;
                    }else{
                        constantNumber = resultText;
                        resultText = "";
                        textResult.setHint(resultText);
                        text = constantNumber+"*";
                        textSpace.setHint(text);
                    }
                    action = "multiplicacion";
                    secondText = "";
                }
                break;
            case R.id.btn_dividir:
                if(!text.equals("")){
                    changeString("/");
                    if(constantNumber.equals("")){
                        constantNumber = text;
                    }else{
                        constantNumber = resultText;
                        resultText = "";
                        textResult.setHint(resultText);
                        text = constantNumber+"/";
                        textSpace.setHint(text);
                    }
                    action = "division";
                    secondText = "";
                }
                break;
            case R.id.btn_resultado:
                text = resultText;
                textSpace.setHint(text);
                resultText = "";
                textResult.setHint(resultText);
                action = "sinAccion";
                secondText = "";
                constantNumber = "";
                firstNumber = 0;
                secondNumber = 0;
                break;
            default:
                break;
        }
    }

    private boolean verificar(String n){
        if(action.equals("suma")){
            sumar(n);
            return true;
        }
        if(action.equals("resta")){
            restar(n);
            return true;
        }
        if(action.equals("multiplicacion")){
            multiplicar(n);
            return true;
        }
        if(action.equals("division")){
            dividir(n);
            return true;
        }
        return false;
    }
    private void  sumar(String n){
        secondText = secondText + n;
        secondNumber = Integer.parseInt(secondText);
        String[] array = constantNumber.split("");
        String c = "";
        for(int i=0; i<array.length;i++){
            if(!array[i].equals("+")) {
                c = c + array[i];
            }
        }
        firstNumber = Integer.parseInt(c);
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        resultText = Integer.toString(firstNumber + secondNumber);
        textResult.setHint(resultText);
        changeString(n);
        textSpace.setHint(text);
    }

    private void  multiplicar(String n){
        secondText = secondText + n;
        secondNumber = Integer.parseInt(secondText);
        String[] array = constantNumber.split("");
        String c = "";
        for(int i=0; i<array.length;i++){
            if(!array[i].equals("*")) {
                c = c + array[i];
            }
        }
        firstNumber = Integer.parseInt(c);
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        resultText = Integer.toString(firstNumber * secondNumber);
        textResult.setHint(resultText);
        changeString(n);
        textSpace.setHint(text);
    }

    private void  dividir(String n){
        secondText = secondText + n;
        secondNumber = Integer.parseInt(secondText);
        String[] array = constantNumber.split("");

        String c = "";
        for(int i=0; i<array.length;i++){
            if(!array[i].equals("/")) {
                c = c + array[i];
            }
        }
        firstNumber = Integer.parseInt(c);
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        resultText = Integer.toString(firstNumber / secondNumber);
        textResult.setHint(resultText);
        changeString(n);
        textSpace.setHint(text);
    }

    private void  restar(String n){
        secondText = secondText + n;
        secondNumber = Integer.parseInt(secondText);

        String[] array = constantNumber.split("");

        String c = "";
        for(int i=0; i<array.length;i++){
            if(!array[i].equals("-")) {
                c = c + array[i];
            }
        }
        firstNumber = Integer.parseInt(c);
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        resultText = Integer.toString(firstNumber - secondNumber);
        textResult.setHint(resultText);
        changeString(n);
        textSpace.setHint(text);
    }

    private void clear() {
        text = "";
        action = "sinAccion";
        secondText = "";
        constantNumber = "";
        firstNumber = 0;
        secondNumber = 0;
        textSpace.setHint(text);
        resultText = "";
        textResult.setHint(resultText);
    }

    private void changeString(String i) {
        String[] array = text.split("");
        if(array[array.length - 1].equals("+") & i.equals("+") ||
                (array[array.length - 1].equals("+") & i.equals("-")) ||
                (array[array.length - 1].equals("+") & i.equals("*")) ||
                (array[array.length - 1].equals("+") & i.equals("/")) ||
                (array[array.length - 1].equals("-") & i.equals("+")) ||
                (array[array.length - 1].equals("-") & i.equals("-")) ||
                (array[array.length - 1].equals("-") & i.equals("*")) ||
                (array[array.length - 1].equals("-") & i.equals("/")) ||
                (array[array.length - 1].equals("*") & i.equals("+")) ||
                (array[array.length - 1].equals("*") & i.equals("-")) ||
                (array[array.length - 1].equals("*") & i.equals("*")) ||
                (array[array.length - 1].equals("*") & i.equals("/")) ||
                (array[array.length - 1].equals("/") & i.equals("+")) ||
                (array[array.length - 1].equals("/") & i.equals("-")) ||
                (array[array.length - 1].equals("/") & i.equals("*")) ||
                (array[array.length - 1].equals("/") & i.equals("/"))) {
            textSpace.setHint(text);
        }else {
            text = text + i;
            textSpace.setHint(text);
        }
    }
}