package cn.mindray.showtime.mapper;

import cn.mindray.showtime.entity.Mongo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description:
 */
@Mapper
public interface MongoRepo {

    @Insert("""
        insert into mongo
                    (
                        name,
                        color,
                        weight,
                        sweetness,
                        production_place
                    ) values (
                        #{name},
                        #{color},
                        #{weight},
                        #{sweetness},
                        #{productionPlace}
                    )
    """)
    void create(Mongo mongo);

    @Update("""
        update mongo set
                     name=#{name},
                     color=#{color},
                     weight=#{weight},
                     sweetness=#{sweetness},
                     production_place=#{productionPlace}
                 where id=#{id}
    """)
    void update(Mongo mongo);

    @Select("""
        select * from mongo where id=#{id}
    """)
    Mongo find(long id);

    @Delete("""
        delete from mongo where id=#{id}
    """)
    Long delete(long id);

    @Select({"""
        <script>
            select * from mongo
                <if test="searchKey!=null and searchKey!=''">
                    where name like concat('%' , #{searchKey} , '%')
                </if>
        </script>
    """})
    List<Mongo> fuzzy(String searchKey);
}