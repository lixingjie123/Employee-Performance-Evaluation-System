package com.epes.demo;

import com.epes.demo.tool.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.apache.tomcat.util.buf.HexUtils.toHexString;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: lixingjie
 * Date: 2018-01-09
 * Time: 9:43
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncryptionTest {


    /**
     * 密码加密测试
     */
    @Test
    public void testEncryptionByMd5() throws NoSuchAlgorithmException {
        String password = "Li(2qqx)";
        String password2 = "Li(2qqx)";
        password = toHexString(Encryption.encoderByMd5(password));
        password2 = toHexString(Encryption.encoderByMd5(password2));
        System.out.println(password);
        System.out.println(password2);
        if (password.equals(password2)) {
            System.out.println("完全相等");
        }
    }

    /**
     * 密码加密测试
     */
    @Test
    public void testEncryptionBySha1() throws NoSuchAlgorithmException {
        String password = "Li(2qqx)";
        String password2 = "Li(2qqx)";
        password = toHexString(Encryption.encoderBySha1(password));
        password2 =toHexString(Encryption.encoderBySha1(password2));
        System.out.println(password);
        System.out.println(password2);
        if (password.equals(password2)) {
            System.out.println("完全一样");
        }


    }

    /**
     * 密码加密测试
     */
    @Test
    public void testEncryption() throws NoSuchAlgorithmException {
        String password = "Li(2qqx)";
        String password2 = "Li(2qqx)";
        password = Encryption.encoder(password, "md5");
        password2 = Encryption.encoder(password2, "md5");
        System.out.println(password);
        System.out.println(password2);
        if (password.equals(password2)) {
            System.out.println("完全一样");
        }

    }
}
