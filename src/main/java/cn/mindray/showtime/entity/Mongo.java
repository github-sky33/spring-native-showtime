package cn.mindray.showtime.entity;

import cn.mindray.showtime.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Data
public class Mongo extends BaseEntity {

    // 名称
    private String name;

    // 颜色
    private String color;

    // 重量
    private Float weight;

    // 甜度
    private Float sweetness;

    // 产地
    private String productionPlace;

    /**
     * @author: heshiye
     * @description: 测试已被引用类的未使用方法是否会保留
     */
    public String unusedMethod(){
        return "测试被引用类的未使用方法是否会保留：---> 保留！！！";
    }

}
