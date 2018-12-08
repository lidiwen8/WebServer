package dao;

import cn.itcast.jdbc.TxQueryRunner;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDao {
    private QueryRunner mysqlDao = new TxQueryRunner();

    public User login(String name, String password) {
        try {
//            if ((mysqlDao.query("select * from login where passerword=?", new BeanHandler<JPo>(JPo.class), passerword) != null) && (mysqlDao.query("select * from login where name=?", new BeanHandler<JPo>(JPo.class), name) != null)){
            return mysqlDao.query("select * from login where name=? and password=?", new BeanHandler<User>(User.class), name, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public User queryUser(String name) {
        try {
            return mysqlDao.query("select * from login where name=?", new BeanHandler<User>(User.class), name);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public int register(User user) throws Exception {
        int flag = 0;
        String sql = "insert into login(name,password,sex) values(?,?,?)";
        Object[] params = {user.getName(), user.getPassword(), user.getSex()};
        try {
            //事务开始

            mysqlDao.update(sql, params);
            flag = 1;
            //事务提交
        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            flag = 0;
            throw e;
        }
        return flag;
    }


}
