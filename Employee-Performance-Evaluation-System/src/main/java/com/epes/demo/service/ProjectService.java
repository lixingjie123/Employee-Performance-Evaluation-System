package com.epes.demo.service;

import com.epes.demo.dao.ProjectDao;
import com.epes.demo.entity.Department;
import com.epes.demo.entity.Project;
import com.epes.demo.tool.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Description:
 * Date: 2018/4/17
 * Time: 11:25
 *
 * @Author lixingjie
 * @Modifice
 */

@Transactional
@Service
public class ProjectService {
    private final BaseService baseService;
    private final ProjectDao projectDao;

    @Autowired
    public ProjectService(BaseService baseService, ProjectDao projectDao) {
        this.baseService = baseService;
        this.projectDao = projectDao;
    }

    @Transactional
    public Map<String, String> addPorject(Project project){
        Map<String, String> result = new HashMap<>(0);
        project.setId(UUID.randomUUID().toString());
        int i = baseService.insert(project);
        if (i>0){
            result.put("success","success");
            result.put("msg","新增成功");
        }else {
            result.put("success","error");
            result.put("msg","新增失败,无法连接数据库");
        }
        return result;
    }

    @Transactional
    public Map<String, String> delete(String id ){
        Map<String, String> result = new HashMap<>(0);
        int i = baseService.delete(Project.class, id);
        if (i>0){
            result.put("success","success");
            result.put("msg","删除成功");
        }else {
            result.put("success","error");
            result.put("msg","删除失败,无法连接数据库");
        }
        return result;
    }

    @Transactional
    public Map<String, String> update(Project project){
        int p = baseService.update(project);
        Map<String,String> map = new HashMap<>(0);
        if (p>0){
            map.put("msg","修改成功");
            map.put("success","success");
        }else {
            map.put("msg","数据不存在或数据无法修改");
            map.put("success","error");
        }
        return map;
    }

    public List<Map<String, Object>> findAllByPage(PageRequest pageRequest, SearchParams searchParams){
        return baseService.pageFindByCondition(Project.class, pageRequest, searchParams);
    }

    public Project findPro(String id){
        return projectDao.findPro(id);
    }
}
