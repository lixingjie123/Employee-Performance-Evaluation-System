package com.epes.demo.service;

import com.epes.demo.dao.BaseDao;
import com.epes.demo.tool.Exception.ColumnIsNullException;
import com.epes.demo.tool.Exception.NotTableEntityException;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


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

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BaseDao dao;

    @Autowired
    public BaseService(BaseDao dao) {
        this.dao = dao;
    }

    public <T> int save(T obj) throws NotTableEntityException, IllegalAccessException, ColumnIsNullException {
        Table annotation = obj.getClass().getAnnotation(Table.class);
        if (annotation != null ){
            Map<String, Object> fieldMap = new HashMap<>(0);
            String tableName = annotation.name();
            Field[] sonFields = obj.getClass().getDeclaredFields();
            if (obj.getClass().getSuperclass() !=null) {
                // 获取父类所有属性
                Field[] superFields = obj.getClass().getSuperclass().getDeclaredFields();
                // 获取父类字段名和字段值
                for (Field superField : superFields){
                    Column column = superField.getAnnotation(Column.class);
                    if (column != null){
                        superField.setAccessible(true);
                        Class type = superField.getType();
                        // superField是父类的属性  obj是子类；
                        Object val = superField.get(obj);
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
            }
            // 获取子类字段名和字段值
            for (Field sonField : sonFields) {
                Column column = sonField.getAnnotation(Column.class);
                if (column != null) {
                    sonField.setAccessible(true);
                    Object val = sonField.get(obj);
                    Class type = sonField.getType();
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
            StringBuilder sqlField = new StringBuilder();
            StringBuilder sqlVal = new StringBuilder();
            if (fieldMap.size() > 0){
                for (String key: fieldMap.keySet()) {
                    sqlField.append(key);
                    sqlVal.append(fieldMap.get(key));
                    sqlField.append(',');
                    sqlVal.append(',');
                }
            }
            sqlField.deleteCharAt(sqlField.length()-1);
            sqlVal.deleteCharAt(sqlVal.length()-1);
            dao.insert(tableName,sqlField.toString(),sqlVal.toString());
        }else {
            logger.error("'"+obj.getClass().getSimpleName() + "' 类不是表格实体");
            throw new NotTableEntityException("'"+obj.getClass().getSimpleName() + "' 类不是表格实体");
        }
        return 0;
    }
}
