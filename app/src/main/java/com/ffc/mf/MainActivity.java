package com.ffc.mf;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private void three() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 3; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mTextMessage.post(new Runnable() {
                    @Override
                    public void run() {
                        mTextMessage.setText("通过View.post(Runnable r) 方法");
                    }
                });
            }
        }.run();
    }


//    public static <T> void doTask(final Task<T> task) {
//        //创建被观察者 Observable，它决定什么时候触发事件以及触发怎样的事件。
//        Observable.create(new Observable.OnSubscribe<T>() {
//            @Override
//            public void call(Subscriber<? super T> subscriber) {
//                // 线程执行耗时操作
////                task.doOnIOThread();
////                subscriber.onNext(task.getT());
//                subscriber.onCompleted();
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                //订阅
//                .subscribe(new Action1<T>() {
//                    @Override
//                    public void call(T t) {
//                        //主线程更新UI
////                        task.doOnUIThread();
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        throwable.printStackTrace();
//                    }
//                });
//    }

}
