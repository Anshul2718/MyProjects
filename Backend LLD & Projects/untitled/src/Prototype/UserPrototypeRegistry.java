package Prototype;

public interface UserPrototypeRegistry {
    void addPrototype(String userType, ObjectClonable userPrototype);
    ObjectClonable getPrototype(String userType);
    ObjectClonable cloneUser(String userType);
}
