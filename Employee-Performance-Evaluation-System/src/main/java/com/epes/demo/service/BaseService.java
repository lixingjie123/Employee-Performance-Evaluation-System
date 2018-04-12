package com.epes.demo.service;

import com.epes.demo.dao.BaseDao;
import com.epes.demo.entity.BaseEntity;
import com.epes.demo.tool.SearchParams;
import com.epes.demo.tool.exception.ColumnIsNullException;
import com.epes.demo.tool.exception.NotTableEntityException;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Description:
 * Date: 2018/1/11
 * Time: 19:19
 *
 * @Author lixingjie
 * @Modifice
 */
@Service
public class BaseService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BaseDao dao;

    @Autowired
    public BaseService(BaseDao dao) {
        this.dao = dao;
    }

    /**
     * 插入一条数据
     * @param entity
     * @param <T>
     * @return
     * @throws NotTableEntityException
     * @throws IllegalAccessException
     * @throws ColumnIsNullException
     */
    public <T extends BaseEntity> int insert(T entity){
       String tableName = getTableName(entity.getClass());
        int p = 0;
        if (tableName != null ){
            Map<String, Object> fieldMap = new HashMap<>(0);
            Field[] sonFields = entity.getClass().getDeclaredFields();

            try {
                if (entity.getClass().getSuperclass() != null) {
                    // 获取父类所有属性
                    Field[] superFields = entity.getClass().getSuperclass().getDeclaredFields();
                    // 获取父类字段名和字段值
                    fieldMap.putAll(getFieldValueValidation(superFields, entity));
                }

                // 获取子类字段名和字段值
                fieldMap.putAll(getFieldValueValidation(sonFields, entity));
            } catch (ColumnIsNullException | IllegalAccessException e) {
                e.printStackTrace();
            }
            // 设置新增日期
            fieldMap.put("createtime",getDateToString());
            StringBuilder sqlField = new StringBuilder();
            StringBuilder sqlVal = new StringBuilder();
            if (fieldMap.size() > 0){
                // 生成SQL所需的语句段
                for (String key: fieldMap.keySet()) {
                    sqlField.append(key);
                    sqlVal.append(fieldMap.get(key));
                    sqlField.append(',');
                    sqlVal.append(',');
                }
                sqlField.deleteCharAt(sqlField.length()-1);
                sqlVal.deleteCharAt(sqlVal.length()-1);
            }
            p = dao.insert(tableName,sqlField.toString(),sqlVal.toString());
        }else {
            logger.error("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            try {
                throw new NotTableEntityException("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            } catch (NotTableEntityException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    /**
     * 通过 id 修改数据
     * @param entity
     * @param <T>
     * @return
     */
    public <T extends BaseEntity> int updata(T entity) {
        String tableName = getTableName(entity.getClass());
        int p = 0;
        if (tableName != null){
            Map<String, Object> fieldMap = new HashMap<>(0);
            Field[] sonField = entity.getClass().getDeclaredFields();
            if (entity.getClass().getSuperclass() != null){
                Field[] superField = entity.getClass().getSuperclass().getDeclaredFields();
                fieldMap.putAll(getFieldValue(superField, entity));
            }
            fieldMap.putAll(getFieldValue(sonField, entity));
            fieldMap.put("modifiedtime", getDateToString());
            StringBuilder sqlVal = new StringBuilder();
            if (fieldMap.size() > 0){
                // 生成所需的SQL语句段
                for (String key: fieldMap.keySet()) {
                    Object keyVal = fieldMap.get(key);
                    if (keyVal != null && (!"'null'".equals(keyVal))){
                        sqlVal.append(key + "=" + fieldMap.get(key) + ",");
                    }
                }
                sqlVal.deleteCharAt(sqlVal.length()-1);
            }
            p = dao.updata(tableName, sqlVal.toString(),fieldMap.get("id").toString());
        }else {
            logger.error("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            try {
                throw new NotTableEntityException("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            } catch (NotTableEntityException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    /**
     * 通过 id 删除表数据
     * @param entity
     * @param id
     * @param <T>
     * @return
     */
    public <T extends BaseEntity> int delete(Class<T> entity, String id)  {
        int p = 0;
        String tableName = getTableName(entity);
        if(tableName != null && !"".equals(tableName)){
            p = dao.delete(tableName, id);
        }else {
        logger.error("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            try {
                throw new NotTableEntityException("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            } catch (NotTableEntityException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    /**
     * 按条件分页查询
     * @param <T>
     * @param entity
     * @param pageRequest
     * @param searchParams
     * @return
     */
    public <T extends BaseEntity> List<Map<String, Object>> pageFindByCondition(Class<T> entity, PageRequest pageRequest, SearchParams searchParams){
        String tableName = getTableName(entity);
        int pageIndex = pageRequest.getPageNumber();
        int pageSize = pageRequest.getPageSize();
        Map<String, Object> searchMap = searchParams.getSearchMap();
        StringBuilder search = new StringBuilder();
        if(tableName != null && !"".equals(tableName)){
            if (searchMap.size() != 0){
                search.append(" where 1=1 ");
                // 获取条件
                for(String key : searchMap.keySet()){
                    search.append(" and ").append(key).append(" = ").append(searchMap.get(key));
                }
            }
        }else {
            logger.error("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            try {
                throw new NotTableEntityException("'"+entity.getClass().getSimpleName() + "' 类不是表格实体");
            } catch (NotTableEntityException e) {
                e.printStackTrace();
            }
        }
        return dao.pageFind(tableName, search.toString(), pageIndex, pageSize);
    }


    /**
     * 查询Column注解，获取字段名与值
     * @param fields
     * @param entity
     * @param <T>
     * @return
     * @throws ColumnIsNullException
     * @throws IllegalAccessException
     */
    private <T extends BaseEntity> Map<String, Object> getFieldValue(Field[] fields, T entity) {
        Map<String, Object> fieldMap = new HashMap<>(0);
        for (Field field : fields){
            Column column = field.getAnnotation(Column.class);
            if (column != null){
                field.setAccessible(true);
                Class type = field.getType();
                // superField是父类的属性  obj是子类；
                Object val = null;
                try {
                    val = field.get(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (Objects.equals(type.getName(), "java.lang.String")) {
                    val = "'" + val + "'";
                }
                String key = column.name();
                fieldMap.put(key, val);
            }
        }
        return fieldMap;
    }


    /**
     * 查询Column注解，获取字段名与值（带验证非空字段）
     * @param fields
     * @param entity
     * @param <T>
     * @return
     * @throws ColumnIsNullException
     * @throws IllegalAccessException
     */
    private <T extends BaseEntity> Map<String, Object> getFieldValueValidation(Field[] fields, T entity) throws ColumnIsNullException, IllegalAccessException {
        Map<String, Object> fieldMap = new HashMap<>(0);
        for (Field field : fields){
            Column column = field.getAnnotation(Column.class);
            if (column != null){
                field.setAccessible(true);
                Class type = field.getType();
                // superField是父类的属性  obj是子类；
                Object val = field.get(entity);
                if (!column.isNull() && val == null){
                    logger.error("非空字段："+column.name()+" 值为空");
                    throw new ColumnIsNullException("非空字段："+column.name()+" 值为空");
                }else {
                    if (Objects.equals(type.getName(), "java.lang.String")){
                        val = "'" + val + "'";
                    }
                    String key = column.name();
                    fieldMap.put(key, val);
                }
            }
        }
        return fieldMap;
    }



    /**
     * 获取当前系统时间，并返回时间字符串
     * @return
     */
    @NotNull
    private String getDateToString(){
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "'" + df.format(new Date()) + "'";
    }

    /**
     * 获取表名
     * @param entityClass
     * @param <T>
     * @return
     */
    @Nullable
    private <T extends BaseEntity> String getTableName(Class<T> entityClass){
        Table table = entityClass.getAnnotation(Table.class);
        if (table != null){
            return table.name();
        }else {
            return null;
        }
    }
}
