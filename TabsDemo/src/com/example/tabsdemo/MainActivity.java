package com.example.tabsdemo;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    // ���ʹ���������������к�������
    protected static final String[] mPlanetTitles = new String[] { "Mercury",
            "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // �ͺ�� TabListener ����Ѻ�к��鴡�÷ӧҹ������Դ���ǹ���ҧ�����ǡѺ��
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // ��Ŵ�á��������ʴ��Ҿ���������
                String planetTitle = mPlanetTitles[tab.getPosition()];
                showPlanetDetails(planetTitle);
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab,
                    FragmentTransaction ft) {
            }

            @Override
            public void onTabReselected(ActionBar.Tab tab,
                    FragmentTransaction ft) {
            }
        };

        // ���ҧ�纵���ӹǹ��������������� mPlanetTitles
        for (int i = 0; i < mPlanetTitles.length; i++) {
            // ���ҧ������ (�ͺ�� ActionBar.Tab)
            Tab tab = actionBar.newTab();
            // ��˹���ͤ������ listener ���Ѻ��
            tab.setText(mPlanetTitles[i]);
            tab.setTabListener(tabListener);
            
            // ������ŧ� ActionBar
            actionBar.addTab(tab);
        }
    }

    // ���ҧ�Թ�᷹��ͧ PlanetDetailsFragment ��������ŧ� layout
    void showPlanetDetails(String planetTitle) {
        PlanetDetailsFragment fragment = PlanetDetailsFragment
                .newInstance(planetTitle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
