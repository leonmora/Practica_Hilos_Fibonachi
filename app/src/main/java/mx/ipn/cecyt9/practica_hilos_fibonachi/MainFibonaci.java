package mx.ipn.cecyt9.practica_hilos_fibonachi;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;

public class MainFibonaci extends Activity {

    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fibonaci);
        entrada = (EditText) findViewById(R.id.Numero);
        salida = (TextView) findViewById(R.id.Imprimir);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
        FactorialH rs = new FactorialH(n);
        rs.run();
    }
    public void calcularOperacion2(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "f = ");
        FibonacciH rs = new FibonacciH(n);
        rs.run();
    }

    public int factorial(int n) {
        int res = 1;
        int aux = 100 / n;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }

        return res;

    }

    class FactorialH extends Thread {
        private int n, res;

        public FactorialH(int n) {

            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            salida.append(res + "\n");
        }
    }

    class FibonacciH extends Thread {
        private int n, res;

        public FibonacciH(int n) {
            this.n = n;
        }


        @Override
        public void run() {
            res = fibonacci(n);
            salida.append(res + "\n");
        }
    }


    public int fibonacci(int n){
        int res = 0;
        int aux = 100 / n;
        if(n == 0){
            res = 0;
        }else
            for (int i = 0; i < n; i++) {
                res += AuxiliarFibonacci(i);
            }
        return res;
    }

    public int AuxiliarFibonacci(int n)
    {
        if (n>1){
            return AuxiliarFibonacci(n-1) + AuxiliarFibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }
}
