package com.epes.demo.service;

import com.epes.demo.dao.WorkLogDao;
import com.epes.demo.entity.WorkLog;
import com.epes.demo.tool.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 * Date: 2018/4/17
 * Time: 16:04
 *
 * @Author lixingjie
 * @Modifice
 */

@Service
public class WorkLogService {

    private final BaseService baseService;
    private final WorkLogDao workLogDao;

    @Autowired
    public WorkLogService(BaseService baseService, WorkLogDao workLogDao) {
        this.baseService = baseService;
        this.workLogDao = workLogDao;
    }

    public Map<String, String> addWorkLog(List<WorkLog> workLogs){
        for (WorkLog workLog : workLogs) {
            workLog.setId(UUID.randomUUID().toString());
            baseService.insert(workLog);
        }
        return null;
    }

    public Map<String, String> update(WorkLog workLog){
        baseService.updata(workLog);
        return null;
    }

    public Map<String, String> delete(String id){
        baseService.delete(WorkLog.class, id);
        return null;
    }

    public List<Map<String, Object>> findAllByPage(PageRequest pageRequest, SearchParams searchParams){
        return baseService.pageFindByCondition(WorkLog.class, pageRequest, searchParams);
    }

    public WorkLog findById(String id){
        return workLogDao.findLog(id);
    }
}
