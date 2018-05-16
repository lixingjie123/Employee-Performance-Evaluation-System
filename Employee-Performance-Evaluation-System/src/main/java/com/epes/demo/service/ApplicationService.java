package com.epes.demo.service;

import com.epes.demo.dao.ApplicationDao;
import com.epes.demo.entity.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Date: 2018/5/4
 * Time: 10:32
 *
 * @Author lixingjie
 * @Modifice
 */

@Service
public class ApplicationService {

    private final BaseService baseService;
    private final ApplicationDao applicationDao;

    @Autowired
    public ApplicationService(BaseService baseService, ApplicationDao applicationDao) {
        this.baseService = baseService;
        this.applicationDao = applicationDao;
    }

    public Application findAppById(String id){
       return applicationDao.findAppById(id);
   }
}
