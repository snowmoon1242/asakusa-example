package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.ItemInfo;
/**
 * CSV file output for {@link ItemInfo}.
 */
public abstract class AbstractItemInfoCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<?> getModelType() {
        return ItemInfo.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return ItemInfoCsvFormat.class;
    }
}