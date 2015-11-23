/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avid.central.obsplugin.Configuration;

import com.avid.central.obsplugin.inewslibrary.nsml.Nsml;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.axis.encoding.Base64;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Administrator
 */
@JsonIgnoreProperties({"encryptedPasswords"})
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
    public String onc_prefix;
    public Boolean onc_verify_fields;
    public Boolean onc_check_graphics;
    public Boolean onc_include_tags;

    //    MDS FTP Configuration
    public String mds_ftp_srvr;
    public int mds_ftp_port;
    public String mds_ftp_login;
    public String mds_ftp_pwd;
    public String mds_ftp_path;
    public String mds_prefix;
    public Boolean mds_verify_fields;
    public Boolean mds_check_graphics;
    public Boolean mds_include_tags;

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

    public boolean encryptedPasswords;

    @XmlTransient
    private long _lastModifiedTime = 0;

    private final String Key = "C0E7D964-7C4E-4658-9882-2DB2822F2A31";
    private final String IV = "198DC056DE264408";

    public ExportConfiguration() {
    }

    private ExportConfiguration Clone() {
        ExportConfiguration config = new ExportConfiguration();

        config.id = this.id;

        //    iNEWS Configuration
        config.inws_ws_srvr = this.inws_ws_srvr;
        config.inws_ws_port = inws_ws_port;
        config.inws_server = this.inws_server;
        config.inws_login = this.inws_login;

        config.inws_pwd = this.inws_pwd;

        //    Interplay Configuration
        config.iplay_ws_srvr = this.iplay_ws_srvr;
        config.iplay_ws_port = iplay_ws_port;
        config.iplay_workgroup = this.iplay_workgroup;
        config.iplay_login = this.iplay_login;
        config.iplay_pwd = this.iplay_pwd;

        //    ONC FTP Configuration
        config.onc_ftp_srvr = this.onc_ftp_srvr;
        config.onc_ftp_port = onc_ftp_port;
        config.onc_ftp_login = this.onc_ftp_login;
        config.onc_ftp_pwd = this.onc_ftp_pwd;
        config.onc_ftp_path = this.onc_ftp_path;
        config.onc_prefix = this.onc_prefix;
        config.onc_verify_fields = this.onc_verify_fields;
        config.onc_check_graphics = this.onc_check_graphics;
        config.onc_include_tags = this.onc_include_tags;

        //    MDS FTP Configuration
        config.mds_ftp_srvr = this.mds_ftp_srvr;
        config.mds_ftp_port = mds_ftp_port;
        config.mds_ftp_login = this.mds_ftp_login;
        config.mds_ftp_pwd = this.mds_ftp_pwd;
        config.mds_ftp_path = this.mds_ftp_path;
        config.mds_prefix = this.mds_prefix;
        config.mds_verify_fields = this.mds_verify_fields;
        config.mds_check_graphics = this.mds_check_graphics;
        config.mds_include_tags = this.mds_include_tags;

        //    Authorisation Definitions
        config.obs_export_role = this.obs_export_role;
        config.obs_cuesheet_role = this.obs_cuesheet_role;

        //    XML Definitions
        config.obs_channel_id = this.obs_channel_id;
        config.title_id = this.title_id;
        config.date_id = this.date_id;
        config.day_id = this.day_id;
        config.viz_id = this.viz_id;
        config.cuesheet_id = this.cuesheet_id;

        //    Field Definitions
        config.duration_field = this.duration_field;
        config.info_field = this.info_field;
        config.modified_field = this.modified_field;
        config.music_field = this.music_field;
        config.start_time_field = this.start_time_field;
        config.story_id_field = this.story_id_field;
        config.subject_field = this.subject_field;
        config.type_field = this.type_field;
        config.update_field = this.update_field;
        config.upmix_field = this.upmix_field;
        config.video_id_field = this.video_id_field;

        config.encryptedPasswords = encryptedPasswords;

        config._lastModifiedTime = _lastModifiedTime;
        return config;
    }

    public void setLastModificationTime(long lastModificationTime) {
        _lastModifiedTime = lastModificationTime;
    }

    public void encryptPasswords() {
        encryptedPasswords = false;
        try {
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes("UTF-8"));

            Cipher encode = Cipher.getInstance("AES/CBC/PKCS5Padding");

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte encodeKey[] = md.digest(Key.getBytes("UTF-8"));
            encodeKey = Arrays.copyOf(encodeKey, 16);

            SecretKeySpec encodeSpec = new SecretKeySpec(encodeKey, "AES");
            encode.init(Cipher.ENCRYPT_MODE, encodeSpec, ivspec);

            byte[] result = encode.doFinal(inws_pwd.getBytes());
            String inews_password = DatatypeConverter.printBase64Binary(result);
            result = encode.doFinal(iplay_pwd.getBytes());
            String interplay_password = DatatypeConverter.printBase64Binary(result);
            result = encode.doFinal(onc_ftp_pwd.getBytes());
            String onc_ftp_password = DatatypeConverter.printBase64Binary(result);
            result = encode.doFinal(mds_ftp_pwd.getBytes());
            String mds_ftp_password = DatatypeConverter.printBase64Binary(result);

            inws_pwd = inews_password;
            iplay_pwd = interplay_password;
            onc_ftp_pwd = onc_ftp_password;
            mds_ftp_pwd = mds_ftp_password;

            encryptedPasswords = true;
        } catch (Exception ex) {
        }
    }

    public void decryptPasswords() {
        try {
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes("UTF-8"));

            Cipher decode = Cipher.getInstance("AES/CBC/PKCS5Padding");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte decodeKey[] = md.digest(Key.getBytes("UTF-8"));
            decodeKey = Arrays.copyOf(decodeKey, 16);

            SecretKeySpec decodeSpec = new SecretKeySpec(decodeKey, "AES");
            decode.init(Cipher.DECRYPT_MODE, decodeSpec, ivspec);



            inws_pwd = new String(decode.doFinal(DatatypeConverter.parseBase64Binary(inws_pwd)), "UTF-8");
            iplay_pwd = new String(decode.doFinal(DatatypeConverter.parseBase64Binary(iplay_pwd)), "UTF-8");
            onc_ftp_pwd = new String(decode.doFinal(DatatypeConverter.parseBase64Binary(onc_ftp_pwd)), "UTF-8");
            mds_ftp_pwd = new String(decode.doFinal(DatatypeConverter.parseBase64Binary(mds_ftp_pwd)), "UTF-8");

        } catch (Exception ex) {
            String msg = ex.getMessage();

        }
    }

    public void ReloadIfChanged() {
        try {
            File configFile = new File(GetFileName());
            long lastModifiedTime = configFile.lastModified();
            if (lastModifiedTime > _lastModifiedTime) {
                // config has changed
                // create the deserialization object
                JAXBContext jc;
                Unmarshaller unmarshaller;
                jc = JAXBContext.newInstance(ExportConfiguration.class);
                unmarshaller = jc.createUnmarshaller();

                ExportConfiguration configuration = (ExportConfiguration) unmarshaller.unmarshal(configFile);
                if (configuration.encryptedPasswords) {
                    configuration.decryptPasswords();
                }

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
                this.onc_ftp_login = configuration.onc_ftp_login;
                this.onc_ftp_pwd = configuration.onc_ftp_pwd;
                this.onc_ftp_path = configuration.onc_ftp_path;
                this.onc_prefix = configuration.onc_prefix;
                this.onc_verify_fields = configuration.onc_verify_fields;
                this.onc_check_graphics = configuration.onc_check_graphics;
                this.onc_include_tags = configuration.onc_include_tags;

                //    MDS FTP COnfiguration
                this.mds_ftp_srvr = configuration.mds_ftp_srvr;
                this.mds_ftp_port = configuration.mds_ftp_port;
                this.mds_ftp_login = configuration.mds_ftp_login;
                this.mds_ftp_pwd = configuration.mds_ftp_pwd;
                this.mds_ftp_path = configuration.mds_ftp_path;
                this.mds_prefix = configuration.mds_prefix;
                this.mds_verify_fields = configuration.mds_verify_fields;
                this.mds_check_graphics = configuration.mds_check_graphics;
                this.mds_include_tags = configuration.mds_include_tags;

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

                _lastModifiedTime = lastModifiedTime;

            }
        } catch (Exception ex) {

        }
    }

    public void Save() throws Exception {
        ExportConfiguration config = this.Clone();
        config.encryptPasswords();
        config.saveConfiguration();
    }

    public void saveConfiguration() throws Exception {
        // create the serialization object
        JAXBContext jc;
        Marshaller marshaller;
        jc = JAXBContext.newInstance(ExportConfiguration.class);
        marshaller = jc.createMarshaller();

        try {
            CreateDirectory();
        } catch (UnsupportedOperationException | IOException | SecurityException ex) {
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

        if (configuration.encryptedPasswords) {
            configuration.decryptPasswords();
        }

        return configuration;
    }

    private static void CreateDirectory() throws UnsupportedOperationException, IOException, SecurityException {
        String sep = System.getProperty("file.separator");
        try {
            if (sep.equals("\\")) {
                File configDirectory = new File("D:/obs_settings");
                Files.createDirectory(configDirectory.toPath());
            } else {
                File configDirectory = new File("/opt/avid/avid-interplay-central/plugins/obs/settings");
                Files.createDirectory(configDirectory.toPath());
            }
        } catch (FileAlreadyExistsException fx) {
        }
    }

    private static String GetFileName() {
        String sep = System.getProperty("file.separator");
        if (sep.equals("\\")) {
            return "D:/obs_settings/obsconfig.xml";
        }

        return "/opt/avid/avid-interplay-central/plugins/obs/settings/obsconfig.xml";
    }

}
