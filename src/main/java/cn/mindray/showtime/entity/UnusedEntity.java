package cn.mindray.showtime.entity;

import lombok.Data;

/**
 * @author: heshiye
 * @date 2023年08月27日
 * @email: heshiye@mindray.com
 * @description:
 */
@Data
public class UnusedEntity {

    private String name;


    public String say(){
        return "Hello!";
    }

}
