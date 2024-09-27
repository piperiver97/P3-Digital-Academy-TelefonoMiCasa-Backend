package com.factoriaf5.telefono_micasa.factories;

import com.factoriaf5.telefono_micasa.dtos.PropertyDTO;
import com.factoriaf5.telefono_micasa.models.Property;

public abstract class PropertyFactory {
    public abstract Property createProperty(PropertyDTO propertyDTO);
}
