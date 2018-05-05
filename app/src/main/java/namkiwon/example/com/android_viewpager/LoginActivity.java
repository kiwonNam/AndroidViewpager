package namkiwon.example.com.android_viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity{
    Intent homeIntent;
    Button goHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        goHome = (Button) findViewById(R.id.goHome);
        goHome.setOnClickListener(bListener);

    }

    Button.OnClickListener bListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.goHome :
                    homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(homeIntent);
                    finish();  // 역시 같은 맥락으로 죽일거야 이 액티비티도 ^^
                    break;
            }
        }
    };
}
