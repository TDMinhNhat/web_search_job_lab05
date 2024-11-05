package dev.skyherobrine.app.backend.exceptions;

public class EntityIdNotFoundException extends Exception {

    public EntityIdNotFoundException(String id) {
        super("The entity id = " + id + " was not found!");
    }
}
