package com.avid.central.example.todo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by volodymyr.shugaiev on 7/20/2015.
 */
public class TodoStorage {
    private Map<UUID, Todo> items = new HashMap<UUID, Todo>();

    public Todo create (Todo item) {
        UUID id = UUID.randomUUID();
//        UUID id = UUID.fromString("Michael");
        item.setId(id);
        items.put(id, item);
        return item;
    }

    public Todo read (UUID id) {
        return items.get(id);
    }

    public Todo delete (UUID id) {
        return items.remove(id);
    }

    public Collection<Todo> list () {
        return items.values();
    }

    public Todo update (UUID id, Todo item) {
        item.setId(id);
        items.put(id, item);
        return item;
    }
}
