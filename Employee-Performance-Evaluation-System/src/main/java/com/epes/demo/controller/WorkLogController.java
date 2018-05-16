package com.epes.demo.controller;

import com.epes.demo.entity.WorkLog;
import com.epes.demo.service.BaseService;
import com.epes.demo.service.WorkLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description:
 * Date: 2018/4/30
 * Time: 16:50
 *
 * @Author lixingjie
 * @Modifice
 */

@Controller
@RequestMapping(value = "/worklog")
public class WorkLogController {

    private final WorkLogService workLogService;
    private final BaseService baseService;

    @Autowired
    public WorkLogController(WorkLogService workLogService, BaseService baseService) {
        this.workLogService = workLogService;
        this.baseService = baseService;
    }

  /*  @PostMapping(value = "/showLog")
    @ResponseBody
    public List<WorkLog> showLog(String userid, String pojid, String startdate, String enddate){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        if ( startdate == null || "".equals(startdate)){
            startdate = sdf.format(date);
        }
        if (enddate == null || "".equals(enddate)){
            Calendar curr = Calendar.getInstance();
            curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-1);
            date = curr.getTime();
            enddate = sdf.format(date);
        }
        return workLogService.findByUserId(userid,startdate,enddate,pojid);
    }*/

    @PostMapping(value = "/findLogOnUser")
    @ResponseBody
    public List<WorkLog> findLogOnUser(String userid, String pojid, String startdate, String enddate){
        Date date = new Date();
        Calendar curr = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        // 判断查询结束日期是否为空
        if ( enddate == null || "".equals(enddate)){
            // 结束日期如果为空，则获取当日日期+1
            curr.add(Calendar.DATE,1);
        } else {
            try {
                //结束日期不为空，则
                date = sdf.parse(enddate);
                curr.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        date=curr.getTime();
        enddate = sdf.format(date);

        if (startdate == null || "".equals(startdate)){
            //如果开始时间为空，赋初始值
            startdate = "1996-01-01";
        }
        //判断开始时间是否大于结束时间，大于结束时间则调换
        int res=startdate.compareTo(enddate);
        if(res>0){
            String src = enddate;
            enddate = startdate;
            startdate = src;
        }
        // 查询员工日志
        return workLogService.findByUserId(userid,pojid,startdate,enddate);
    }

    @PostMapping(value = "/findLogByid")
    @ResponseBody
    public WorkLog findLogById(String id){
        WorkLog workLog = workLogService.findById(id);
        String date = workLog.getWorkdate().substring(0,10);
        System.out.println(date);
        workLog.setWorkdate(date);
        return workLog;
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Map<String,String> update(WorkLog workLog){
        return workLogService.update(workLog);
    }

    @PostMapping(value = "/delete")
    @ResponseBody
    public Map<String,String> delete(String id){
        return workLogService.delete(id);
    }

    @PostMapping(value = "/addLog")
    @ResponseBody
    public Map<String,String> addLog(WorkLog workLog){
        return workLogService.addWorkLog(workLog);
    }
}
