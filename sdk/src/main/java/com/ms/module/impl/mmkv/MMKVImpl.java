package com.ms.module.impl.mmkv;

import com.ms.module.supers.client.Modules;
import com.ms.module.supers.inter.mmkv.IMMKV;
import com.tencent.mmkv.MMKV;

public class MMKVImpl implements IMMKV {

    MMKV kv;

    public MMKVImpl() {
        // 初始化mmkv
        String rootDir = MMKV.initialize(Modules.getDataModule().getAppData().getApplication());

        System.out.println("mmkv : " + rootDir);

        kv = MMKV.defaultMMKV();

    }


    @Override
    public void put(String k, String v) {
        kv.putString(k, v);
    }

    @Override
    public String get(String k) {
        return kv.getString(k, "");
    }

    @Override
    public void removeKey(String key) {
        kv.reKey(key);
    }
}