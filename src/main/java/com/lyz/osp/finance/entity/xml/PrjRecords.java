package com.lyz.osp.finance.entity.xml;

import com.lyz.osp.finance.entity.xml.base.Body;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 项目列表具体
 */
@Data
@XmlRootElement(name = "prj_records")
@XmlAccessorType(value = XmlAccessType.FIELD )
public class PrjRecords extends Body {

    @XmlElement(name = "prj_record")
    private List<PrjRecord> prjRecord;
}
