package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.ItemInfo;
/**
 * CSV file input for {@link ItemInfo}.
 */
public abstract class AbstractItemInfoCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<?> getModelType() {
        return ItemInfo.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return ItemInfoCsvFormat.class;
    }
}