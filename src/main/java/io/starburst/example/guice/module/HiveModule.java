package io.starburst.example.guice.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import io.starburst.example.guice.metadata.TableMetadata;
import io.starburst.example.guice.annotations.Column;
import io.starburst.example.guice.annotations.DatabaseName;
import io.starburst.example.guice.annotations.PartitionedTable;
import io.starburst.example.guice.annotations.TableName;
import io.starburst.example.guice.metadata.impl.HiveTableMetadata;

import java.util.Arrays;
import java.util.List;

public class HiveModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        binder.bind(TableMetadata.class).to(HiveTableMetadata.class);
        binder.bind(String.class).annotatedWith(TableName.class).toInstance("hive-table-guice-1");
        binder.bind(String.class).annotatedWith(DatabaseName.class).toInstance("hive-database-guice-1");
        binder.bind(Boolean.class).annotatedWith(PartitionedTable.class).toInstance(true);
        binder.bind(new TypeLiteral<List<String>>() {}).annotatedWith(Column.class).toInstance(Arrays.asList("id", "name", "age"));
    }
}
