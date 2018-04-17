package com.epes.demo.service;

import com.epes.demo.dao.DepartmentDao;
import com.epes.demo.entity.Department;
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
 * Time: 10:55
 *
 * @Author lixingjie
 * @Modifice
 */
@Transactional
@Service
public class DepartmentService {

    private final BaseService baseService;

    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(BaseService baseService, DepartmentDao departmentDao) {
        this.baseService = baseService;
        this.departmentDao = departmentDao;
    }

    public Map<String, String> addDepartment(List<Department> deptList){
        for (Department department : deptList) {
            department.setId(UUID.randomUUID().toString());
            baseService.insert(department);
        }
        return null;
    }

    public Map<String, String> delete(String id){
        baseService.delete(Department.class,id);
        return null;
    }

    public Map<String, String> update(Department department){
        baseService.updata(department);
        return null;
    }

    public Department findDept(String id){
        return departmentDao.findDept(id);
    }

    public List<Map<String, Object>> findAllByPage(PageRequest pageRequest, SearchParams searchParams){
        return baseService.pageFindByCondition(Department.class, pageRequest, searchParams);
    }
}
