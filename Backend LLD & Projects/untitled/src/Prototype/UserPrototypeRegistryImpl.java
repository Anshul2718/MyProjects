package Prototype;

import java.util.HashMap;
import java.util.Map;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry{
    private Map<String, ObjectClonable> prototypeMap = new HashMap<>();

    @Override
    public void addPrototype(String userType, ObjectClonable userPrototype) {
        prototypeMap.put(userType,userPrototype);
    }

    @Override
    public ObjectClonable getPrototype(String userType) {
        return prototypeMap.get(userType);
    }

    @Override
    public ObjectClonable cloneUser(String userType) {
        ObjectClonable prototype = getPrototype(userType);
        if(prototype != null){
            return prototype.clone();
        }else{
            throw new IllegalArgumentException("Prototype for user type '"+userType+"' not found.");
        }
    }
}
