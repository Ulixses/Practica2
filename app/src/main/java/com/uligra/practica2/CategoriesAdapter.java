package com.uligra.practica2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoriesAdapter extends FragmentPagerAdapter {

    Context m_context;

    public CategoriesAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    public CategoriesAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        m_context = context;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return m_context.getResources().getText(R.string.nd_new);
            case 1:
                return m_context.getResources().getText(R.string.nd_ps4);
            case 2:
                return m_context.getResources().getText(R.string.nd_xbox);
            case 3:
                return m_context.getResources().getText(R.string.nd_ofer);
        }
        return null;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new NovedadesActivity();
            case 1:
                return new PS4Activity();
            case 2:
                return new XBoxActivity();
            case 3:
                return new OfertasActivity();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
