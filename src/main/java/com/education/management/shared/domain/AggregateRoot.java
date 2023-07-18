package com.education.management.shared.domain;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class AggregateRoot {
  protected UUID id;
  protected Date createdAt;
  protected Date updatedAt;

  public AggregateRoot(UUID id, Date createdAt, Date updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
