package com.lyz.osp.finance.entity.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 文件上传参数
 */
@XmlRootElement(name = "upload_files")
public class UploadFiles {

    private List<UploadFile> uploadFile;

    @XmlElement(name = "upload_file")
    public List<UploadFile> getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(List<UploadFile> uploadFile) {
        this.uploadFile = uploadFile;
    }

    public static class UploadFile {

        private String fileName;

        private String fileStr;

        @XmlElement(name = "file_name")
        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        @XmlElement(name = "file_str")
        public String getFileStr() {
            return fileStr;
        }

        public void setFileStr(String fileStr) {
            this.fileStr = fileStr;
        }
    }
}
