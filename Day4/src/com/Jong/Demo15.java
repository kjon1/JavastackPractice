package com.Jong;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo15 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("name", "Jax");
        m.put("age", "33");
        m.put("felon", false);

        Set set = m.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next()   ;
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }

    }
}
