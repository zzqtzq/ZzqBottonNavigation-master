package com.zzq.zzqbottonnavigation_master.p;

import android.app.Activity;

import com.zzq.zzqbottonnavigation_master.api.RxResultHelper;
import com.zzq.zzqbottonnavigation_master.api.netUtils.SchedulersCompat;
import com.zzq.zzqbottonnavigation_master.entity.AboutEntity;
import com.zzq.zzqbottonnavigation_master.utils.MyToast;
import com.zzq.zzqbottonnavigation_master.v.ABoutContract;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by 志强 on 2017.2.14.
 */

public class ABoutPersenter extends IBasePersenter<ABoutContract.View> implements ABoutContract.Persenter {

    public ABoutPersenter(Activity mActivity, ABoutContract.View view) {
        super(mActivity, view);
    }


    @Override
    public void getAboutResult() {
        showLoading();
        Subscription subscription = mHttpApi.getRetureResult()
                .compose(SchedulersCompat.applyIoSchedulers())
                .compose(RxResultHelper.handleResult()).subscribe(new Action1<AboutEntity>() {
                    @Override
                    public void call(AboutEntity aboutEntity) {
                        LoadingDiaogDismiss();
                        if (aboutEntity != null) {
                            mView.getResult(aboutEntity);
                        } else {
                            MyToast.showToast(mActivity, "数据异常");
                        }
                    }
                });

        addSubscrebe(subscription);
    }
}
