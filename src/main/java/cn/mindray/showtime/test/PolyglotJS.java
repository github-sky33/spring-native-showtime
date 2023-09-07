package cn.mindray.showtime.test;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description:  多语言混编测试   注:需要在GraalVM中安装JS（命令行执行： gu install js）
 */
public class PolyglotJS {

    public static void main(String[] args) {
        Context context = Context.create();
        Value js = context.eval("js",
                        """
                                (
                                    function(a,b){
                                        return a-b;
                                    }
                                )
                                """)
                .execute(120, 20);
        System.out.println(js.asInt());
    }

}
