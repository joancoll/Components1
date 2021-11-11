package cat.dam.andy.components1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //crida al control de selecció de layouts
        openLayoutControl();
        //aqui sota hi hauria el programa principal
        controller1(); //programa de control Layout1
    }

    protected void controller1() {
        //TextView
        TextView tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setText("Sóc un TextView. Clica'm!");
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.tv_1);
                tv.setText("Has clicat el TextView!!");
            }
        });
    }

    protected void controller2() {
        //EditText
        EditText et_1 = (EditText) findViewById(R.id.et_1);
        et_1.setText("Sóc un EditText. Edita'm!");
    }

    protected void controller3() {
        //AutocompleteTextView
        String[] fruites = new String[]{
                "Poma", "Taronja", "Pera", "Maduixa", "Raïm",
                "Mandarina", "Plàtan", "Albercoc", "Alvocat", "Caqui",
                "Cirera","Coco","Dàtil","Figa","Guaiaba","Kiwi","Litxi",
                "Llimona","Magrana", "Mango","Meló","Nespra","Papaia", "Pinya",
                "Prèssec", "Pruna","Raïm", "Síndria", "Xirimoia"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, fruites);
        AutoCompleteTextView atv_Fruita = (AutoCompleteTextView)
                findViewById(R.id.atv_Fruita);
        atv_Fruita.setAdapter(adapter);
    }

    protected void controller4() {
        //Button
        final Button btn_1 = findViewById(R.id.btn_1);
        final TextView tv_1 = findViewById(R.id.tv_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Aquest és el codi que s'executa al clicar
                tv_1.setText("Has fet clic!");
            }
        });
    }

    protected void openLayoutControl() {
    /*
    Mètode que mostra els diferents layouts (layout.xml<<per defecte, layout2.xml i layout3.xml)
    Controla els botons i si es fa clic sobre algun d'ells carrega el layout corresponent
     */
        final Button btn_lyt1 = findViewById(R.id.btn_lyt1);
        final Button btn_lyt2 = findViewById(R.id.btn_lyt2);
        final Button btn_lyt3 = findViewById(R.id.btn_lyt3);
        final Button btn_lyt4 = findViewById(R.id.btn_lyt4);
        final FrameLayout fl_content = findViewById(R.id.fl_content);
        //Per defecte mostra el primer layout
        View child = getLayoutInflater().inflate(R.layout.layout, null);
        fl_content.addView(child);
        //en cas de que es premi algun dels botons mostrarà el layout corresponent
        btn_lyt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button 1 Clicked");
                fl_content.removeAllViews();
                View child = getLayoutInflater().inflate(R.layout.layout, null);
                fl_content.addView(child);
                controller1();
            }
        });
        btn_lyt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button 2 Clicked");
                fl_content.removeAllViews();
                View child = getLayoutInflater().inflate(R.layout.layout2, null);
                fl_content.addView(child);
                controller2();
            }
        });
        btn_lyt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button 3 Clicked");
                fl_content.removeAllViews();
                View child = getLayoutInflater().inflate(R.layout.layout3, null);
                fl_content.addView(child);
                controller3();
            }
        });
        btn_lyt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button 4 Clicked");
                fl_content.removeAllViews();
                View child = getLayoutInflater().inflate(R.layout.layout4, null);
                fl_content.addView(child);
                controller4();
            }
        });
    }
}

