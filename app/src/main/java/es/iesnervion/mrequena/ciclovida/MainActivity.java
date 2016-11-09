package es.iesnervion.mrequena.ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtNumero;
    private Button btnContador;
    private Button btnMostrar;
    private Integer contador=0;
    static final String STATE_CONTADOR = "contador";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = (TextView) findViewById(R.id.txtNumero);
        btnContador= (Button) findViewById(R.id.btnSumar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        btnContador.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);


        if(savedInstanceState!=null){
            contador = savedInstanceState.getInt(STATE_CONTADOR);
        }else {
            contador = 0;
        }
        txtNumero.setText(contador.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSumar:
                contador++;
                break;
            case R.id.btnMostrar:
                txtNumero.setText(contador.toString());
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(STATE_CONTADOR, contador);

    }
}
