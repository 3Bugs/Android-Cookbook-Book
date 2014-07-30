package com.example.backstackdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    private static final int MENU_ADD_FRAGMENT = 1;
    /*
     * �����Ţ�á���������ҡ�˹�����ͧ
     * ������Ţ�ӹǹ�������������������� ����Ф��駷���Թ�᷹��ͧ
     * CountingFragment �١���ҧ���
     */
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // ���ҧ����� Add Fragment �����
        MenuItem item = menu.add(1, MENU_ADD_FRAGMENT, 0, "Add Fragment");
        // �ʴ�����觹�麹 action bar ����շ����ҧ��
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // ��������͡����� Add Fragment �ҡ����
        case MENU_ADD_FRAGMENT:
            addFragmentToStack();
            return true;
        default:
            return true;
        }
    }

    void addFragmentToStack() {
        mCount++;
        // ���ҧ�Թ�᷹��ͧ CountingFragment ���� mCount ��繾���������
        Fragment fragment = CountingFragment.newInstance(mCount);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        // �����á�������������ҧŧ� FrameLayout
        ft.replace(R.id.fragment_container, fragment);
        // ��˹��͹������㹡���ʴ��á���������
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        /*
         * �ѹ�֡��ô��Թ�������ǡѺ�á�����ŧ� back stack
         * �����������ö����� Back ��͹��Ѻ��ѧ�á������͹˹����
         */
        ft.addToBackStack(null);
        ft.commit();
    }
}
