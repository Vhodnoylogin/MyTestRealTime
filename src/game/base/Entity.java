package game.base;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    protected EntityType entityType;
    protected Map<EntityType, Property> properties;

    {
        properties = new HashMap<>();
    }

    public EntityType getEntityType() {
        return entityType;
    }

    protected void setProperty(Property property) {
        properties.put(property.getEntityType(), property);
    }
}