package cn.mindray.showtime.base.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2023l;

    // id
    private Long id;

}
