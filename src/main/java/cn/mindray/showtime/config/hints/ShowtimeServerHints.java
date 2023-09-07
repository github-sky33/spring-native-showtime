package cn.mindray.showtime.config.hints;

import cn.mindray.showtime.entity.Mongo;
import cn.mindray.showtime.entity.UnusedEntity;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
public class ShowtimeServerHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Register method for reflection
        Method method = ReflectionUtils.findMethod(Mongo.class, "unusedMethod");
        hints.reflection().registerMethod(method, ExecutableMode.INVOKE);

        // register class for reflection
        hints.reflection().registerType(UnusedEntity.class, MemberCategory.values());


    }

}

