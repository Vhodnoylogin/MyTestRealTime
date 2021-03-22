package game.base;

import java.util.Objects;

public class EntityType {
    protected String type;
    protected EntityType parentType;

    public String getType() {
        return type;
    }

    public EntityType getParentType() {
        return parentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityType that = (EntityType) o;
        return type.equals(that.type) && Objects.equals(parentType, that.parentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, parentType);
    }
}