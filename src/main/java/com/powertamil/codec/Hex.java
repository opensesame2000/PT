/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   26-05-2018
 */
package com.powertamil.codec;

import java.nio.charset.Charset;

import com.powertamil.exception.DecoderException;
import com.powertamil.exception.EncoderException;

/* Converts hexadecimal Strings, to and from.
 * NOTE : Two Hex characters represent one byte.
 */

public class Hex {

    public static final Charset DEFAULT_CHARSET = Charset.defaultCharset();

    private static final char[] HEXDIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F'};

    private final Charset charset;

    public Hex() {
        this.charset = DEFAULT_CHARSET;
    }

    /*
     * decodeHex takes in an HexBinaryString and return a byte array
     *
     * @param data A String containing hexadecimal digits
     *
     * @return A byte array containing binary data decoded from the supplied
     * HexString.
     *
     * @throws DecoderException Thrown if an odd number or illegal of characters is
     * supplied
     */
    public static byte[] decodeHex(final String hexstr) throws DecoderException {
        return decodeHex(hexstr.toCharArray());
    }

    /**
     * decodeHex Converts an array of characters - each char representing a
     * hexadecimal value - into an array of bytes of those same values.
     *
     * @param hexdata An array of characters containing UPPERCASE hexadecimal digits
     * @return A byte array containing binary data decoded from the supplied char
     * array.
     * @throws DecoderException Thrown if an odd number or illegal of characters is supplied
     */
    public static byte[] decodeHex(final char[] hexdata) throws DecoderException {
        final int len = hexdata.length;
        if ((len & 0x01) != 0) {
            throw new DecoderException("Odd number of characters in input char array...!");
        }
        final byte[] out = new byte[len >> 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(hexdata[j], j) << 4;
            j++;
            f = f | toDigit(hexdata[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

    /**
     * encodeHex takes in a byte Array and returns array of Hex Digits
     *
     * @param data a byte[] to convert to Hex characters
     * @return A char[] containing the appropriate characters from the alphabet. For
     * correct encoding, this should be UPPER CASE hex.
     * @throws EncoderException invalid data, characters outside of the expected range
     */
    public static char[] encodeHex(final byte[] data) throws EncoderException {
        final int l = data.length;
        if (l == 0 || data.equals(null)) {
            throw new EncoderException("Null or Invalid Byte array supplied...!");
        }
        final char[] out = new char[l << 1];
        // Two characters form the Hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = HEXDIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = HEXDIGITS[0x0F & data[i]];
        }
        return out;
    }

    /**
     * Converts an array of bytes into a String representing the hexadecimal values
     * of each byte in order.
     *
     * @param data a byte[] to convert to Hex characters.
     * @return A String containing upper-case hexadecimal characters.
     * @throws EncoderException Encoder Exception.
     */
    public static String encodeHexString(final byte[] data) throws EncoderException {
        return new String(encodeHex(data));
    }

    // Converts a hexadecimal character to an integer.
    protected static int toDigit(final char ch, final int index) throws DecoderException {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new DecoderException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    /**
     * Returns a string representation of the object, which includes the charset
     * name.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString() + "[charsetName=" + this.charset + "]";
    }

    // Alternate Implementations ================================
    public static byte[] hexStringToByteArray(String s) throws IllegalArgumentException {

        if (s == null || s.length() % 2 != 0)
            throw new IllegalArgumentException("HexBinary needs to be even-length or non-null: " + s);

        final char[] chars = s.toUpperCase().toCharArray();
        final int strlen = chars.length;

        byte[] data = new byte[strlen / 2];

        for (int i = 0; i < strlen; i += 2) {
            int h = hexToBin(s.charAt(i));
            int l = hexToBin(s.charAt(i + 1));
            if (h == -1 || l == -1) {
                throw new IllegalArgumentException("Input String has illegal character for hexBinary: " + s);
            }
            data[i / 2] = (byte) (h * 16 + l);
        }
        return data;
    }

    private static int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        if ('A' <= ch && ch <= 'F')
            return ch - 'A' + 10;
        if ('a' <= ch && ch <= 'f')
            return ch - 'a' + 10;
        return -1;
    }

    public String printHexBinary(byte[] data) {
        final char[] hexCode = "0123456789ABCDEF".toCharArray();
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

}
