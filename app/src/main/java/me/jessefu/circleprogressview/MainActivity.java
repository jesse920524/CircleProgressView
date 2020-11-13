package me.jessefu.circleprogressview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private CircleProgressView mCircleProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mCircleProgressView = findViewById(R.id.cpv_am);

        List<CircleProgressView.ProgressVO> datas = new ArrayList<>();

        CircleProgressView.ProgressVO vo0 = new CircleProgressView.ProgressVO();
        vo0.id = 0;
        vo0.progress = 75;
        vo0.color = R.color.circle_progress_orange;

        CircleProgressView.ProgressVO vo1 = new CircleProgressView.ProgressVO();
        vo1.id = 1;
        vo1.progress = 50;
        vo1.color = R.color.circle_progress_red;

        CircleProgressView.ProgressVO vo2 = new CircleProgressView.ProgressVO();
        vo2.id = 2;
        vo2.progress = 20;
        vo2.color = R.color.circle_progress_pruple;

        Collections.addAll(datas, vo0, vo1, vo2);
        mCircleProgressView.setData(datas);
    }
}