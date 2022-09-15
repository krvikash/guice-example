package io.starburst.example.guice.metadata.impl;

import com.google.inject.Inject;
import io.starburst.example.guice.metadata.TableMetadata;
import io.starburst.example.guice.annotations.Column;
import io.starburst.example.guice.annotations.DatabaseName;
import io.starburst.example.guice.annotations.PartitionedTable;
import io.starburst.example.guice.annotations.TableName;

import java.util.Collections;
import java.util.List;

public class HiveTableMetadata extends TableMetadata
{
    public HiveTableMetadata() {
        super("empty", "empty", false, Collections.emptyList());
    }

    @Inject
    public HiveTableMetadata(@TableName String tableName, @DatabaseName String databaseName, @PartitionedTable Boolean partitionedTable,
            @Column List<String> columns)
    {
        super(tableName, databaseName, partitionedTable, columns);
    }

    @Override
    public Boolean create()
    {
        System.out.println("Hive Table Created. " + this.toString());
        return true;
    }
}
