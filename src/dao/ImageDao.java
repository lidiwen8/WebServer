package dao;

import entity.ImageBean;
import util.RowMapper;
import util.RowMapperList;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {

	// 查询所有记录
	public static List<ImageBean> query(String sql) {
		Object[] values = new Object[] {};
		ImageRML rowMapperList = new ImageRML();
		List<ImageBean> list = GeneralDao.query(sql, values, rowMapperList);
		return list;
	}

	// 查询所有记录
	public static List<ImageBean> querySrc(String sql) {
		Object[] values = new Object[] {};
		ImageSrcRML rowMapperList = new ImageSrcRML();
		List<ImageBean> list = GeneralDao.query(sql, values, rowMapperList);
		return list;
	}
	
	// 根据id，查询图片字节流
	public static InputStream queryImgStream(int id) {
		String sql = "select image from imgtest where id = ?";
		Object[] values = new Object[] {id};
		ImageRM rowMapper = new ImageRM();
		ImageBean imageBean = (ImageBean) GeneralDao.query(sql, values, rowMapper);
		// 如果查询结果为空
		if (imageBean.equals(null)) {
			return null;
		}
		return imageBean.getInStream();
	}
}

// 一条记录映射
class ImageRM implements RowMapper {


	public Object rowMapping(ResultSet rs) throws SQLException {
		if (rs.next()) {
			ImageBean imageBean = new ImageBean();
			// 获取图片字节
			imageBean.setInStream(rs.getBinaryStream("image"));
			return imageBean;
		}
		
		return null;
	}
	
}

// 一组记录映射
class  ImageRML implements RowMapperList {

	public List<ImageBean> rowMapping(ResultSet rs) throws SQLException 
	{
		List<ImageBean> list = new ArrayList<ImageBean>();
		// 如果rs有数据
		if (rs.next()) {
			do {
				ImageBean imageBean = new ImageBean();
				imageBean.setId(rs.getInt("id"));
				imageBean.setName(rs.getString("name"));	
				list.add(imageBean);
			} while (rs.next());
		}
		else {
			return null;
		}
		return list;
	}
}

//一组记录映射
class ImageSrcRML implements RowMapperList {
	
	public List<ImageBean> rowMapping(ResultSet rs) throws SQLException 
	{
		List<ImageBean> list = new ArrayList<ImageBean>();
		// 如果rs有数据
		if (rs.next()) {
			do {
				ImageBean imageBean = new ImageBean();
				imageBean.setId(rs.getInt("id"));
				imageBean.setName(rs.getString("name"));
				imageBean.setSrc(rs.getString("src"));
				imageBean.setUsername(rs.getString("username"));
				imageBean.setDate(rs.getString("date"));
				list.add(imageBean);
			} while (rs.next());
		}
		else {
			return null;
		}
		return list;
	}
}

