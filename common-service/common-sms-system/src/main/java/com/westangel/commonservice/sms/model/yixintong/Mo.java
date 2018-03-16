package com.westangel.commonservice.sms.model.yixintong;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: Mo 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author yzq 
 * @date Jul 17, 2015 4:43:07 PM
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Mo {
    
    @XmlAttribute
    private String num;

    @XmlElement(name="Item")
    private List<Item>  Items;
    
    public Mo() {
    }
    
    public Mo(String num) {
	this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    @Override
    public String toString() {
	return "Mo [num=" + num + ", Items=" + Items + "]";
    }
    
}
