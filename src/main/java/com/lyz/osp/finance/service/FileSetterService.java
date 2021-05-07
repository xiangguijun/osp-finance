package com.lyz.osp.finance.service;

import java.io.File;

public interface FileSetterService {

    /**
     * 上传文件
     * @param file
     * @return file_code
     */
    String uploadFile(File file);

    /**
     * 下载文件
     * @param fileCode
     * @return
     */
    File downloadFile(String fileCode);
}
