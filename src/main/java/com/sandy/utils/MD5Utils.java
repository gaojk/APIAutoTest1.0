package com.sandy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5Utils
 * @Author sandy.n.hao
 * @Date: 2019-01-17
 * @Version v1.0.0
 * @Description: //TODO
 */

public class MD5Utils {

    /**
     * 将字节数组转换为16进制字符串
     * @param byteArr
     * @return 16进制字符串
     */
    private static String byteArrToHex(byte[] byteArr) {

        // Initialize the character array, used to store each hexadecimal string
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        // Initialize a char Array, used to form the result string
        char[] resultCharArr = new char[byteArr.length*2];

        // Traverse the byte array, converted into characters in a character array
        int index = 0;
        for (byte b : byteArr) {
            resultCharArr[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArr[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArr);
    }

    public static String getStringMD5(String input){
        try {

            // get MD5 digest
            MessageDigest mDigest = MessageDigest.getInstance("MD5");

            // The input String to Byte Array
            byte[] inputArr = input.getBytes();

            // Updates the digest using the specified byte.
            mDigest.update(inputArr);

            // Completes the hash computation by performing final operations such as padding.
            // The digest is reset after this call is made.
            byte[] resultArr = mDigest.digest();

            //
            return byteArrToHex(resultArr);

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
