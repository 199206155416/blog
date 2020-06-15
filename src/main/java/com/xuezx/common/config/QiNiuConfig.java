package com.xuezx.common.config;

import com.qiniu.util.Auth;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 七牛云配置
 *
 * @author Edwin.Wu edwin.wu05@gmail.com
 * @version 2019-04-17 10:43
 * @since JDK1.8
 */
@Component
public class QiNiuConfig {

    @Value("${qiniu.public.access-key}")
    public String QI_NIU_ACCESS_KEY;

    @Value("${qiniu.public.secret-key}")
    public String QI_NIU_SECRET_KEY;


    /**
     * 七牛社区图片视频日志-资源文件目录名
     */
    @Value("${qiniu.public.bucket}")
    public String QI_NIU_BUCKET;

    /**
     * 七牛云社区存储地址
     */
    @Value("${qiniu.public.url}")
    public String QI_NIU_PUBLIC_URL;


    @Value("${qiniu.public.boss.url}")
    public String QI_NIU_PUBLIC_BOSS_URL;

    /**
     * 获取七牛上传图片、视频的token
     *
     * @param bucket  文件夹
     * @param fileKey 覆盖操作，一般都可以为null
     * @return
     */
    public String getPublicToken(@NotNull String bucket, @NotNull String fileKey) {
        System.out.println("QI_NIU_PUBLIC_BOSS_URL=" + QI_NIU_PUBLIC_BOSS_URL);

        Auth auth = Auth.create(QI_NIU_ACCESS_KEY, QI_NIU_SECRET_KEY);
        return auth.uploadToken(bucket, fileKey);
    }

}

