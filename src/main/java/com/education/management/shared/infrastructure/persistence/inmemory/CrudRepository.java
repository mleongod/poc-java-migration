package com.education.management.shared.infrastructure.persistence.inmemory;

import com.education.management.shared.domain.AggregateRoot;
import com.education.management.shared.infrastructure.exceptions.NotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CrudRepository<T extends AggregateRoot> {

    private final String className;
    protected Map<UUID, T> rows = new HashMap<>();

    public CrudRepository(String className) {
        this.className = className;
    }

    public void create(T data) {
        this.rows.put(data.getId(), data);
    }

    public T getById(UUID uuid) throws NotFoundException {
        this.existsOrThrow(uuid);
        return this.rows.get(uuid);
    }

    public Collection<T> getAll() {
        return this.rows.values();
    }


    public void existsOrThrow(UUID id) throws NotFoundException {
        if (!this.rows.containsKey(id)) {
            String message = String.format("Not found %s with id %s", this.className, id.toString());
            throw NotFoundException.create(message);
        }
    }
}
