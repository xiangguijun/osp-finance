package com.lyz.osp.finance.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 文件下载
 */
@XmlRootElement(name = "download_files")
public class FileDownloadRes {

    public static class FileDownload {
        private String fileName;

        private String fileStr;
    }
}
