
package com.avid.central.obsplugin.inewslibrary.inewsstory;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SectionLockEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SectionLockEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BODY"/>
 *     &lt;enumeration value="FORM"/>
 *     &lt;enumeration value="ALL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SectionLockEnum", namespace = "http://avid.com/inewsstory/types")
@XmlEnum
public enum SectionLockEnum {

    BODY,
    FORM,
    ALL;

    public String value() {
        return name();
    }

    public static SectionLockEnum fromValue(String v) {
        return valueOf(v);
    }

}
