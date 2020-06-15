package com.xuezx.blog.result;

public class UploadTokenResult {

    private String fileName;

    private String[] fileNames;

    private String token;

    private String qiNiuUrl;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getQiNiuUrl() {
        return qiNiuUrl;
    }

    public void setQiNiuUrl(String qiNiuUrl) {
        this.qiNiuUrl = qiNiuUrl;
    }

}
