package fun.rpdk.mvcxmlx.mapper;

import fun.rpdk.mvcxmlx.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 通过邮箱,密码获取用户
     * @param email-邮箱
     * @return 用户实体类
     */
    User getUserByEmail(@Param("email") String email, @Param("password") String pwd);

    /**
     * 通过id获取用户
     * @param id-用户id
     * @return 用户实体类
     */
    User getUserById(int id);

    /**
     * 通过id删除用户
     * @param id-用户id
     * @return 如果为1则成功，0为失败，null可能是出错
     */
    Integer delete(int id);

    /**
     * 添加用户
     * @param user
     * @return 如果为1则成功，0为失败，null可能是出错
     */
    Integer add(User user);

    /**
     * 更新用户信息
     * @param user
     * @return 如果为1则成功，0为失败，null可能是出错
     */
    Integer update(User user);
}
