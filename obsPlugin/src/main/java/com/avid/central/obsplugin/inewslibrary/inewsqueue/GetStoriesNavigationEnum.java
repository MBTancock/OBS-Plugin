
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetStoriesNavigationEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GetStoriesNavigationEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NEXT"/>
 *     &lt;enumeration value="PREV"/>
 *     &lt;enumeration value="SAME"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GetStoriesNavigationEnum", namespace = "http://avid.com/inewsqueue/types")
@XmlEnum
public enum GetStoriesNavigationEnum {

    NEXT,
    PREV,
    SAME;

    public String value() {
        return name();
    }

    public static GetStoriesNavigationEnum fromValue(String v) {
        return valueOf(v);
    }

}
