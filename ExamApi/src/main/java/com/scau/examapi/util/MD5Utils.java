/*
 * Copyright (c) 2018, LinshowTime  All Rights Reserved.
 */

package com.scau.examapi.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * MD5加密解密工具类
 *
 * @author showtime
 * @version V1.0
 * @date 2019/1/24 23:24
 */
public class MD5Utils {
    public static String getMD5Code(String content) {
        return Hashing.md5().newHasher().putString(content, Charsets.UTF_8).hash().toString();
    }
}
