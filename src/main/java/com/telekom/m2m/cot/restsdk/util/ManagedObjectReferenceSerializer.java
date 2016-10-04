package com.telekom.m2m.cot.restsdk.util;

import com.google.gson.*;
import com.telekom.m2m.cot.restsdk.inventory.ManagedObject;
import com.telekom.m2m.cot.restsdk.inventory.ManagedObjectReference;

import java.lang.reflect.Type;

/**
 * Created by breucking on 03.09.16.
 */
public class ManagedObjectReferenceSerializer implements
        JsonSerializer<ManagedObjectReference>,
        JsonDeserializer<ManagedObjectReference> {

    public ManagedObjectReference deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonObject()) {
            JsonElement jMO = jsonElement.getAsJsonObject().get("managedObject");
            ManagedObject mo = jsonDeserializationContext.deserialize(jMO, ManagedObject.class);
            return new ManagedObjectReference(mo);
        }
        return new ManagedObjectReference();
    }

    public JsonElement serialize(ManagedObjectReference src, Type typeOfSrc, JsonSerializationContext context) {
        throw new UnsupportedOperationException();
    }
}