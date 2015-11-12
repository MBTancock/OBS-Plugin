
package com.avid.central.obsplugin.inewslibrary.inewsstory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the inewsstory package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnlockStory_QNAME = new QName("http://avid.com/inewsstory/types", "UnlockStory");
    private final static QName _SaveStory_QNAME = new QName("http://avid.com/inewsstory/types", "SaveStory");
    private final static QName _SaveStoryResponse_QNAME = new QName("http://avid.com/inewsstory/types", "SaveStoryResponse");
    private final static QName _DeleteStory_QNAME = new QName("http://avid.com/inewsstory/types", "DeleteStory");
    private final static QName _LockStoryResponse_QNAME = new QName("http://avid.com/inewsstory/types", "LockStoryResponse");
    private final static QName _LockStory_QNAME = new QName("http://avid.com/inewsstory/types", "LockStory");
    private final static QName _DeleteStoryResponse_QNAME = new QName("http://avid.com/inewsstory/types", "DeleteStoryResponse");
    private final static QName _UnlockStoryResponse_QNAME = new QName("http://avid.com/inewsstory/types", "UnlockStoryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: inewsstory
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LockStoryType }
     * 
     */
    public LockStoryType createLockStoryType() {
        return new LockStoryType();
    }

    /**
     * Create an instance of {@link DeleteStoryFaultType }
     * 
     */
    public DeleteStoryFaultType createDeleteStoryFaultType() {
        return new DeleteStoryFaultType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link SaveStoryResponseType }
     * 
     */
    public SaveStoryResponseType createSaveStoryResponseType() {
        return new SaveStoryResponseType();
    }

    /**
     * Create an instance of {@link LockStoryResponseType }
     * 
     */
    public LockStoryResponseType createLockStoryResponseType() {
        return new LockStoryResponseType();
    }

    /**
     * Create an instance of {@link UnlockStoryType }
     * 
     */
    public UnlockStoryType createUnlockStoryType() {
        return new UnlockStoryType();
    }

    /**
     * Create an instance of {@link DeleteStoryType }
     * 
     */
    public DeleteStoryType createDeleteStoryType() {
        return new DeleteStoryType();
    }

    /**
     * Create an instance of {@link LockStoryFaultType }
     * 
     */
    public LockStoryFaultType createLockStoryFaultType() {
        return new LockStoryFaultType();
    }

    /**
     * Create an instance of {@link SaveStoryType }
     * 
     */
    public SaveStoryType createSaveStoryType() {
        return new SaveStoryType();
    }

    /**
     * Create an instance of {@link UnlockStoryResponseType }
     * 
     */
    public UnlockStoryResponseType createUnlockStoryResponseType() {
        return new UnlockStoryResponseType();
    }

    /**
     * Create an instance of {@link SaveStoryFaultType }
     * 
     */
    public SaveStoryFaultType createSaveStoryFaultType() {
        return new SaveStoryFaultType();
    }

    /**
     * Create an instance of {@link DeleteStoryResponseType }
     * 
     */
    public DeleteStoryResponseType createDeleteStoryResponseType() {
        return new DeleteStoryResponseType();
    }

    /**
     * Create an instance of {@link StoryType }
     * 
     */
    public StoryType createStoryType() {
        return new StoryType();
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "SaveStory")
    public JAXBElement<SaveStoryType> createSaveStory(SaveStoryType value) {
        return new JAXBElement<SaveStoryType>(_SaveStory_QNAME, SaveStoryType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "SaveStoryResponse")
    public JAXBElement<SaveStoryResponseType> createSaveStoryResponse(SaveStoryResponseType value) {
        return new JAXBElement<SaveStoryResponseType>(_SaveStoryResponse_QNAME, SaveStoryResponseType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "DeleteStory")
    public JAXBElement<DeleteStoryType> createDeleteStory(DeleteStoryType value) {
        return new JAXBElement<DeleteStoryType>(_DeleteStory_QNAME, DeleteStoryType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "LockStoryResponse")
    public JAXBElement<LockStoryResponseType> createLockStoryResponse(LockStoryResponseType value) {
        return new JAXBElement<LockStoryResponseType>(_LockStoryResponse_QNAME, LockStoryResponseType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LockStoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "LockStory")
    public JAXBElement<LockStoryType> createLockStory(LockStoryType value) {
        return new JAXBElement<LockStoryType>(_LockStory_QNAME, LockStoryType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "DeleteStoryResponse")
    public JAXBElement<DeleteStoryResponseType> createDeleteStoryResponse(DeleteStoryResponseType value) {
        return new JAXBElement<DeleteStoryResponseType>(_DeleteStoryResponse_QNAME, DeleteStoryResponseType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnlockStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsstory/types", name = "UnlockStoryResponse")
    public JAXBElement<UnlockStoryResponseType> createUnlockStoryResponse(UnlockStoryResponseType value) {
        return new JAXBElement<UnlockStoryResponseType>(_UnlockStoryResponse_QNAME, UnlockStoryResponseType.class, null, value);
    }


}
