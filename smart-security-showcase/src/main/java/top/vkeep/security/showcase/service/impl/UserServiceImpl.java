package top.vkeep.security.showcase.service.impl;

import top.vkeep.security.showcase.model.User;
import top.vkeep.security.showcase.service.IUserService;
import top.vkeep.smart.annotation.Service;
import top.vkeep.smart.helper.DatabaseHelper;
import top.vkeep.smart.util.CodecUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-21
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public boolean save(String username, String password) {
        Map<String, Object> user = new HashMap<>();

        String encrypt = CodecUtil.md5(password);

        user.put("username", username);
        user.put("password", encrypt);
        return DatabaseHelper.insertEntity(User.class, user);
    }
}
