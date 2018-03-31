package com.golendukhin.khabarovsktourgide;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);



        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }

//    private ArrayList<Sight> getSights() {
//        Resources resources = getResources();
//        TypedArray typedArray = resources.obtainTypedArray(R.array.museums);
//        int length = typedArray.length();
//
//        String[][] optionsResources = new String[length][];
//        for (int i = 0; i < length; ++i) {
//            int id = typedArray.getResourceId(i, 0);
//            optionsResources[i] = resources.getStringArray(id);
//        }
//        typedArray.recycle();
//
//
//        ArrayList<Sight> sights = new ArrayList<>();
//        for (int j = 0; j < optionsResources[0].length; j++) {
//            sights.add(new Sight(optionsResources[0][j],
//                    optionsResources[1][j],
//                    optionsResources[2][j],
//                    optionsResources[3][j],
//                    optionsResources[4][j],
//                    resources.getIdentifier(optionsResources[5][0], "drawable", this.getPackageName())));
//            }
//        return sights;
//    }



//    private ArrayList<Sight> getSights() {
//        Resources resources = getResources();
//        TypedArray typedArray = resources.obtainTypedArray(R.array.museums);
//        int length = typedArray.length();
//
//        String[][] optionsResources = new String[length][];
//        for (int i = 0; i < length; ++i) {
//            int id = typedArray.getResourceId(i, 0);
//            optionsResources[i] = resources.getStringArray(id);
//        }
//        typedArray.recycle();
//
//        ArrayList<Sight> sights = new ArrayList<>();
//        for (int j = 0; j < optionsResources[0].length; j++) {
//            sights.add(new Sight(optionsResources[0][j],
//                    optionsResources[1][j],
//                    optionsResources[2][j],
//                    optionsResources[3][j],
//                    optionsResources[4][j],
//                    resources.getIdentifier(optionsResources[5][0], "drawable", getPackageName())));
//        }
//        return sights;
//    }

}
