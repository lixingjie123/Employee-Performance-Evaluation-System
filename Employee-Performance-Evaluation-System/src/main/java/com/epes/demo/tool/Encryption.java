package com.epes.demo.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.sun.org.apache.bcel.internal.classfile.Utility.toHexString;

/**
 * 提供用户密码加密保护
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 10:17
 */
public class Encryption {

    /**
     * 字符串按照MD5加密
     * @param src
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encoderByMd5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(src.getBytes());
        return md.digest();
    }

    /**
     * 字符串按照SHA1加密
     *
     * @param src
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encoderBySha1(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(src.getBytes());
        return md.digest();
    }

    /**
     * 自定义加密摘要算法
     *
     * @param src
     * @return 16进制字符串
     * @throws NoSuchAlgorithmException
     */
    public static String encoder(String src, String algorithm) throws NoSuchAlgorithmException {

        try {
            MessageDigest md  = MessageDigest.getInstance(algorithm);
            md.update(src.getBytes());
            String afterHexSrc = toHexString(md.digest());
            return afterHexSrc.replaceAll(" ","");
        } catch (NoSuchAlgorithmException  e) {
           throw new NoSuchAlgorithmException(algorithm+" not algorithm found");
        }
    }
}
