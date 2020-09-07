package com.gmail.alfonz19.util.initialize.context;


import lombok.Getter;
import lombok.Setter;

import java.beans.PropertyDescriptor;
import java.util.Objects;

@SuppressWarnings({"unused"})//unused constructs.
public class PathContext {
    public PathContext() {
        this(new InstancePath());
    }

    public PathContext(Path path) {
        this.path = Objects.requireNonNull(path);
    }

    @Getter
    private final Path path;

    @Getter
    private CalculatedNodeData calculatedNodeData;

    public PathContext createSubPathTraversingProperty(PropertyDescriptor propertyDescriptor) {
        return new PathContext(path.createSubPathTraversingProperty(propertyDescriptor));
    }

    public PathContext createSubPathTraversingArray(int index) {
        return new PathContext(path.createSubPathTraversingArray(index));
    }

    public PathContext createSubPathTraversingMap(String key) {
        return new PathContext(path.createSubPathTraversingMap(key));
    }

    public void setCalculatedNodeData(CalculatedNodeData calculatedNodeData) {
        if (this.calculatedNodeData != null) {
            throw new IllegalStateException("Overwriting calculatedNodeData is not allowed.");
        }
        this.calculatedNodeData = Objects.requireNonNull(calculatedNodeData);
    }

    @Setter
    @Getter
    private static class CalculatedNodeData {
        private Class<?> instanceClassType;
        //TODO MMUCHA: missing known generics types.
    }

}
