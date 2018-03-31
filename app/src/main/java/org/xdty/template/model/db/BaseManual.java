package org.xdty.template.model.db;

import io.requery.Column;
import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.Table;

@Table(name = "manual")
@Entity
public abstract class BaseManual {
    @Key
    @Generated
    @Column(name = "ID")
    int id;

    @Column(name = "COMMAND")
    String command;

    @Column(name = "DOCUMENT")
    String document;

    @Column(name = "UPDATE_TIME")
    long updateTime;
}
