package service;

import entity.ImageBean;
import util.PageBean;

public interface ImgService {
    public PageBean<ImageBean> findAll(int pc, int pr);

    public PageBean<ImageBean> findUserImg(int pc, int pr, String username);


    public ImageBean findByid(int id);

    public void deleteByid(int id);
}
