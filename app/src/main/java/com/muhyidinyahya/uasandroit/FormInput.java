package com.muhyidinyahya.uasandroit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class FormInput extends AppCompatActivity {


    String diterima;
    String puasahariini;
    String strSunah;
    String strsubuh;
    String strDzuhur;
    String strAsar;
    String strMaghrib;
    String strIsya;
    String ramadhanKe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_input);

        // ===================== EDIT TEXT =============================
        // Data Pribadi
        EditText input_nama = findViewById(R.id.input_nama);
        EditText input_alamat = findViewById(R.id.input_alamat);


        // Data Masjid
        EditText input_masjid = findViewById(R.id.input_namamasjid);
        EditText input_alamatmasjid = findViewById(R.id.input_alamatmasjid);
        EditText input_imam = findViewById(R.id.input_imam);


        // Catatan Ramadhan
        EditText input_tanggal = findViewById(R.id.input_tanggal);
        EditText input_isi = findViewById(R.id.input_isi);
        EditText input_uzur = findViewById(R.id.input_uzur);
        EditText input_penceramah = findViewById(R.id.input_penceramah);
        EditText input_judul = findViewById(R.id.input_judul);


        Spinner ramadanKe = findViewById(R.id.ramadhan_ke);

        ramadanKe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(ramadanKe.getSelectedItem());

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ramadhanKe = (item.equals(ramadanKe.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // ===================== RADIO GROUP =============================
        RadioGroup radioTarawih = findViewById(R.id.tarawih);

        radioTarawih.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();
                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    strSunah = checkedRadioButton.getText().toString();
                    Toast.makeText(FormInput.this, "Kamu Memilih " + strSunah, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // ===================== SWITCH =============================
        Switch Puasa = findViewById(R.id.Puasa);

        Puasa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                puasahariini = (isChecked) ? "Puasa" : "Tidak Puasa";
                Toast.makeText(FormInput.this, "Kamu " + puasahariini, Toast.LENGTH_SHORT).show();

            }
        });


        // ===================== CHECKBOX =============================

        CheckBox cb_subuh = findViewById(R.id.cb_subuh);

        cb_subuh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strsubuh = (isChecked) ? "Sholat" : "Tidak Sholat";
                Toast.makeText(FormInput.this, "Kamu " + diterima, Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cb_dzuhur = findViewById(R.id.cb_dzuhur);

        cb_dzuhur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strDzuhur = (isChecked) ? "Sholat" : "Tidak Sholat";
                Toast.makeText(FormInput.this, "Kamu " + diterima, Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cb_asar = findViewById(R.id.cb_asar);

        cb_asar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strAsar = (isChecked) ? "Sholat" : "Tidak Sholat";
                Toast.makeText(FormInput.this, "Kamu " + diterima, Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cb_maghrib = findViewById(R.id.cb_maghrib);

        cb_maghrib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strMaghrib = (isChecked) ? "Sholat" : "Tidak Sholat";
                Toast.makeText(FormInput.this, "Kamu " + diterima, Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cb_isya = findViewById(R.id.cb_isya);

        cb_isya.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                strIsya = (isChecked) ? "Sholat" : "Tidak Sholat";
                Toast.makeText(FormInput.this, "Kamu " + diterima, Toast.LENGTH_SHORT).show();
            }
        });

        // ===================== SUBMIT FORM =============================

        Button btnSumbit = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ===================== ALERT DIALOG YES NO =============================
                AlertDialog.Builder dialog = new AlertDialog.Builder(FormInput.this);
                dialog.setTitle("Yakin disimpan?");
                dialog.setMessage("Hi! Apakah data yang dimasukan Jujur?");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("Insyaallah Jujur", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // DATA PRIBADI
                        String strNama = input_nama.getText().toString();
                        String strAlamat = input_alamat.getText().toString();


                        // DATA MASJID
                        String strMasjid = input_masjid.getText().toString();
                        String strAlamatMasjid = input_alamatmasjid.getText().toString();
                        String strImam = input_imam.getText().toString();

                        // CATATAN RAMADHAN
                        String strTanggal = input_tanggal.getText().toString();
                        String Strisi = input_isi.getText().toString();
                        String Struzur = input_uzur.getText().toString();
                        String Strpenceramah = input_penceramah.getText().toString();
                        String Strjudul = input_judul.getText().toString();
                        String MESSAGE = "======== DATA PRIBADI ========\n" +
                                "Nama : " + strNama + "\n" +
                                "Alamat : " + strAlamat +  "\n" +
                                "======== DATA TEMPAT ========\n" +
                                "Nama Masjid : " + strMasjid + "\n" +
                                "Alamat Masjid : " + strAlamatMasjid + "\n" +
                                "Imam/Khatib : " + strImam + "\n" +
                                "======== CATATAN RAMADHAN ========\n" +
                                "Tanggal : " + strTanggal + " \n" +
                                "Ramadhan ke : " + ramadhanKe + " \n" +
                                "======== SHOLAT WAJIB ========\n" +
                                "Subuh : " + strsubuh + " \n" +
                                "Dzuhur : " + strDzuhur+ " \n" +
                                "Asar : " + strAsar + " \n" +
                                "Maghrib : " + strMaghrib + " \n" +
                                "Isya : " + strIsya + " \n" +
                                "Tarawih Hari Ini? : " + strSunah + " \n" +
                                "Puasa Hari Ini ?: " + puasahariini + " \n" +
                                "Alasan Uzur: " + Struzur + " \n" +
                                "Nama Penceramah: " + Strpenceramah + " \n" +
                                "Judul Ceramah: " + Strjudul + " \n" +
                                "Isi Ceramah : " + Strisi + " \n" +
                                "===============================";


                        System.out.println(MESSAGE);

                        Intent successFormResult = new Intent(getBaseContext(), FormSucces.class);
                        successFormResult.putExtra("OUTPUT", MESSAGE);
                        startActivity(successFormResult);
                    }
                });
                dialog.setNegativeButton("Engga valid", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(FormInput.this, "Data Gagal Disimpan.", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });
    }
}