package oit.is.team10.kaizi.domino.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface RoomMapper {
  @Select("SELECT * from Room where id = #{id}")
  Room selectById(int id);

  @Insert("INSERT INTO Room (userid) VALUES (#{userid},);")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(Room room);

  @Delete("DELETE FROM Room WHERE ID =#{id}")
  boolean deleteById(int id);

}
