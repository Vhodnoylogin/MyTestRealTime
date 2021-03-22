package test.entities.base;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    protected Map<String, Property> propertyMap;

    {
        propertyMap = new HashMap<>();
    }

    public Property getProperty(String name) {
        return propertyMap.get(name);
    }
}