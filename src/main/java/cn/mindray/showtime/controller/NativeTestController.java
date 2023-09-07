package cn.mindray.showtime.controller;

import cn.mindray.showtime.base.entity.Result;
import cn.mindray.showtime.entity.Mongo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Slf4j
@RestController
@RequestMapping("/native")
@Tag(name = "NativeTestController", description = "Native测试")
public class NativeTestController {

    @GetMapping("/class")
    @Operation(description = "反射类 cn.mindray.showtime.entity.UnusedEntity 测试")
    public Result classTest() throws Exception {
        Class<?> aClass = Class.forName("cn.mindray.showtime.entity.UnusedEntity");
        if (aClass==null) {
            Result.failed("cn.mindray.showtime.entity.UnusedEntity 不存在");
        }
        return Result.success(aClass);
    }

    @GetMapping("/method")
    @Operation(description = "反射方法测试")
    public Result methodTest() throws Exception {
        Class<Mongo> aClass = Mongo.class;
        Mongo mongo = aClass.newInstance();
        Method unusedMethod = aClass.getDeclaredMethod("unusedMethod");
        unusedMethod.setAccessible(true);
        return Result.success(unusedMethod.invoke(mongo));
    }


}
