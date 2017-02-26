package com.zzq.zzqbottonnavigation_master.v;

import com.zzq.zzqbottonnavigation_master.base.IView;
import com.zzq.zzqbottonnavigation_master.entity.AboutEntity;
import com.zzq.zzqbottonnavigation_master.p.IPersenter;

/**
 * Created by 志强 on 2017.2.15.
 */

public interface ABoutContract {
    interface View extends IView {
        void getResult(AboutEntity aboutEntity);
    }

    interface Persenter extends IPersenter {
        void getAboutResult();
    }
}
