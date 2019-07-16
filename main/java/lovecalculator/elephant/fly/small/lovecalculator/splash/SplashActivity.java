package lovecalculator.elephant.fly.small.lovecalculator.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import lovecalculator.elephant.fly.small.lovecalculator.MainActivity;
import lovecalculator.elephant.fly.small.lovecalculator.R;

/**
 * Created by linsheng on 2019/7/11.
 */

public class SplashActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "SplashActivity";
    private TextView bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        bt = findViewById(R.id.bt);
        startClock();
        bt.setOnClickListener(this);
    }

    private void startClock() {
        bt.setVisibility(View.VISIBLE);
        countDownTimer.start();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(3200, 1000) {
        @Override
        public void onTick(long l) {
            bt.setText("skip ad " + l / 1000 + "s");
        }

        @Override
        public void onFinish() {
            bt.setText("skip ad " + 0 + "s");
            toMainActivity();
        }
    };

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.bt:
                toMainActivity();
        }
    }

    private void toMainActivity() {

        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer!= null){
            countDownTimer.cancel();
        }
    }
}
