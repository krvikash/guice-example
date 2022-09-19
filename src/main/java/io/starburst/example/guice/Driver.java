package io.starburst.example.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.starburst.example.guice.creator.impl.HiveTableCreator;
import io.starburst.example.guice.creator.ITableCreator;
import io.starburst.example.guice.creator.impl.IcebergTableCreator;
import io.starburst.example.guice.metadata.impl.IcebergTableMetadata;
import io.starburst.example.guice.module.HiveModule;

import java.util.Arrays;

/**
 *  <a href="https://trino.io">...</a>
 */
public class Driver
{
    enum ConnectorType {
        HIVE,
        ICEBERG,
    };

    public static void main(String[] args)
    {
        createRequest(ConnectorType.HIVE);
        createRequest(ConnectorType.ICEBERG);
    }

    public static void createRequest(ConnectorType connectorType) {
        if (connectorType.equals(ConnectorType.HIVE)) {
            // Using Guice
            Injector injector = Guice.createInjector(new HiveModule());
            ITableCreator hiveTableCreator = injector.getInstance(HiveTableCreator.class);
            hiveTableCreator.create();
        } else if (connectorType.equals(ConnectorType.ICEBERG)) {
            // Using Core Java
            IcebergTableMetadata icebergTableMetadata = new IcebergTableMetadata("iceberg-table-1", "default",
                    true, Arrays.asList("id", "name", "age"));
            ITableCreator icebergTableCreator = new IcebergTableCreator(icebergTableMetadata);
            icebergTableCreator.create();
        } else {
            throw new RuntimeException(connectorType.name() + " is not supported.");
        }
    }
}
