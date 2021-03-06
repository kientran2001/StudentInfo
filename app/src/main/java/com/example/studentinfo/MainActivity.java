package com.example.studentinfo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText mssv, name, cccd, phone, email, quequan, noio;
    public TextView textViewBirthday;
    public CalendarView birthday;
    public Button btnOk;
    public CheckBox commit;
    public Toast toast;
    public RadioButton it1, it2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mssv = findViewById(R.id.et_mssv);
        name = findViewById(R.id.et_hoten);
        cccd = findViewById(R.id.et_cccd);
        phone = findViewById(R.id.et_sdt);
        email = findViewById(R.id.et_email);
        quequan = findViewById(R.id.et_quequan);
        noio = findViewById(R.id.et_noio);
        textViewBirthday = findViewById(R.id.tv_ngaysinh);
        birthday = findViewById(R.id.calendarView);
        it1 = findViewById(R.id.rb1);
        it2 = findViewById(R.id.rb2);
        commit = findViewById(R.id.dieukhoan);
        btnOk = findViewById(R.id.btn_ok);

        textViewBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthday.setVisibility(birthday.VISIBLE);
            }
        });

        birthday.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                textViewBirthday.setText(dayOfMonth+"/"+month+"/"+year);
                birthday.setVisibility(birthday.GONE);
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!commit.isChecked()){
                    toast = Toast.makeText(MainActivity.this,"B???n ph???i ?????ng ?? v???i ??i???u kho???n m???i c?? th??? ????ng submit", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    if (mssv.getText().toString().length() == 0){
                        mssv.setHint("MSSV l?? b???t bu???c");
                        mssv.setHintTextColor(Color.RED);
                    }
                    if (name.getText().toString().length() == 0){
                        name.setHint("T??n l?? b???t bu???c");
                        name.setHintTextColor(Color.RED);

                    }
                    if (cccd.getText().toString().length() == 0){
                        cccd.setHint("CCCD l?? b???t bu???c");
                        cccd.setHintTextColor(Color.RED);
                    }
                    if (phone.getText().toString().length() == 0){
                        phone.setHint("S??T l?? b???t bu???c");
                        phone.setHintTextColor(Color.RED);
                    }
                    if (email.getText().toString().length() == 0){
                        email.setHint("Email l?? b???t bu???c");
                        email.setHintTextColor(Color.RED);
                    }
                    if(textViewBirthday.toString().length() == 0){
                        toast = Toast.makeText(MainActivity.this,"Ng??y sinh l?? b???t bu???c", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    if (!it1.isChecked() && !it2.isChecked()){
                        toast = Toast.makeText(MainActivity.this,"B???n ch??a ch???n chuy??n ng??nh", Toast.LENGTH_LONG);
                        toast.show();
                    }

                    if (mssv.getText().toString().length() != 0 && name.getText().toString().length() != 0
                            && cccd.getText().toString().length() != 0 && phone.getText().toString().length() != 0
                            && email.getText().toString().length() != 0){
                        toast = Toast.makeText(MainActivity.this,"Submit th??nh c??ng", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
    }
}