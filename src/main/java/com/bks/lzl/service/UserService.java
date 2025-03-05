package com.bks.lzl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bks.lzl.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService<User> {

    long userRegister(String userAccount, String userPassword, String checkPassword);

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    User getSafetyUser(User originUser);

    int userLogout(HttpServletRequest request);

    Page<User> searchUsersByTags(List<String> tagNameList, long pageSize, long pageNum);

    int updateUser(User user, User loginUser);

    User getLoginUser(HttpServletRequest request);

    boolean isAdmin(HttpServletRequest request);

    boolean isAdmin(User loginUser);

    List<User> matchUsers(long num, User loginUser);
}
