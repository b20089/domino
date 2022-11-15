package oit.is.team10.kaizi.domino.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface UserMapper {
  @Select("SELECT * from User where id = #{id}")
  Room selectById(int id);

  @Insert("INSERT INTO User (roomid) VALUES (#{userid},);")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(User user);

  @Delete("DELETE FROM User WHERE ID =#{id}")
  boolean deleteById(int id);

}
