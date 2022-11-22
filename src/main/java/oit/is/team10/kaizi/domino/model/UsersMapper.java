package oit.is.team10.kaizi.domino.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface UsersMapper {
  @Select("SELECT * from Users where id = #{id}")
  Users selectById(int id);

  @Insert("INSERT INTO Users () VALUES ();")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertUser(Users user);

  @Delete("DELETE FROM Users WHERE ID =#{id}")
  boolean deleteById(int id);

  @Update("UPDATE USERS SET ROOMID=#{room.id} WHERE ID=#{user.id}")
  void updateById(Room room, Users user);

  @Select("SELECT COUNT (*) FROM USERS")
  Integer countusers(Users user);
}
