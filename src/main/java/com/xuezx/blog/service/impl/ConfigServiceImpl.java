package com.xuezx.blog.service.impl;

import com.alibaba.druid.util.Utils;
import com.xuezx.blog.result.UploadTokenResult;
import com.xuezx.blog.service.ConfigService;
import com.xuezx.common.config.QiNiuConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private QiNiuConfig qiNiuConfig;

    private final Logger logger = LoggerFactory.getLogger(ConfigServiceImpl.class);

    @Override
    public UploadTokenResult getUploadToken(Integer fileNameNumber) {
        UploadTokenResult result = new UploadTokenResult();
        String bucket = qiNiuConfig.QI_NIU_BUCKET;
        String qiNiuUrl = qiNiuConfig.QI_NIU_PUBLIC_BOSS_URL;

        if (fileNameNumber > 0) {
            String[] fileNames = new String[fileNameNumber];
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i] =  Utils.md5(UUID.randomUUID().toString());
            }
            result.setFileNames(fileNames);
        } else {
            result.setFileName(Utils.md5(UUID.randomUUID().toString()));
        }

        String publicToken = "";
        publicToken = qiNiuConfig.getPublicToken(bucket, null);
        logger.info("[common-uploadToken]  publicToken = " + publicToken);
        result.setToken(publicToken);
        result.setQiNiuUrl(qiNiuUrl);
        return result;
    }
}
