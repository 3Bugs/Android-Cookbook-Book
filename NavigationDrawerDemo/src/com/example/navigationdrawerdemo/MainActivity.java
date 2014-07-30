package com.example.navigationdrawerdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    // ���ʹ���������������к�������
    protected static final String[] mPlanetTitles = new String[] { "Mercury",
            "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune" };
    // ��ҧ�ԧ��ѧ root view �ͧ layout
    private DrawerLayout mDrawerLayout;
    // ��ҧ�ԧ��ѧ ListView �����ᶺ drawer 
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // ���ҧ��С�˹� adapter ���Ѻ ListView (ᶺ drawer) �����ʴ���ª��ʹ�����������ʵ�
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, mPlanetTitles));
        // ��˹� click listener ���Ѻ ListView
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // �кء�÷ӧҹ���������� (���ʹ��������) ���ʵ�١��ԡ���͡
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // ��Ŵ�á��������ʴ��Ҿ���������
                String planetTitle = mPlanetTitles[position];
                showPlanetDetails(planetTitle);
                // ���ŷ���������١���͡�ᶺ drawer
                mDrawerList.setItemChecked(position, true);
                // �ʴ����ʹ�������캹 title bar
                setTitle(mPlanetTitles[position]);
                // �Դ drawer
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });
    }
    
    // ���ҧ�Թ�᷹��ͧ PlanetDetailsFragment ��������ŧ� layout
    void showPlanetDetails(String planetTitle) {
        PlanetDetailsFragment fragment = PlanetDetailsFragment
                .newInstance(planetTitle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}
