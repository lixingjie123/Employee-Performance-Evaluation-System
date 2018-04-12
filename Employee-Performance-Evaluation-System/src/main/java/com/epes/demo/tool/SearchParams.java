package com.epes.demo.tool;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Date: 2018/3/16
 * Time: 14:54
 *
 * 用于接收查询条件
 * @Author lixingjie
 * @Modifice
 */
public class SearchParams {
    private Map<String, Object> searchMap = new HashMap();

    public SearchParams() {
    }

    public Map<String, Object> getSearchMap() {
        return this.searchMap;
    }

    public void setSearchMap(Map<String, Object> searchMap) {
        this.searchMap = searchMap;
    }

    public void addCondition(String key, Object value) {
        this.searchMap.put(key, value);
    }

    public Object removeCondition(String key) {
        return this.searchMap.remove(key);
    }
}
