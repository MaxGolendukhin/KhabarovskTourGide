package com.golendukhin.khabarovsktourgide;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.ArrayList;

final class Utils {

    /**
     * Constructor suppression to avoid initialization
     */
    private Utils() {
        throw new AssertionError(R.string.util_exception_instantiation);
    }

    /**
     * @return museums arrayList to populate list
     */
    static ArrayList<Sight> getSights(Context context, int arraySourceId) {
        Resources resources = context.getResources();
        TypedArray typedArray = resources.obtainTypedArray(arraySourceId);
        int length = typedArray.length();

        String[][] optionsResources = new String[length][];
        for (int i = 0; i < length; ++i) {
            int id = typedArray.getResourceId(i, 0);
            optionsResources[i] = resources.getStringArray(id);
        }
        typedArray.recycle();

        ArrayList<Sight> sights = new ArrayList<>();
        for (int j = 0; j < optionsResources[0].length; j++) {
                    sights.add(new Sight(optionsResources[0][j],
                    optionsResources[1][j],
                    optionsResources[2][j],
                    optionsResources[3][j],
                    optionsResources[4][j],
                    resources.getIdentifier(optionsResources[5][j], "drawable", context.getPackageName()),
                    optionsResources[6][j]));
        }
        return sights;
    }
}