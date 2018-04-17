package com.epes.demo.service;

import com.epes.demo.dao.ProjectDao;
import com.epes.demo.entity.Project;
import com.epes.demo.tool.SearchParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Map<String, String> addPorject(List<Project> projectList){
        for (Project project : projectList){
            project.setId(UUID.randomUUID().toString());
            baseService.insert(project);
        }
        return null;
    }

    public Map<String, String> delete(String id ){
        baseService.delete(Project.class, id);
        return null;
    }

    public Map<String, String> update(Project project){
        baseService.updata(project);
        return null;
    }

    public List<Map<String, Object>> findAllByPage(PageRequest pageRequest, SearchParams searchParams){
        return baseService.pageFindByCondition(Project.class, pageRequest, searchParams);
    }

    public Project findPro(String id){
        return projectDao.findPro(id);
    }
}
