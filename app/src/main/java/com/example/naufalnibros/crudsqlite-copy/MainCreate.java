package com.example.naufalnibros.crudsqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainCreate extends AppCompatActivity {

    private DatabaseHandler db;
    private EditText Ename, Ekelas;
    private String Snama, Skelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        Ename = (EditText) findViewById(R.id.create_nama);
        Ekelas = (EditText) findViewById(R.id.create_kelas);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Ename.getText());
                Skelas = String.valueOf(Ekelas.getText());

                if (Snama.equals("")){
                    Ename.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")) {
                    Ekelas.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Kelas terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    Ename.setText("");
                    Ekelas.setText("");
                    Toast.makeText(MainCreate.this, "Data Telah Ditambahkan", Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new ModalMahasiswa(null, Snama, Skelas));
                }
            }

        });
    }

}
