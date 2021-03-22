package test.entities.base;

public class Property extends Entity {
    protected String propertyName;
    protected Double propertyValue;
    protected Double propertyValueInit;

    public Property(Double value) {
        propertyValue = value;
        propertyValueInit = value;
    }

    public Double getPropertyValueInit() {
        return propertyValueInit;
    }

    public Double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }
}