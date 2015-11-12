
package com.avid.central.obsplugin.inewslibrary.inewsqueue;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the inewsqueue package. 
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

    private final static QName _GetStories_QNAME = new QName("http://avid.com/inewsqueue/types", "GetStories");
    private final static QName _SetCurrentQueue_QNAME = new QName("http://avid.com/inewsqueue/types", "SetCurrentQueue");
    private final static QName _CreateStory_QNAME = new QName("http://avid.com/inewsqueue/types", "CreateStory");
    private final static QName _HasPreviousResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "HasPreviousResponse");
    private final static QName _GetQueueRecordsResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "GetQueueRecordsResponse");
    private final static QName _GetStory_QNAME = new QName("http://avid.com/inewsqueue/types", "GetStory");
    private final static QName _HasNext_QNAME = new QName("http://avid.com/inewsqueue/types", "HasNext");
    private final static QName _HasPrevious_QNAME = new QName("http://avid.com/inewsqueue/types", "HasPrevious");
    private final static QName _GetStoriesResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "GetStoriesResponse");
    private final static QName _GetAttributes_QNAME = new QName("http://avid.com/inewsqueue/types", "GetAttributes");
    private final static QName _CreateStoryResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "CreateStoryResponse");
    private final static QName _HasNextResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "HasNextResponse");
    private final static QName _GetQueueRecords_QNAME = new QName("http://avid.com/inewsqueue/types", "GetQueueRecords");
    private final static QName _GetAttributesResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "GetAttributesResponse");
    private final static QName _SetCurrentQueueResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "SetCurrentQueueResponse");
    private final static QName _GetStoryResponse_QNAME = new QName("http://avid.com/inewsqueue/types", "GetStoryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: inewsqueue
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAttributesType }
     * 
     */
    public GetAttributesType createGetAttributesType() {
        return new GetAttributesType();
    }

    /**
     * Create an instance of {@link CreateStoryFaultType }
     * 
     */
    public CreateStoryFaultType createCreateStoryFaultType() {
        return new CreateStoryFaultType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link HasPreviousType }
     * 
     */
    public HasPreviousType createHasPreviousType() {
        return new HasPreviousType();
    }

    /**
     * Create an instance of {@link HasPreviousResponseType }
     * 
     */
    public HasPreviousResponseType createHasPreviousResponseType() {
        return new HasPreviousResponseType();
    }

    /**
     * Create an instance of {@link GetStoryResponseType }
     * 
     */
    public GetStoryResponseType createGetStoryResponseType() {
        return new GetStoryResponseType();
    }

    /**
     * Create an instance of {@link GetStoriesResponseType }
     * 
     */
    public GetStoriesResponseType createGetStoriesResponseType() {
        return new GetStoriesResponseType();
    }

    /**
     * Create an instance of {@link SetCurrentQueueResponseType }
     * 
     */
    public SetCurrentQueueResponseType createSetCurrentQueueResponseType() {
        return new SetCurrentQueueResponseType();
    }

    /**
     * Create an instance of {@link GetAttributesFaultType }
     * 
     */
    public GetAttributesFaultType createGetAttributesFaultType() {
        return new GetAttributesFaultType();
    }

    /**
     * Create an instance of {@link GetAttributesResponseType }
     * 
     */
    public GetAttributesResponseType createGetAttributesResponseType() {
        return new GetAttributesResponseType();
    }

    /**
     * Create an instance of {@link CreateStoryType }
     * 
     */
    public CreateStoryType createCreateStoryType() {
        return new CreateStoryType();
    }

    /**
     * Create an instance of {@link GetQueueRecordsType }
     * 
     */
    public GetQueueRecordsType createGetQueueRecordsType() {
        return new GetQueueRecordsType();
    }

    /**
     * Create an instance of {@link SetCurrentQueueType }
     * 
     */
    public SetCurrentQueueType createSetCurrentQueueType() {
        return new SetCurrentQueueType();
    }

    /**
     * Create an instance of {@link HasNextType }
     * 
     */
    public HasNextType createHasNextType() {
        return new HasNextType();
    }

    /**
     * Create an instance of {@link HasNextFaultType }
     * 
     */
    public HasNextFaultType createHasNextFaultType() {
        return new HasNextFaultType();
    }

    /**
     * Create an instance of {@link GetStoriesFaultType }
     * 
     */
    public GetStoriesFaultType createGetStoriesFaultType() {
        return new GetStoriesFaultType();
    }

    /**
     * Create an instance of {@link GetQueueRecordsFaultType }
     * 
     */
    public GetQueueRecordsFaultType createGetQueueRecordsFaultType() {
        return new GetQueueRecordsFaultType();
    }

    /**
     * Create an instance of {@link GetStoriesType }
     * 
     */
    public GetStoriesType createGetStoriesType() {
        return new GetStoriesType();
    }

    /**
     * Create an instance of {@link GetStoryFaultType }
     * 
     */
    public GetStoryFaultType createGetStoryFaultType() {
        return new GetStoryFaultType();
    }

    /**
     * Create an instance of {@link SetCurrentQueueFaultType }
     * 
     */
    public SetCurrentQueueFaultType createSetCurrentQueueFaultType() {
        return new SetCurrentQueueFaultType();
    }

    /**
     * Create an instance of {@link HasNextResponseType }
     * 
     */
    public HasNextResponseType createHasNextResponseType() {
        return new HasNextResponseType();
    }

    /**
     * Create an instance of {@link HasPreviousFaultType }
     * 
     */
    public HasPreviousFaultType createHasPreviousFaultType() {
        return new HasPreviousFaultType();
    }

    /**
     * Create an instance of {@link CreateStoryResponseType }
     * 
     */
    public CreateStoryResponseType createCreateStoryResponseType() {
        return new CreateStoryResponseType();
    }

    /**
     * Create an instance of {@link GetStoryType }
     * 
     */
    public GetStoryType createGetStoryType() {
        return new GetStoryType();
    }

    /**
     * Create an instance of {@link GetQueueRecordsResponseType }
     * 
     */
    public GetQueueRecordsResponseType createGetQueueRecordsResponseType() {
        return new GetQueueRecordsResponseType();
    }

    /**
     * Create an instance of {@link FolderAttributesType }
     * 
     */
    public FolderAttributesType createFolderAttributesType() {
        return new FolderAttributesType();
    }

    /**
     * Create an instance of {@link QueueRecordType }
     * 
     */
    public QueueRecordType createQueueRecordType() {
        return new QueueRecordType();
    }




    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoriesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetStories")
    public JAXBElement<GetStoriesType> createGetStories(GetStoriesType value) {
        return new JAXBElement<GetStoriesType>(_GetStories_QNAME, GetStoriesType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCurrentQueueType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "SetCurrentQueue")
    public JAXBElement<SetCurrentQueueType> createSetCurrentQueue(SetCurrentQueueType value) {
        return new JAXBElement<SetCurrentQueueType>(_SetCurrentQueue_QNAME, SetCurrentQueueType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "CreateStory")
    public JAXBElement<CreateStoryType> createCreateStory(CreateStoryType value) {
        return new JAXBElement<CreateStoryType>(_CreateStory_QNAME, CreateStoryType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasPreviousResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "HasPreviousResponse")
    public JAXBElement<HasPreviousResponseType> createHasPreviousResponse(HasPreviousResponseType value) {
        return new JAXBElement<HasPreviousResponseType>(_HasPreviousResponse_QNAME, HasPreviousResponseType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQueueRecordsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetQueueRecordsResponse")
    public JAXBElement<GetQueueRecordsResponseType> createGetQueueRecordsResponse(GetQueueRecordsResponseType value) {
        return new JAXBElement<GetQueueRecordsResponseType>(_GetQueueRecordsResponse_QNAME, GetQueueRecordsResponseType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetStory")
    public JAXBElement<GetStoryType> createGetStory(GetStoryType value) {
        return new JAXBElement<GetStoryType>(_GetStory_QNAME, GetStoryType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasNextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "HasNext")
    public JAXBElement<HasNextType> createHasNext(HasNextType value) {
        return new JAXBElement<HasNextType>(_HasNext_QNAME, HasNextType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasPreviousType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "HasPrevious")
    public JAXBElement<HasPreviousType> createHasPrevious(HasPreviousType value) {
        return new JAXBElement<HasPreviousType>(_HasPrevious_QNAME, HasPreviousType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoriesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetStoriesResponse")
    public JAXBElement<GetStoriesResponseType> createGetStoriesResponse(GetStoriesResponseType value) {
        return new JAXBElement<GetStoriesResponseType>(_GetStoriesResponse_QNAME, GetStoriesResponseType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetAttributes")
    public JAXBElement<GetAttributesType> createGetAttributes(GetAttributesType value) {
        return new JAXBElement<GetAttributesType>(_GetAttributes_QNAME, GetAttributesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "CreateStoryResponse")
    public JAXBElement<CreateStoryResponseType> createCreateStoryResponse(CreateStoryResponseType value) {
        return new JAXBElement<CreateStoryResponseType>(_CreateStoryResponse_QNAME, CreateStoryResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasNextResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "HasNextResponse")
    public JAXBElement<HasNextResponseType> createHasNextResponse(HasNextResponseType value) {
        return new JAXBElement<HasNextResponseType>(_HasNextResponse_QNAME, HasNextResponseType.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQueueRecordsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetQueueRecords")
    public JAXBElement<GetQueueRecordsType> createGetQueueRecords(GetQueueRecordsType value) {
        return new JAXBElement<GetQueueRecordsType>(_GetQueueRecords_QNAME, GetQueueRecordsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAttributesResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetAttributesResponse")
    public JAXBElement<GetAttributesResponseType> createGetAttributesResponse(GetAttributesResponseType value) {
        return new JAXBElement<GetAttributesResponseType>(_GetAttributesResponse_QNAME, GetAttributesResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCurrentQueueResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "SetCurrentQueueResponse")
    public JAXBElement<SetCurrentQueueResponseType> createSetCurrentQueueResponse(SetCurrentQueueResponseType value) {
        return new JAXBElement<SetCurrentQueueResponseType>(_SetCurrentQueueResponse_QNAME, SetCurrentQueueResponseType.class, null, value);
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStoryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avid.com/inewsqueue/types", name = "GetStoryResponse")
    public JAXBElement<GetStoryResponseType> createGetStoryResponse(GetStoryResponseType value) {
        return new JAXBElement<GetStoryResponseType>(_GetStoryResponse_QNAME, GetStoryResponseType.class, null, value);
    }



}
