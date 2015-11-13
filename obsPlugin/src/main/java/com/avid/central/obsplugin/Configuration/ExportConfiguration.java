/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Administrator
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "export_configuration")
public class ExportConfiguration {
    @XmlTransient
    public String id;

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

    //    MDS FTP Configuration
    public String mds_ftp_srvr;
    public int mds_ftp_port;
    public String mds_ftp_login;
    public String mds_ftp_pwd;
    public String mds_ftp_path;

    //    Authorisation Definitions
    public String obs_export_role;
    public String obs_cuesheet_role;

    //    XML Definitions
    public String obs_channel_id;
    public String title_id;
    public String date_id;
    public String day_id;
    public String viz_id;
    public String cuesheet_id;

    //    Field Definitions
    public String duration_field;
    public String info_field;
    public String modified_field;
    public String music_field;
    public String start_time_field;
    public String story_id_field;
    public String subject_field;
    public String type_field;
    public String update_field;
    public String upmix_field;
    public String video_id_field;

    // Script Export
    public boolean script_format;

    @XmlTransient
    private long _lastModifiedTime = 0;

    public ExportConfiguration() {
    }

    public void setLastModificationTime(long lastModificationTime)
    {
        _lastModifiedTime = lastModificationTime;
    }

    public void ReloadIfChanged()
    {
         try
        {
            File configFile = new File(GetFileName());
            long lastModifiedTime = configFile.lastModified();
            if (lastModifiedTime > _lastModifiedTime)
            {
                // config has changed
                // create the deserialization object
                JAXBContext jc;
                Unmarshaller unmarshaller;
                jc = JAXBContext.newInstance(ExportConfiguration.class);
                unmarshaller = jc.createUnmarshaller();

                ExportConfiguration configuration = (ExportConfiguration) unmarshaller.unmarshal(configFile);

                // update all the data
                this.inws_ws_srvr = configuration.inws_ws_srvr;
                this.inws_ws_port = configuration.inws_ws_port;
                this.inws_server = configuration.inws_server;
                this.inws_login = configuration.inws_login;
                this.inws_pwd = configuration.inws_pwd;

                //    Interplay Configuration
                this.iplay_ws_srvr = configuration.iplay_ws_srvr;
                this.iplay_ws_port = configuration.iplay_ws_port;
                this.iplay_workgroup = configuration.iplay_workgroup;
                this.iplay_login = configuration.iplay_login;
                this.iplay_pwd = configuration.iplay_pwd;

                //    ONC FTP Configuration
                this.onc_ftp_srvr = configuration.onc_ftp_srvr;
                this.onc_ftp_port = configuration.onc_ftp_port;
                this.onc_ftp_login= configuration.onc_ftp_login;
                this.onc_ftp_pwd = configuration.onc_ftp_pwd;
                this.onc_ftp_path = configuration.onc_ftp_path;

                //    MDS FTP COnfiguration
                this.mds_ftp_srvr = configuration.mds_ftp_srvr;
                this.mds_ftp_port = configuration.mds_ftp_port;
                this.mds_ftp_login = configuration.mds_ftp_login;
                this.mds_ftp_pwd = configuration.mds_ftp_pwd;
                this.mds_ftp_path = configuration.mds_ftp_path;

                //    Authorisation Definitions
                this.obs_export_role = configuration.obs_export_role;
                this.obs_cuesheet_role = configuration.obs_cuesheet_role;

                //    XML Definitions
                this.obs_channel_id = configuration.obs_channel_id;
                this.title_id = configuration.title_id;
                this.date_id = configuration.date_id;
                this.day_id = configuration.day_id;
                this.viz_id = configuration.viz_id;
                this.cuesheet_id = configuration.cuesheet_id;

                //    Field Definitions
                this.duration_field = configuration.duration_field;
                this.info_field = configuration.info_field;
                this.modified_field = configuration.modified_field;
                this.music_field = configuration.music_field;
                this.start_time_field = configuration.start_time_field;
                this.story_id_field = configuration.story_id_field;
                this.subject_field = configuration.subject_field;
                this.type_field = configuration.type_field;
                this.update_field = configuration.update_field;
                this.upmix_field = configuration.upmix_field;
                this.video_id_field = configuration.video_id_field;

                // Script formatting
                this.script_format = configuration.script_format;

                _lastModifiedTime = lastModifiedTime;
            }
        }
        catch (Exception ex)
        {

        }
    }

    public void Save() throws Exception {
        // create the serialization object
        JAXBContext jc;
        Marshaller marshaller;
        jc = JAXBContext.newInstance(ExportConfiguration.class);
        marshaller = jc.createMarshaller();

        try
        {
            CreateDirectory();
        }
        catch (UnsupportedOperationException | IOException | SecurityException ex)
        {
            throw new Exception(ex.getMessage());
        }

        File configFile = new File(GetFileName());
        configFile.delete();
        configFile.createNewFile();

        marshaller.marshal(this, configFile);
    }

    public static ExportConfiguration Open() throws Exception {

        // create the deserialization object
        JAXBContext jc;
        Unmarshaller unmarshaller;
        jc = JAXBContext.newInstance(ExportConfiguration.class);
        unmarshaller = jc.createUnmarshaller();

        File configFile = new File(GetFileName());
        ExportConfiguration configuration = (ExportConfiguration) unmarshaller.unmarshal(configFile);
        configuration.setLastModificationTime(configFile.lastModified());
        return configuration;
    }

    private static void CreateDirectory() throws UnsupportedOperationException, IOException, SecurityException
    {
        String sep = System.getProperty("file.separator");
        try {
            if (sep.equals("\\"))
            {
                File configDirectory = new File("D:/obs_settings");
                Files.createDirectory(configDirectory.toPath());
            }
            else {
                File configDirectory = new File("/opt/avid/avid-interplay-central/plugins/obs/settings");
                Files.createDirectory(configDirectory.toPath());
            }
        }
        catch (FileAlreadyExistsException fx) {
        }
    }

    private static String GetFileName()
    {
        String sep = System.getProperty("file.separator");
        if (sep.equals("\\"))
        {
            return "D:/obs_settings/obsconfig.xml";
        }

        return "/opt/avid/avid-interplay-central/plugins/obs/settings/obsconfig.xml";
    }

}
