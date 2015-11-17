package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.SalesDetail;
/**
 * CSV file input for {@link SalesDetail}.
 */
public abstract class AbstractSalesDetailCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<?> getModelType() {
        return SalesDetail.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return SalesDetailCsvFormat.class;
    }
}