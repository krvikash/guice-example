package io.starburst.example.guice.creator.impl;

import io.starburst.example.guice.creator.ITableCreator;
import io.starburst.example.guice.metadata.impl.IcebergTableMetadata;

public class IcebergTableCreator implements ITableCreator
{
    private IcebergTableMetadata icebergTableMetadata;

    public IcebergTableCreator(IcebergTableMetadata icebergTableMetadata) {
        this.icebergTableMetadata = icebergTableMetadata;
    }
    @Override
    public Boolean create()
    {
        return this.icebergTableMetadata.create();
    }
}
