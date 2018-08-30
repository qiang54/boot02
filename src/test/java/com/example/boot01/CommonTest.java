package com.example.boot01;


import com.example.boot01.domian.User;
import com.example.boot01.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class CommonTest {

    @Test
    public void testGenJwtToken(){

        User user = new User();
        user.setId(999);
        user.setName("nihao");
        user.setHeadImg("ww.nihao.com");

        String token = JwtUtils.genJwtwebToken(user);

        System.out.println(token);

    }

    @Test
    public void testCheck(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqd3QiLCJ1c2VySWQiOjk5OSwidXNlck5hbWUiOiJuaWhhbyIsIkhlYWRJbWciOiJ3dy5uaWhhby5jb20iLCJpYXQiOjE1MzU1NDUzMDcsImV4cCI6MTUzNjE1MDEwN30.e_NQnvhLnBTuKiNO__LM8YZxrEA7r5I9_y4A66et640";

        Claims claim = JwtUtils.checkJwt(token);
        if (claim != null){
            Object userId = claim.get("userId");
            Object userName = claim.get("userName");
            Object headImg = claim.get("HeadImg");
            System.out.println(userId);
            System.out.println(userName);
            System.out.println(headImg);
        }else {
            System.out.println("非法token");
        }
    }
}
