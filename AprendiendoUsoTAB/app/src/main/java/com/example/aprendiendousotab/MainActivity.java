package com.example.aprendiendousotab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.example.aprendiendousotab.Fragments.OneFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar; //Barra de herramientas
    private TabLayout tabLayout; //Contenedor para Tabs
    private ViewPager viewPager; //Administrador de diseño que permite pasar de izquierda a derecha a través de páginas.
    private int[] tabIcons = {R.drawable.ic_action_favorite,R.drawable.ic_action_call,R.drawable.ic_action_contact};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar); //Llamada a referencia de vista
        setSupportActionBar(toolbar); //Implementando barra de herramientas en la actividad

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //establece si en la barra de herramientas de agregar botón back como actividad secudaria

        viewPager = findViewById(R.id.viewPager);
        configurarGestorDePaginas(viewPager); //Configuración de fragmento para cada tab

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager); //
        configurarIconosATab();
    }

    private void configurarIconosATab() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void renderIconWithText(int tab,String title,int icon){
        TextView tabText = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabText.setText(title);
        tabText.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0);
        tabLayout.getTabAt(tab).setCustomView(tabText);
    }

    private void configurarGestorDePaginas(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new OneFragment(), "TWO");
        adapter.addFragment(new OneFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager manager) {
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return null;
            //return mFragmentTitleList.get(position);
        }
    }

    class ViewStatePagerAdapter extends FragmentStatePagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();


        public ViewStatePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public ViewStatePagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return null;
            //return mFragmentTitleList.get(position);
        }
    }
}
