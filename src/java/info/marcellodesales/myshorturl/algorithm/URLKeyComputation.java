package info.marcellodesales.myshorturl.algorithm;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum URLKeyComputation {

    SINGLETON;

    /**
     * The base characters for the encryption
     */
    private static char[] base = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', '0', '1', '-', '_', '2', '3',
        '4', '5', '6', '7', '8', '9', 'A', 'B',
        'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * @param data is the given data.
     * @return the hexadecimal representation of the data
     */
    private static String convertToHex(byte[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int parts = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    builder.append((char) ('0' + halfbyte));
                else
                    builder.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (parts++ < 1);
        }
        return builder.toString();
    }

    /**
     * @param text is the text to be represented using the MD5 algorithm.
     * @return the MD5 representation of the given text. May return null if the compatation
     * fails.
     */
    public String md5(String text) {
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            byte[] md5hash = new byte[32];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            md5hash = md.digest();
            return convertToHex(md5hash);
        } catch (Exception e) {
            return null;
        } 
    }

    /**
     * @param url is any given URL
     * @return a String[4] containing 4 options of short URL based on the 
     * base with 64 different characters. Each of characters are in the range of
     * [0-9], [a-zA-Z], [-,_]. The probability of collision is n/2^64, where n is the
     * number of existing values already computed. (n/68,719,476,736)
     */
    public String[] computeUrlKeys(String url) {
        List<String> output = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        //An MD5 hash is typically expressed as a 32-digit hexadecimal number.
        String hex = md5(url);
        String subHex;
        //Navigate over the 4 blocks to generate 4 url keys
        for (int i = 0; i < 4; i++) {
            //Convert different blocks from the subHex
            subHex = "0x" + hex.substring(i * 8, (i * 8) + 8);
            //Make an AND operation with the Long max value
            long intv = Long.MAX_VALUE & Long.decode(subHex).intValue();
            //arrange the values based on the based 64 characters
            long val = 0;
            for (int j = 0; j < 6; j++) {
                //To get the index in the range of the base 64 (hex(63) = 0x3F)
                val = 0x3F & intv;
                builder.append(base[(int) val]);
                //Divide the number by 64 (right shift operation 2^6)
                intv = intv >> 6;
            }
            output.add(builder.toString());
            builder.delete(0, builder.length());
        }
        return output.toArray(new String[output.size()]);
    }

    public static void main(String[] args) {
        String[] values = URLKeyComputation.SINGLETON.computeUrlKeys("http://marcellodesales.wordpress.com/2010/01/10/tf-idf-in-hadoop-part-3-documents-in-corpus-and-tfidf-computation/");
        for (String string : values) {
            System.out.println(string);
            System.out.println(new Random().nextInt(3));
        }
        //"http://www.marcellos.com" = Q_XOpb, PAxKjZ, hKr7ZY, DjzFgY
        //"http://www.marcellodesales.com" = Rue4Z, CIGx9a, b1hL5a, zrX8oZ
        //http://myurl.ts/Rue4Z
    }
}
