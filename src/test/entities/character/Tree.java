package test.entities.character;

import test.entities.base.Entity;
import test.entities.base.Property;
import test.entities.property.CuttingHealth;

public class Tree extends Entity {
    protected String healthName;

    {
        Property qql = new CuttingHealth(15.0);
        healthName = qql.getPropertyName();
        propertyMap.put(healthName, qql);
    }

    public Property getHealth() {
        return propertyMap.get(healthName);
    }
}