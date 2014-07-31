package com.example.swipeviewsdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity {

    // ���ʹ���������������к�������
    protected static final String[] mPlanetTitles = new String[] { "Mercury",
            "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };

    PlanetPagerAdapter mAdapter; // pager adapter
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * ���ҧ�ͺ�礷���� pager adapter (�Թ�᷹��ͧ PlanetPagerAdapter)
         * ���ǹ�仡�˹����Ѻ ViewPager
         */
        mAdapter = new PlanetPagerAdapter(getFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        // �ͺ�� OnPageChangeListener ����Ѻ�к��鴡�÷ӧҹ������ա������¹ྨ� ViewPager
        ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                setTitle(mAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        };

        // ��˹��ͺ�� OnPageChangeListener ���Ѻ ViewPager
        mViewPager.setOnPageChangeListener(pageChangeListener);
        // �ʴ����ʹ���������á�� title bar 㹵͹�������
        pageChangeListener.onPageSelected(0);
    }

    public class PlanetPagerAdapter extends FragmentStatePagerAdapter {
        public PlanetPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            // ���ҧ�á��������ʴ��Ҿ��������� �����觤׹�á��������Ѻ�͡�
            String planetTitle = mPlanetTitles[i];
            Fragment fragment = PlanetDetailsFragment.newInstance(planetTitle);
            return fragment;
        }

        @Override
        public int getCount() {
            return mPlanetTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mPlanetTitles[position];
        }
    }
}
