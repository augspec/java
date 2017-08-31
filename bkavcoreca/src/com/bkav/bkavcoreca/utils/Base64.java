package com.bkav.bkavcoreca.utils;

import java.io.ByteArrayOutputStream;

public class Base64 {



    /**
     * encode the input data producong a base 64 encoded byte array with the output lines be split by '\n' (64 byte rows).
     *
     * @param data data to be encoded
     * @return a byte array containing the base 64 encoded data.
     */
    public static byte[] encode(byte[] data) {
        return encode(data, true);
    }

	/**
     * encode the input data producong a base 64 encoded byte array.
     *
     * @param data the data to be encoded
     * @param splitlines whether the output lines will be split by '\n' (64 byte rows) or not.
     * @return a byte array containing the base 64 encoded data.
     */
    public static byte[] encode(byte[] data, boolean splitlines) {
		byte[] bytes = org.bouncycastle.util.encoders.Base64.encode(data);
        if (!splitlines) {
            return bytes;
        }

        // make sure we get limited lines...
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (int i = 0; i < bytes.length; i += 64) {
            if ((i + 64) < bytes.length) {
                os.write(bytes, i, 64);
                os.write('\n');
            } else {
                os.write(bytes, i, bytes.length - i);
            }
        }
        return os.toByteArray();
    }
    
    public static byte[] decode(byte[] bytes) {
        return org.bouncycastle.util.encoders.Base64.decode(bytes);
    }


}
