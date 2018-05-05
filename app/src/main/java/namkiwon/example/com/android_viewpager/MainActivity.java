package namkiwon.example.com.android_viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent loginIntent;
    Button goLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        goLogin = (Button) findViewById(R.id.goLogin);
        goLogin.setOnClickListener(bListener);

    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goLogin :
                    loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(loginIntent);
                    finish();  // 현주야 여기서 finish 하는 이유는 카톡같은거 봐도 제일 하단에 있는 액티비티는 결국 홈이잖아?  그래서 로그인 후에는 다시는 안봐도 되니까 이 액티비티를 죽일거야
                    break;
            }
        }
    };
}
