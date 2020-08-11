package com.nav.navigatorapp.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import java.util.ArrayList;


public class StatePagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragmentList = null;

    public StatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

//    public StatePagerAdapter(FragmentManager fm, ArrayList<Fragment> articleFragments) {
//        super(fm);
//        this.mFragmentList = articleFragments;
//    }

    public StatePagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> mFragmentList) {
        super(supportFragmentManager);
        this.mFragmentList = mFragmentList;
    }


    //    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        if (position==0)
//        {
//            Log.d("position",String.valueOf(position));
//        }
//        return mArticleFragmentList.get(position);
//    }
//    public void setListener(ArticlePositionListener positionListener)
//    {
//        this.positionListener=positionListener;
//    }
    @Override
    public Fragment getItem(int position) {
//        Log.d("position",String.valueOf(position));
//        positionListener.onArticlePosition(position);
//        if (position%2==0)
//        {
//            Log.d("Articleposition",String.valueOf(position));
//            return null;
//        }
        //else {
            return mFragmentList.get(position);
        //}
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    void addAllArticleFragment(ArrayList<Fragment> articleFragments) {
        if(mFragmentList!=null)
            mFragmentList = new ArrayList<>();
        mFragmentList.clear();
        mFragmentList.addAll(articleFragments);
        notifyDataSetChanged();
    }



}
