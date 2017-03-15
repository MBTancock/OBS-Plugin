
package com.avid.central.obsplugin.interplaylibrary.infrastructure;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A list of InterplayURIs. An InterplayURI can represent a node by workgroup and path,
 *         moniker, or MOBID. An InterplayURI has the following form:
 * 
 *         Path: interplay://$WG/$PATH
 *         ex. interplay://WGA3/projects/race08/debate.jpg
 * 
 *         Moniker: interplay://$WG?moniker=$MONIKER
 *         ex. interplay://WGA3?moniker=abc123
 * 
 *         Mob ID: interplay://$WG?mobid=$MOBID
 *         ex. interplay://WGA3?mobid=060a2b340101010101010f0013-000000-0000000000000032-060e2b347f7f-2a80
 * 
 *         Source ID: interplay://$WG?sourceid=$MOBID
 *         interplay://WGA?sourceid=060a2b340101010101010f0013-000000-000000003d40ede1-060e2b347f7f-2a80
 * 
 *         Media Services Job:
 *         interplay://WGA/DMS?jobid=1260980985656.1
 * 
 *         Transfer Job:
 *         interplay://WGA/XFER?jobid=27_osi-tm
 * 
 *         User: interplay://$WG?username=$USER
 *         ex. interplay://WGA3?username=jsmith
 * 
 *         Group: interplay://$WG?group=$GROUP
 *         ex. interplay://WGA3?group=journalist
 * 
 *         Workgroup: interplay://$WG
 *         ex. interplay://WGA3
 *       
 * 
 * <p>Java class for InterplayURIListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterplayURIListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InterplayURI" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterplayURIListType", propOrder = {
    "interplayURI"
})
public class InterplayURIListType {

    @XmlElement(name = "InterplayURI")
    protected List<String> interplayURI;

    /**
     * Gets the value of the interplayURI property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interplayURI property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterplayURI().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInterplayURI() {
        if (interplayURI == null) {
            interplayURI = new ArrayList<String>();
        }
        return this.interplayURI;
    }

}
