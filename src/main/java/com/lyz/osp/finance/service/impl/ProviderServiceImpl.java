package com.lyz.osp.finance.service.impl;

import com.lyz.osp.finance.domain.ProviderInfo;
import com.lyz.osp.finance.entity.XmlResult;
import com.lyz.osp.finance.entity.xml.JsProvider;
import com.lyz.osp.finance.entity.xml.JsProviderUpdate;
import com.lyz.osp.finance.enums.FuncIdEnum;
import com.lyz.osp.finance.service.CommonService;
import com.lyz.osp.finance.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private CommonService commonService;

    @Override
    public String register(ProviderInfo providerInfo) {
        JsProvider provider = new JsProvider();
        BeanUtils.copyProperties(providerInfo, provider);

        String xmlData = CommonService.xmlData(FuncIdEnum.Register_Provider_Info.getCode(), provider);
        XmlResult xmlResult = commonService.submit(xmlData);
        // todo
        return null;
    }

    @Override
    public boolean updateInfo(ProviderInfo providerInfo) {
        JsProviderUpdate providerUpdate = new JsProviderUpdate();
        BeanUtils.copyProperties(providerInfo, providerUpdate);

        String xmlData = CommonService.xmlData(FuncIdEnum.Update_Provider_Info.getCode(), providerUpdate);
        XmlResult xmlResult = commonService.submit(xmlData);

        return false;
    }
}
