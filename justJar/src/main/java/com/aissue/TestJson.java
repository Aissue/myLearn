package com.aissue;

import com.aissue.entity.User;
import com.aissue.utils.JsonUtil;

public class TestJson {

    public String mainTest(User user){
        return JsonUtil.toJsonString(user);
    }
}
