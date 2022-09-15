package io.starburst.test.example.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.starburst.example.guice.creator.ITableCreator;
import io.starburst.example.guice.creator.impl.HiveTableCreator;
import io.starburst.example.guice.creator.impl.IcebergTableCreator;
import io.starburst.example.guice.metadata.impl.IcebergTableMetadata;
import io.starburst.example.guice.module.HiveModule;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DriverTest
{
    @Test
    public void testHive()
    {
        Injector injector = Guice.createInjector(new HiveModule());
        ITableCreator hiveTableCreator = injector.getInstance(HiveTableCreator.class);
        Assert.assertTrue(hiveTableCreator.create());
    }

    @Test
    public void testIceberg()
    {
        IcebergTableMetadata icebergTableMetadata = new IcebergTableMetadata("iceberg-table-1", "default",
                true, Arrays.asList("id", "name", "age"));
        ITableCreator icebergTableCreator = new IcebergTableCreator(icebergTableMetadata);
        Assert.assertTrue(icebergTableCreator.create());
    }
}
