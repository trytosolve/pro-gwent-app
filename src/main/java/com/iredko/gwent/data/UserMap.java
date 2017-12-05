package com.iredko.gwent.data;

import java.util.HashMap;
import java.util.Map;

/*
Выполняет роль БД, учет зарегистрированных польователей и информации по ним
 */
/* TODO почему не положить это внутрь Login?
NOTE: ключевое слово "static" почти всегда признак плохого кода :)
*/
public class UserMap {
    public static Map<String,String> userMap = new HashMap<>();
}
