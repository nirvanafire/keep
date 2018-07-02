package top.vkeep.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.chapter2.model.Customer;
import top.vkeep.chapter2.util.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提供客户数据服务
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/1
 **/
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(String... keyword) {
        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT * FROM customer";
        customerList = DatabaseHelper.getEntityList(Customer.class, sql, keyword);

        return customerList;
    }
    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "select * from customer where id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }
    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
