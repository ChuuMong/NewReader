package chuumong.co.kr.newreader.ui.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by RichBeam on 2015-10-12.
 */
public class FragmentFactory {

    private static FragmentFactory instance;
    private static final HashMap<String, Fragment> map = new HashMap<>();

    private FragmentFactory() {
        init();
    }

    public static FragmentFactory getinstance() {
        if (instance == null) {
            synchronized (FragmentFactory.class) {
                if (instance == null) {
                    instance = new FragmentFactory();
                }
            }
        }

        return instance;
    }

    private void init() {
        if (map.isEmpty()) {
            map.put("BookFragment", new BookFragment());
            map.put("FileFragment", new FileFragment());
        }
    }

    public Fragment get(String tag) {
        if (map.isEmpty()) {
            throw new IllegalStateException("Not Init Fragment");
        }

        return map.get(tag);
    }
}
