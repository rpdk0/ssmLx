package fun.rpdk.mvcxmlx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
    public static String pwd(String str)  {
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
