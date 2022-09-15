package io.starburst.example.guice.metadata.impl;

import io.starburst.example.guice.metadata.TableMetadata;

import java.util.List;

public class IcebergTableMetadata extends TableMetadata
{
    public IcebergTableMetadata(String tableName, String databaseName, Boolean partitionedTable, List<String> columns)
    {
        super(tableName, databaseName, partitionedTable, columns);
    }

    @Override
    public Boolean create()
    {
        System.out.println("Iceberg Table created. " + this.toString());
        return true;
    }
}
