package com.lyz.osp.finance.entity.xml.base;

import com.lyz.osp.finance.entity.xml.*;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({
        AcquireProjListReq.class, AcquireProjDetailReq.class, ValidateProjReq.class,
        JsProvider.class,
        PrjRecords.class
})
public class Body {
}
