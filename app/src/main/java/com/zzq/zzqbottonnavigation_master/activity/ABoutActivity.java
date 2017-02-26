package com.zzq.zzqbottonnavigation_master.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.zzq.zzqbottonnavigation_master.R;
import com.zzq.zzqbottonnavigation_master.adapter.AboutAdapter;
import com.zzq.zzqbottonnavigation_master.base.BaseRxActivity;
import com.zzq.zzqbottonnavigation_master.entity.AboutEntity;
import com.zzq.zzqbottonnavigation_master.p.ABoutPersenter;
import com.zzq.zzqbottonnavigation_master.utils.MyAlertDialogUtil;
import com.zzq.zzqbottonnavigation_master.utils.MyToast;
import com.zzq.zzqbottonnavigation_master.v.ABoutContract;

import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by 志强 on 2017.2.13.
 */

public class ABoutActivity extends BaseRxActivity<ABoutPersenter> implements ABoutContract.View, BaseSliderView.OnSliderClickListener {


    @BindView(R.id.nested_scroll_child_about)
    NestedScrollView nestedScrollChildAbout;

    @BindView(R.id.slider)
    SliderLayout slider;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_need_offset)
    CoordinatorLayout viewNeedOffset;
    @BindView(R.id.rc_View)
    RecyclerView rcView;

    private AboutAdapter aboutAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    /**
     * 初始化变量 包括intent带的数据
     */
    @Override
    protected void initVariables() {
        getPersenter().getAboutResult();
    }

    /**
     * 初始化View 属性设置  初始状态等等
     */
    @Override
    protected void initDataAndLoadData() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        hashMap.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        hashMap.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        hashMap.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        for (String name : hashMap.keySet()) {
            // DefaultSliderView sliderView = new DefaultSliderView(this);
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(hashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(ABoutActivity.this);

            //add your extra information 点击图片时可用到
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
//            slider.addSlider(textSliderView);
            slider.addSlider(textSliderView);
        }

        // 设置默认过渡效果(可在xml中设置)
        //mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        // 设置默认指示器位置(默认指示器白色,位置在sliderlayout底部)
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        // 设置自定义指示器(位置自定义)
        slider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
        // 设置TextView自定义动画
        slider.setCustomAnimation(new DescriptionAnimation());
        //mDemoSlider2.setCustomAnimation(new ChildAnimationExample()); // 多种效果，进入该类修改，参考效果github/daimajia/AndroidViewAnimations
        // 设置持续时间
        slider.setDuration(2000);
//        slider.addOnPageChangeListener(this);


    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }


        toolbar.setTitle("图片展示页面");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAlertDialogUtil.myAlertDialog(ABoutActivity.this, "标题", "确定退出吗?");
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
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
                        MyToast.showToast2(getApplication(), "关于");
//                        Intent intent = new Intent();
//                        intent.setClass(ABoutActivity.this, ABoutActivity.class);
//                        startActivity(intent);
                        break;
                }
                return true;
            }
        });


        //创建一个布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        //滑动方向
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        //设置布局管理器
        rcView.setLayoutManager(gridLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rcView.setHasFixedSize(true);
        rcView.setNestedScrollingEnabled(false);
//        recyGridViewAdapter = new RecyGridViewAndCardViewAdapter(RecyclerGridviewAndCardViewActivity.this, list);
////        rv_recylerViewTrainingProgram.addItemDecoration(new MyItemDecoration());
//        rcView.setAdapter(recyGridViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.zhihu_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public ABoutPersenter getPersenter() {
        return new ABoutPersenter(mActivity, this);
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
//        Toast.makeText(this, "" + slider.getBundle().get("extra"), Toast.LENGTH_SHORT).show();
    }

    /**
     * 数据返回方法
     *
     * @param aboutEntity
     */
    @Override
    public void getResult(AboutEntity aboutEntity) {
        MyToast.showToast(mActivity, "数据返回" + aboutEntity.getStories().get(0).getTitle());
        aboutAdapter = new AboutAdapter(aboutEntity, mActivity);
        rcView.setAdapter(aboutAdapter);
    }


    //    http://news-at.zhihu.com/api/4/news/latest

}
