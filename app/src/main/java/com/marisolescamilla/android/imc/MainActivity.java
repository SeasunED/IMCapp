package com.marisolescamilla.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso;
    private EditText mCampoEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mImcTextView;
    private TextView mEstadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoPeso = findViewById(R.id.campo_peso);
        mCampoEstatura = findViewById(R.id.campo_estatura);
        mBotonCalcular = findViewById(R.id.boton_calcular);
        mEstadoTextView = findViewById(R.id.estado_nutricional);
        
        mBotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mCampoPeso.getText().toString();//Devuelve objeto editable
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / Math.pow(estatura,2);
                mImcTextView.setText(Double.toHexString(imc));

                if(imc<18.5){
                    mEstadoTextView.setText("Peso bajo");
                }

                if(imc>18.5 && imc<24.99){
                    mEstadoTextView.setText("Peso normal");
                }

                if(imc>25.0 && imc<29.99){
                    mEstadoTextView.setText("Sobrepeso");
                }

                if(imc>30.0 && imc<39.99){
                    mEstadoTextView.setText("Obesidad");
                }

                if(imc>40.0){
                    mEstadoTextView.setText("Obesidad extrema");
                }

            }
        });

        mBotonLimpiar = findViewById(R.id.boton_limpiar);
        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mImcTextView.setText("");
                mEstadoTextView.setText("");
            }
        });
        mImcTextView = findViewById(R.id.imc_text_view);
    }
}
