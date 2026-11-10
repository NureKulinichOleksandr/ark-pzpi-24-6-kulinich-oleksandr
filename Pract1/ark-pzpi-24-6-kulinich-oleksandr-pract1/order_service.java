package org.chivqsss.shop.order;

import java.util.List;
import java.util.Map;

public class order_service {
    public double process(List<Map<String, Object>> o, int s) {
        double t = 0;
        if (o != null) {
            if (o.size() > 0) {
                for (int i = 0; i < o.size(); i++) {
                    Map<String, Object> m = o.get(i);
                    double p = (double) m.get("price");
                    int q = (int) m.get("qty");
                    t = t + p * q;
                }
                if (s == 2 && t > 1000) t = t * 0.9;
            }
        }
        return t;
    }
}