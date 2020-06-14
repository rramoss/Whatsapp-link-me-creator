package com.example.wacreador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phone_text=(EditText) findViewById(R.id.phone_text);
        final EditText message_text=(EditText) findViewById(R.id.message_text);
        Button btn_generar=(Button) findViewById(R.id.continuar);

        final ClipboardManager clipboard=(ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel= "52"+phone_text.getText().toString();
                String message = URLEncoder.encode(message_text.getText().toString());
                String wa_text= ""; //https://wa.me/numerodetelefonodewhatsapp/?text=urlencodedtext

                if (tel!="" && message!=""){
                    wa_text = "https://wa.me/"+tel+"/?text="+message;
                    //copy clipboard
                    if (clipboard != null) {
                        clipboard.setPrimaryClip(
                                ClipData.newPlainText("Wa",wa_text)
                        );
                    }
                    Toast.makeText(getApplicationContext(),"Generado y copiado correctamente", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Teléfono o mensaje vacio.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }// end create activity


}
