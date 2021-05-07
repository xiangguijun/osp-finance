/**
 * WingsoftWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.lyz.osp.finance.webservice;


/**
 *  WingsoftWebServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class WingsoftWebServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public WingsoftWebServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public WingsoftWebServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for test1 method
     * override this method for handling normal response from test1 operation
     */
    public void receiveResulttest1(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.Test1Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from test1 operation
     */
    public void receiveErrortest1(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getReXmlData method
     * override this method for handling normal response from getReXmlData operation
     */
    public void receiveResultgetReXmlData(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.GetReXmlDataResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getReXmlData operation
     */
    public void receiveErrorgetReXmlData(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sum method
     * override this method for handling normal response from sum operation
     */
    public void receiveResultsum(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.SumResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sum operation
     */
    public void receiveErrorsum(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for update method
     * override this method for handling normal response from update operation
     */
    public void receiveResultupdate(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.UpdateResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from update operation
     */
    public void receiveErrorupdate(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for downloadBinary method
     * override this method for handling normal response from downloadBinary operation
     */
    public void receiveResultdownloadBinary(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.DownloadBinaryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from downloadBinary operation
     */
    public void receiveErrordownloadBinary(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for callWeb method
     * override this method for handling normal response from callWeb operation
     */
    public void receiveResultcallWeb(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.CallWebResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from callWeb operation
     */
    public void receiveErrorcallWeb(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for upload method
     * override this method for handling normal response from upload operation
     */
    public void receiveResultupload(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.UploadResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from upload operation
     */
    public void receiveErrorupload(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for submit method
     * override this method for handling normal response from submit operation
     */
    public void receiveResultsubmit(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.SubmitResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from submit operation
     */
    public void receiveErrorsubmit(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for test method
     * override this method for handling normal response from test operation
     */
    public void receiveResulttest(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.TestResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from test operation
     */
    public void receiveErrortest(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for uploadBase64 method
     * override this method for handling normal response from uploadBase64 operation
     */
    public void receiveResultuploadBase64(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.UploadBase64Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from uploadBase64 operation
     */
    public void receiveErroruploadBase64(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for sayHello method
     * override this method for handling normal response from sayHello operation
     */
    public void receiveResultsayHello(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.SayHelloResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from sayHello operation
     */
    public void receiveErrorsayHello(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for uploadFile method
     * override this method for handling normal response from uploadFile operation
     */
    public void receiveResultuploadFile(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.UploadFileResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from uploadFile operation
     */
    public void receiveErroruploadFile(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for uploadBinary method
     * override this method for handling normal response from uploadBinary operation
     */
    public void receiveResultuploadBinary(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.UploadBinaryResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from uploadBinary operation
     */
    public void receiveErroruploadBinary(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for qxtest method
     * override this method for handling normal response from qxtest operation
     */
    public void receiveResultqxtest(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.QxtestResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from qxtest operation
     */
    public void receiveErrorqxtest(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for resubmit method
     * override this method for handling normal response from resubmit operation
     */
    public void receiveResultresubmit(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.ResubmitResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from resubmit operation
     */
    public void receiveErrorresubmit(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getFileBytes method
     * override this method for handling normal response from getFileBytes operation
     */
    public void receiveResultgetFileBytes(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.GetFileBytesResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getFileBytes operation
     */
    public void receiveErrorgetFileBytes(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for download method
     * override this method for handling normal response from download operation
     */
    public void receiveResultdownload(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.DownloadResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from download operation
     */
    public void receiveErrordownload(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for downloadFile method
     * override this method for handling normal response from downloadFile operation
     */
    public void receiveResultdownloadFile(
        com.lyz.osp.finance.webservice.WingsoftWebServiceStub.DownloadFileResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from downloadFile operation
     */
    public void receiveErrordownloadFile(java.lang.Exception e) {
    }
}
