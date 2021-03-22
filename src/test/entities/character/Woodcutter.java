package test.entities.character;

import test.entities.base.Entity;
import test.entities.base.Property;
import test.entities.property.Strength;

public class Woodcutter extends Entity {
    protected String strengthName;

    {
        Strength qql = new Strength(2.0);
        strengthName = qql.getPropertyName();
        propertyMap.put(strengthName, qql);
    }

    public Property getStrength() {
        return propertyMap.get(strengthName);
    }
}