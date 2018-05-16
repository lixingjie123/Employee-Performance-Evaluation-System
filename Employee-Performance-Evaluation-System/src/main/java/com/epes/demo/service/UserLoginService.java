package com.epes.demo.service;

import com.epes.demo.dao.UserLoginDao;
import com.epes.demo.entity.UserLogin;
import com.epes.demo.tool.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * Date: 2018/4/25
 * Time: 13:28
 *
 * @Author lixingjie
 * @Modifice
 */
@Service
public class UserLoginService {

   private final BaseService baseService;
   @Autowired
   private UserLoginDao userLoginDao;

    @Autowired
    public UserLoginService(BaseService baseService) {
        this.baseService = baseService;
    }

    /** 重置密码
     * @param id
     * @return
     */
    @Transactional
    public String resetPassword(String id){
        UserLogin userLogin = new UserLogin();
        userLogin.setId(id);
        byte[] password;
        String msg = "修改失败";
        // 获取当前修改日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userLogin.setModifiedtime("'" + df.format(new Date()) + "'");
        int i = 0;
        try {
            // 设置初始密码
            password = Encryption.encoderByMd5("12345a");
            // 录入初始密码
            userLogin.setPassword(Encryption.ToHexString(password));
            i = userLoginDao.updatePassword(userLogin);
            if (i>0){
                msg = "已重置密码";
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
