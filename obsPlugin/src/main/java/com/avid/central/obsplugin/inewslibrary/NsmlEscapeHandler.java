package com.avid.central.obsplugin.inewslibrary;

/**
 * Created by Broadcast Media Solutions on 30/11/2015.
 */

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import java.io.IOException;
import java.io.Writer;

public class NsmlEscapeHandler implements CharacterEscapeHandler {
    public void escape(char[] buf, int start, int len, boolean isAttValue, Writer out) throws IOException {
        for (int i = start; i < start + len; i++) {
            char ch = buf[i];
/*
            if (ch == '&') {
                out.write("&amp;");
                continue;
            }

            if (ch == '"' && isAttValue) {
                out.write("&quot;");
                continue;
            }
            if (ch == '\'' && isAttValue) {
                out.write("&apos;");
                continue;
            }

            // you should handle other characters like < or >
            // ...

            if (ch > 0x7F) {
                // escape everything above ASCII to &#xXXXX;
                out.write("&#x");
                out.write(Integer.toHexString(ch));
                out.write(";");
                continue;
            }
            */
            // otherwise print normally
            out.write(ch);
        }
    }
}
