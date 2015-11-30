package com.sun.xml.internal.bind.marshaller;

/**
 * Created by Broadcast Media Solutions on 30/11/2015.
 */

import java.io.IOException;
import java.io.Writer;

/**
 * Performs character escaping and write the result
 * to the output.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 * @since 1.0.1
 */
public interface CharacterEscapeHandler {

    /**
     * @param ch       The array of characters.
     * @param start    The starting position.
     * @param length   The number of characters to use.
     * @param isAttVal true if this is an attribute value literal.
     */
    void escape(char ch[], int start, int length, boolean isAttVal,
                Writer out) throws IOException;
}
