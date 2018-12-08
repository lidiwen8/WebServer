package dao;

import cn.itcast.jdbc.TxQueryRunner;
import entity.ImageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.PageBean;

import java.util.List;

public class ImgDao {
    private QueryRunner qr = new TxQueryRunner();

    public PageBean<ImageBean> findAll(int pc, int pr) {
        try {
            /*
             *1.他需要创建pageBean对象pb
             * 2.设置pb的pc和pr
             * 3.得到tr，设置给pb
             * 4.得到beanList设置给pb
             * 最后返回给pb
             */
            PageBean<ImageBean> pb = new PageBean<>();
            pb.setPc(pc);
            pb.setPr(pr);
            String sql = "select count(*) from img_src";
            Number number = (Number) qr.query(sql, new ScalarHandler<>());
            int tr = number.intValue();
            pb.setTr(tr);
            sql = "select * from img_src order by id limit ?,?";
            Object[] params = {(pc - 1) * pr, pr};
            List<ImageBean> beanList = qr.query(sql, new BeanListHandler<>(ImageBean.class), params);
            pb.setBeanList(beanList);
            return pb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PageBean<ImageBean> findUserImg(int pc, int pr, String username) {
        try {
            PageBean<ImageBean> pb = new PageBean<>();
            pb.setPc(pc);
            pb.setPr(pr);
            String sql = "select count(*) from img_src where username=?";
            Object[] param = {username};
            Number number = (Number) qr.query(sql, new ScalarHandler<>(), param);
            int tr = number.intValue();
            pb.setTr(tr);
            sql = "select * from img_src where username=? order by id limit ?,?";
            Object[] params = {username, (pc - 1) * pr, pr};
            List<ImageBean> beanList = qr.query(sql, new BeanListHandler<>(ImageBean.class), params);
            pb.setBeanList(beanList);
            return pb;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ImageBean findByid(int id) {
        try {
            String sql = "select * from img_src where id=?";
            return qr.query(sql, new BeanHandler<ImageBean>(ImageBean.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByid(int id) {
        try {
            String sql = "delete from img_src where id=?";
            qr.update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
