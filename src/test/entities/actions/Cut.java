package test.entities.actions;

import test.entities.base.Action;
import test.entities.base.Property;

public class Cut extends Action {
    {
        action = (delta) -> {
            propertyMap.get("CuttingHealth").setPropertyValue(
                    propertyMap.get("CuttingHealth").getPropertyValue()
                            - propertyMap.get("Strength").getPropertyValue() * delta
            );
//            System.out.println(propertyMap.get("CuttingHealth").getPropertyValue());
        };
    }

    public void setStrength(Property strength) {
        propertyMap.put("Strength", strength);
    }

    public void setCuttingHealth(Property cuttingHealth) {
        propertyMap.put("CuttingHealth", cuttingHealth);
    }
}