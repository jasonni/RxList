package com.github.jasonni.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.github.s0nerik.rxlist.Event;
import com.github.s0nerik.rxlist.RxList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final List<String> dataList = new ArrayList<>();
    final RxList<String> rxList = new RxList<>(dataList);

    rxList.events().subscribe(new Action1<Event<String>>() {
      @Override public void call(Event<String> stringEvent) {
        Log.d("MainActivity", stringEvent.item);
      }
    });

    Observable.interval(1, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
      @Override public void call(Long aLong) {
        rxList.add(String.valueOf(aLong));
      }
    });
  }
}
