package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.SalesDetail;
/**
 * CSV file output for {@link SalesDetail}.
 */
public abstract class AbstractSalesDetailCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<?> getModelType() {
        return SalesDetail.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return SalesDetailCsvFormat.class;
    }
}