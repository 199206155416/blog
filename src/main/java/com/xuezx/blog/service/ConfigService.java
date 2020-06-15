package com.xuezx.blog.service;

import com.xuezx.blog.result.UploadTokenResult;

public interface ConfigService {

    UploadTokenResult getUploadToken(Integer fileNameNumber);
}
