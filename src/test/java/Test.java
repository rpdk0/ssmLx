import fun.rpdk.mvcxmlx.entity.User;
import fun.rpdk.mvcxmlx.mapper.UserMapper;
import fun.rpdk.mvcxmlx.util.Logger;
import fun.rpdk.mvcxmlx.util.Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    ApplicationContext app=new ClassPathXmlApplicationContext("mapperbean.xml","appcontext.xml");
    @org.junit.jupiter.api.Test
    public void test()  {
        UserMapper userMapper=app.getBean("userMapper",UserMapper.class);
        System.out.println(userMapper.getUserById(1));


    }
    public String pwd(String str)  {
        byte[]bytes=str.getBytes();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(bytes);
        byte[]bb=md5.digest(new byte[]{bytes[0],0xf,0xe});
        for (int i = 0; i < bb.length; i++) {
            bb[i]= (bb[i]>=33&&bb[i]<=126)?bb[i]: (byte) ((bb[i] & 0x3f) + 33);
        }

        return new String(bb);
    }

}
