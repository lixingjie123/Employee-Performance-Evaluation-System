package com.epes.demo.tool;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
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
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String DES = "DESede";

    /**
     * 字符串按照MD5加密
     * @param src
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] encoderByMd5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(MD5);

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
        MessageDigest md = MessageDigest.getInstance(SHA1);
        md.update(src.getBytes());
        return md.digest();
    }

    /**
     * 自定义加密摘要算法
     *
     * @param src
     * @param algorithm EncryPtion的静态常量
     * @return 16进制字符串
     */
    public static String encoder(String src, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md  = MessageDigest.getInstance(algorithm);
        md.update(src.getBytes());
        String afterHexSrc = toHexString(md.digest());
        return afterHexSrc.replaceAll(" ","");
    }

    /**
     * DES加密算法加密
     * @param keyStr
     * @param src
     * @return
     * @throws Exception
     */
    public static byte[] encryptDES(String keyStr, byte[] src) throws Exception{
        // 生成密钥
        SecretKey deskey = new SecretKeySpec(keyStr.getBytes(), DES);
        // 加密
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(Cipher.ENCRYPT_MODE, deskey);
        return c1.doFinal(src);
    }


    /**
     * DES加密算法解密
     * @param keyStr
     * @param src
     * @return
     * @throws Exception
     */
    public static byte[] decryptDES(String keyStr, byte[] src) throws Exception {
        SecretKey deskey = new SecretKeySpec(keyStr.getBytes(), DES);
        // 解密
        Cipher c1 = Cipher.getInstance("DESede");
        c1.init(Cipher.DECRYPT_MODE, deskey);
        return c1.doFinal(src);
    }

    /**
     * 将byte转换成六进制字符串
     */
        public static String ToHexString(byte[] src){
        String afterHexSrc = toHexString(src);
        return afterHexSrc.replaceAll(" ","");
    }
}
