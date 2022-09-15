package io.starburst.example.guice.creator.impl;

import com.google.inject.Inject;
import io.starburst.example.guice.creator.ITableCreator;
import io.starburst.example.guice.metadata.TableMetadata;

public class HiveTableCreator implements ITableCreator
{
    TableMetadata hiveTableMetadata;

    @Inject
    public HiveTableCreator(TableMetadata hiveTableMetadata)
    {
        this.hiveTableMetadata = hiveTableMetadata;
    }

    public Boolean create()
    {
        return this.hiveTableMetadata.create();
    }
}
