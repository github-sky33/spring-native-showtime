package cn.mindray.showtime.mapper;

import cn.mindray.showtime.entity.Mongo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Mapper
public interface MongoAnnonRepo {

    @Select(
            """
                select r.* from mongo l, mongo r where l.id=#{id}
                and l.production_Place=r.production_Place and r.id!=l.id
                
            """
    )
    List<Mongo> sameProductionPlace(@Param("id") long id);
}