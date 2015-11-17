package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.StoreInfo;
/**
 * CSV file input for {@link StoreInfo}.
 */
public abstract class AbstractStoreInfoCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<?> getModelType() {
        return StoreInfo.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return StoreInfoCsvFormat.class;
    }
}