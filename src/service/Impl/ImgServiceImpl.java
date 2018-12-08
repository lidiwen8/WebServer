package service.Impl;

import dao.ImgDao;
import entity.ImageBean;
import service.ImgService;
import util.PageBean;

import javax.jws.WebService;

@WebService
public class ImgServiceImpl implements ImgService {
    ImgDao imgDao = new ImgDao();

    public PageBean<ImageBean> findAll(int pc, int pr) {
        return imgDao.findAll(pc, pr);
    }

    public PageBean<ImageBean> findUserImg(int pc, int pr, String username) {
        return imgDao.findUserImg(pc, pr, username);
    }

    public ImageBean findByid(int id) {
        return imgDao.findByid(id);
    }

    public void deleteByid(int id) {
        imgDao.deleteByid(id);
    }
}
