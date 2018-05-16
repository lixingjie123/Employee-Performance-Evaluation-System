package com.epes.demo.controller;

import com.epes.demo.entity.Project;
import com.epes.demo.service.BaseService;
import com.epes.demo.service.ProjectService;
import com.epes.demo.tool.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description:
 * Date: 2018/5/4
 * Time: 15:58
 *
 * @Author lixingjie
 * @Modifice
 */

@Controller
@RequestMapping(value = "/projct")
public class ProjctController {

    private final BaseService baseService;
    private final ProjectService projectService;

    @Autowired
    public ProjctController(BaseService baseService, ProjectService projectService) {
        this.baseService = baseService;
        this.projectService = projectService;
    }

    @PostMapping(value = "findAll")
    @ResponseBody
    public List<Map<String, Object>> findAll(int pageIndex, int size, SearchParams searchMap){
        PageRequest pageRequest = new PageRequest(pageIndex,size);
        return baseService.pageFindByCondition(Project.class,pageRequest,searchMap);
    }

    @PostMapping(value = "/disabled")
    @ResponseBody
    public Map<String,String> disabled(String id,int dr){
        Project project = new Project();
        if (dr == 1){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            project.setEnddate(df.format(new Date()));
        }
        project.setId(id);
        project.setDr(dr);
        return  projectService.update(project);
    }

    @PostMapping(value = "findPojById")
    @ResponseBody
    public Project findPojById(String id){
        return projectService.findPro(id);
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Map<String ,String> delete(String id){
        return projectService.delete(id);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Map<String,String> update(Project project){
        return projectService.update(project);
    }

    @PostMapping(value = "/addPoj")
    @ResponseBody
    public Map<String , String > addPoj(Project project){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        project.setStartdate(df.format(new Date()));
        return projectService.addPorject(project);
    }

    @PostMapping(value = "findPojByDept")
    @ResponseBody
    public List<Map<String, Object>> findPojByDept(SearchParams searchMap){
        PageRequest pageRequest = new PageRequest(0,999);
        return baseService.pageFindByCondition(Project.class,pageRequest,searchMap);
    }

}
