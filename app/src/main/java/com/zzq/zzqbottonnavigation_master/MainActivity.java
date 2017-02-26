package com.zzq.zzqbottonnavigation_master;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zzq.zzqbottonnavigation_master.activity.ABoutActivity;
import com.zzq.zzqbottonnavigation_master.fragments.BooksFragment;
import com.zzq.zzqbottonnavigation_master.fragments.GamesFragment;
import com.zzq.zzqbottonnavigation_master.fragments.HomeFragment;
import com.zzq.zzqbottonnavigation_master.fragments.MoviesFragment;
import com.zzq.zzqbottonnavigation_master.fragments.MusicFragment;
import com.zzq.zzqbottonnavigation_master.utils.MyAlertDialogUtil;
import com.zzq.zzqbottonnavigation_master.utils.MyToast;
import com.zzq.zzqbottonnavigation_master.utils.StatusBarUtils;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    //    private TextView message, scrollable_text;
    BadgeItem numberBadgeItem;
    private Toolbar mToolbar;
    private long exitTime;// 退出时间
    private HomeFragment homeFragment;
    private MoviesFragment moviesFragment;
    private MusicFragment musicFragment;
    private BooksFragment booksFragment;
    private GamesFragment gamesFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.noTificationBar(MainActivity.this);
        initComponent();
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zhihu_toolbar_menu, menu);
        return true;

    }

    private void initComponent() {
        mToolbar = (Toolbar) findViewById(R.id.tb_Toolbar);
        mToolbar.setTitle("图片展示页面");
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAlertDialogUtil.myAlertDialog(MainActivity.this, "标题", "确定退出吗?");
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        MyToast.showToast2(getApplication(), "这是查找~");
                        break;
                    case R.id.action_notification:
                        MyToast.showToast2(getApplication(), "这是通知~");
                        break;
                    case R.id.action_shars:
                        MyToast.showToast2(getApplication(), "分享");
                        break;
                    case R.id.action_settings:
                        MyToast.showToast2(getApplication(), "设置");
                        break;
                    case R.id.action_about:

                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, ABoutActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//        message = (TextView) findViewById(R.id.message);
//        scrollable_text = (TextView) findViewById(R.id.scrollable_text);
    }

    private void init() {
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setActiveColorResource(R.color.colorAccent).setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "图书").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "音乐").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "视频").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "游戏").setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {

//        setMessageText(0 + " Tab Reselected");
//        scrollable_text.setText(R.string.para1);
        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance(getResources().getString(R.string.SongNameOne), getResources().getString(R.string.LyricOne));
        transaction.replace(R.id.tb, homeFragment);
        mToolbar.setTitle("山丘-李宗盛");
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.newInstance(getResources().getString(R.string.SongNameOne), getResources().getString(R.string.LyricOne));
                }
                mToolbar.setTitle("山丘-李宗盛");
                transaction.replace(R.id.tb, homeFragment);
                break;
            case 1:

                if (booksFragment == null) {
                    booksFragment = BooksFragment.newInstance(getResources().getString(R.string.SongNameTwo), getResources().getString(R.string.LyricTwo));
                }
                mToolbar.setTitle("冬天的秘密-周传雄");
                transaction.replace(R.id.tb, booksFragment);
                break;
            case 2:
                if (musicFragment == null) {
                    musicFragment = MusicFragment.newInstance(getResources().getString(R.string.SongNameThree), getResources().getString(R.string.LyricThree));
                }
                mToolbar.setTitle("鬼迷心窍-李宗盛");
                transaction.replace(R.id.tb, musicFragment);
                break;
            case 3:
                if (moviesFragment == null) {
                    moviesFragment = MoviesFragment.newInstance(getResources().getString(R.string.SongNameFour), getResources().getString(R.string.LyricFour));
                }
                mToolbar.setTitle("为你我受冷风吹");
                transaction.replace(R.id.tb, moviesFragment);
                break;
            case 4:
                if (gamesFragment == null) {
                    gamesFragment = GamesFragment.newInstance(getResources().getString(R.string.SongNameFive), getResources().getString(R.string.LyricFive));
                }
                mToolbar.setTitle("这个年纪");
                transaction.replace(R.id.tb, gamesFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();

        //设置position
//        setScrollableText(position);
    }

//    public void hideFragment(FragmentTransaction transaction) {
//        for (Fragment fragment : list) {
//            transaction.hide(fragment);
//        }
//    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitData();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 退出程序方法
     */
    public void exitData() {
        // 如果两次点击返回键的时间大于2000毫秒
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            // 提示再次点击退出程序
            MyToast.showToast2(getApplication(), "再次点击退出程序");
            exitTime = System.currentTimeMillis();
        } else {// 否者退出程序
            finish();
            System.exit(0);
        }
    }

    //    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.toggle_hide) {
//            if (bottomNavigationBar != null) {
//                bottomNavigationBar.toggle();
//            }
//        } else if (v.getId() == R.id.toggle_badge) {
//            if (numberBadgeItem != null) {
//                numberBadgeItem.toggle();
//            }
//        } else if (v.getId() == R.id.fab_home) {
//            final Snackbar snackbar = Snackbar.make(message, "Fab Clicked", Snackbar.LENGTH_LONG);
//            snackbar.setAction("dismiss", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    snackbar.dismiss();
//                }
//            });
//            snackbar.show();
//        }
//    }
}
