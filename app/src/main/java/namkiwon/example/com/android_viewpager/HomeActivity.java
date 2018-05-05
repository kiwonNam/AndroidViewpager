package namkiwon.example.com.android_viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;

import namkiwon.example.com.android_viewpager.Fragment.FirstFragment;
import namkiwon.example.com.android_viewpager.Fragment.SecondFragment;
import namkiwon.example.com.android_viewpager.Fragment.ThirdFragment;

public class HomeActivity extends AppCompatActivity{
    private ViewPager vp;  // 뷰페이저는 그냥 화면을 쓸어도 탭이 넘어가게 해주는? 그런놈이야!  얘는 얘를 관리해주는 Adapter가 따로 필요한데 Adapter는 아래에 이너클래스로 넣어놨어!
    private TabLayout tabLayout; /* 이것을 사용하려면 build graddle(app 단위) 에
    implementation 'com.android.support:design:27.1.1'  << 이것을 추가해야되는데 뒤에 버전숫자는
     implementation 'com.android.support:appcompat-v7:27.1.1' << 이거랑 맞춰주면 되! 이거는 이미 추가 되어 있을거야 그리고  상단에 노란바가 뜨면 syncnow를  클릭하자!
    */
    private FirstFragment first;
    private SecondFragment second;
    private ThirdFragment third;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vp = (ViewPager) findViewById(R.id.home_viewpager);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        tabLayout = (TabLayout) findViewById(R.id.home_tab);
        tabLayout.setupWithViewPager(vp);
        first = new FirstFragment();
        second = new SecondFragment();
        third = new ThirdFragment();

    }


    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(android.support.v4.app.FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position) //여기서 페이지 수를 결정짓는거야!
        {
            switch(position)
            {
                case 0:
                    return first;
                case 1:
                    return second;
                case 2:
                    return third;
                default:
                    return null;
            }

        }
        @Override
        public int getCount()  // 얘는 나중에 페이지 개수 몇인지 궁금할때 쓰는놈
        {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {  // 요놈은 탭레이아웃 페이지 제목!!
            switch (position){
                case 0: return "첫번째탭";
                case 1 : return  "두번째탭";
                case 2 : return  "세번째탭";
                default: return null;
            }

        }
    }
}
