package com.example.superuser.myapplication.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.superuser.myapplication.Config;
import com.example.superuser.myapplication.R;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    Button mBtnFollowSecAct;
    Button mBtnStartForResult;
    Button mBtnSendNot;

    private static final int NOTIFY_ID = 101; //идентификатор обновления, определяемый в вашем классе для работы с уведомлением

    //    Метод запускаемый при запусеке приложения
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Находим по ID txt_main_activity
        mainTextView = (TextView) findViewById(R.id.txt_main_activity);

//        Задаем текст
        mainTextView.setText("Main Activity");

        mBtnFollowSecAct = (Button) findViewById(R.id.btn_followMain_activity);
//       Определяем слушателя
        mBtnFollowSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Вызов новой активности (в данном случае SecondActivity)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                Стартует обьект intent
                startActivity(intent);
            }
        });

        mBtnStartForResult = (Button) findViewById(R.id.btn_forResult);
        mBtnStartForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(MainActivity.this, SecondActivity.class);
//            Возвращает заданные значения в SecondActivity в MainActivity
                startActivityForResult(result, 0);
            }
        });

        mBtnSendNot = (Button) findViewById(R.id.btn_sendNotification);
        mBtnSendNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                вызываем метод  createNotification()
                createNotification();
            }
        });
        Log.d(Config.TAG, "MainActivity - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Config.TAG, "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Config.TAG, "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Config.TAG, "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Config.TAG, "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Config.TAG, "MainActivity - onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//  задаём name данные полученные из текстового поля secondActivity
        String name = data.getStringExtra("name");
        mainTextView.setText("Your name is " + name);
    }

    private void createNotification() {
//   context - обьект работающий во всём приложении, получение ссылки на обьект приложения с помошью getApplicationContext();
        Context context = getApplicationContext();
//
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(context);
//============================================
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentTitle(String.valueOf(R.string.txt_notification_title))
                .setContentText(String.valueOf(R.string.txt_notification_text))
                .setAutoCancel(true);

        Notification notification = builder.getNotification();
        nm.notify(NOTIFY_ID, notification);
    }
}