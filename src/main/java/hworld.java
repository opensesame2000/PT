
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.powertamil.util.PTConstants;

import java.nio.charset.Charset;

public class hworld {

    protected static final Logger LOG = Logger.getLogger(hworld.class.getName());

    /**
     * This method will convert utf8 encoded bytes into a string. If
     * an UnsupportedEncodingException occurs, this method will eat it
     * and return null instead.
     *
     * @param b Presumed UTF-8 encoded byte array.
     * @param off offset into array
     * @param len length of utf-8 sequence
     * @return String made from <code>b</code> or null
     */
    public static String toString(final byte [] b, int off, int len) {
        if (b == null) {
            return null;
        }
        if (len == 0) {
            return "";
        }
        try {
            return new String(b, off, len, PTConstants.UTF8_ENCODING);
        } catch (Exception e) {
            System.err.println("UTF-8 not supported?" );
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Write a printable representation of a byte array.
     *
     * @param b byte array
     * @return string
     * @see #toStringBinary(byte[])
     */
    public static String toStringBinary(final byte [] b) {
        if (b == null)
            return "null";
        return toStringBinary(b, 0, b.length);
    }

    /**
     * Write a printable representation of a byte array. Non-printable
     * characters are hex escaped in the format \\x%02X, eg:
     * \x00 \x05 etc
     *
     * @param b array to write out
     * @param off offset to start at
     * @param len length to write
     * @return string output
     */
    public static String toStringBinary(final byte [] b, int off, int len) {
        StringBuilder result = new StringBuilder();
        for (int i = off; i < off + len ; ++i ) {
            int ch = b[i] & 0xFF;
            if ( (ch >= '0' && ch <= '9')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= 'a' && ch <= 'z')
                    || " `~!@#$%^&*()-_=+[]{}|;:'\",.<>/?".indexOf(ch) >= 0 ) {
                result.append((char)ch);
            } else {
                result.append(String.format("\\x%02X", ch));
            }
        }
        return result.toString();
    }

    public static void main (String args[]){

        char[] fraktur = Character.toChars(0xB95);

        for (char c: fraktur) {
            System.out.println("[" + c + "]");
        }

        Charset charset = Charset.defaultCharset();
        System.out.println("Default encoding: " + charset + " (Aliases: "
                + charset.aliases() + ")");
    }



}
