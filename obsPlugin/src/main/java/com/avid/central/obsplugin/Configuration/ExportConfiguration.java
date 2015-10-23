/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "export_configuration")
public class ExportConfiguration {

    //    iNEWS Configuration
    public String inws_ws_srvr;
    public int inws_ws_port;
    public String inws_server;
    public String inws_login;
    public String inws_pwd;

    //    Interplay Configuration
    public String iplay_ws_srvr;
    public int iplay_ws_port;
    public String iplay_workgroup;
    public String iplay_login;
    public String iplay_pwd;

    //    ONC FTP Configuration
    public String onc_ftp_srvr;
    public int onc_ftp_port;
    public String onc_ftp_login;
    public String onc_ftp_pwd;
    public String onc_ftp_path;

    //    MDS FTP COnfiguration
    public String mds_ftp_srvr;
    public int mds_ftp_port;
    public String mds_ftp_login;
    public String mds_ftp_pwd;
    public String mds_ftp_path;

    //    XML Definitions
    public String obs_channel_id;
    public String name_id;
    public String date_id;
    public String day_id;

    //    Field Definitions
    public String start_time_field;
    public String duration_field;
    public String type_field;
    public String subject_field;
    public String info_field;
    public String video_id_field;
    public String story_id_field;
    public String event_feed_field;
    public String upmix_field;
    public String com_en_field;
    public String com_es_field;
    public String com_ar_field;
    public String runup_field;
    public String rundown_field;
    public String coverage_start_field;
    public String coverage_end_field;

    public ExportConfiguration() {
    }

    public void Save(String filePath) throws Exception {
        // create the serialization object
        JAXBContext jc;
        Marshaller marshaller;
        jc = JAXBContext.newInstance(ExportConfiguration.class);
        marshaller = jc.createMarshaller();

        File configFile = new File(filePath);
        configFile.delete();
        configFile.createNewFile();

        marshaller.marshal(this, configFile);
    }

    public static ExportConfiguration Open(String filePath) throws Exception {

        // create the deserialization object
        JAXBContext jc;
        Unmarshaller unmarshaller;
        jc = JAXBContext.newInstance(ExportConfiguration.class);
        unmarshaller = jc.createUnmarshaller();

        File configFile = new File(filePath);

        return (ExportConfiguration) unmarshaller.unmarshal(configFile);
    }

}
