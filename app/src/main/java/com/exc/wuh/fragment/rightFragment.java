package com.exc.wuh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.exc.utils.GlideShowUtil;
import com.exc.wuh.MapTypeDemo;
import com.exc.wuh.R;
import com.github.chrisbanes.photoview.PhotoView;

public class rightFragment extends Fragment {
    private View rootView;
    private ViewPager ViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            createView(inflater, container);
        }
        ViewGroup viewGroup = (ViewGroup) rootView.getParent();
        if (null != viewGroup) {
            viewGroup.removeAllViewsInLayout();
        }
        return rootView;
    }
    /**
     * 如果已经创建,不需要重复创建
     */
    private void createView(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.activity_rightfragment,parent, false);

        ViewPager viewPager =rootView.findViewById(R.id.view_pager);
        viewPager.setAdapter(new SamplePagerAdapter());
    }
    class SamplePagerAdapter extends PagerAdapter {

        private final int[] sDrawables = {R.mipmap.wallpaper, R.mipmap.wallpaper, R.mipmap.wallpaper,
                R.mipmap.wallpaper, R.mipmap.wallpaper, R.mipmap.wallpaper};

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            if(position == 1){
                GlideShowUtil.showImage(rightFragment.this.getActivity(), photoView,"https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00182-2105.jpg");
            }else {
                photoView.setImageResource(sDrawables[position]);
            }

            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
