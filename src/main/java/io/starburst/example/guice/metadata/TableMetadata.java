package io.starburst.example.guice.metadata;

import java.util.List;

public abstract class TableMetadata
{
    String tableName;
    String databaseName;
    Boolean partitionedTable;
    List<String> columns;

    public TableMetadata(String tableName, String databaseName, Boolean partitionedTable, List<String> columns)
    {
        this.tableName = tableName;
        this.databaseName = databaseName;
        this.partitionedTable = partitionedTable;
        this.columns = columns;
    }

    public String getTableName()
    {
        return tableName;
    }

    public String getDatabaseName()
    {
        return databaseName;
    }

    public Boolean getPartitionedTable()
    {
        return partitionedTable;
    }

    public List<String> getColumns()
    {
        return columns;
    }

    public abstract Boolean create();

    @Override
    public String toString()
    {
        return String.format("Table Name: %s, Database Name: %s, Partitioned Table: %s, Columns: %s",
                tableName, databaseName, partitionedTable, columns);
    }
}
