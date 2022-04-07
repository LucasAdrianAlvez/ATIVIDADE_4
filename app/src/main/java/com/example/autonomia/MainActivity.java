package com.example.autonomia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends DebugActivity {
    private EditText km;
    private EditText combustivel;
    private EditText autonomia;
    private TextView tv;
    private Button bt;
   public String name;
    public String resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        km = (EditText) findViewById(R.id.km);
        combustivel = (EditText) findViewById(R.id.combustivel);
        autonomia = (EditText) findViewById(R.id.autonomia);
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);

        if(savedInstanceState!=null){
            name = savedInstanceState.getString("chaveNome");
        }else{
            name = null;
        }
        tv.setText(name);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String km0 = km.getText().toString();
                float km1 = Float.parseFloat(km0);

                String combustivel0 = combustivel.getText().toString();
                float combustivel1 = Float.parseFloat(combustivel0);

                String autonomia0 = autonomia.getText().toString();
                float autonomia1 = Float.parseFloat(autonomia0);

                float conta = km1/autonomia1*combustivel1;
                String resultado = String.valueOf(conta);
                name = "Custo de "+resultado;
                tv.setText(name);



            }
        });




    }

    protected void onSaveInstanceState(Bundle dados){
        super.onSaveInstanceState(dados);
        dados.putString("chaveNome", name);
    }

}