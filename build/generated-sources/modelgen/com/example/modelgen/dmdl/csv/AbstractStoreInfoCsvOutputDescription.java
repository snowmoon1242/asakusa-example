package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.StoreInfo;
/**
 * CSV file output for {@link StoreInfo}.
 */
public abstract class AbstractStoreInfoCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<?> getModelType() {
        return StoreInfo.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return StoreInfoCsvFormat.class;
    }
}