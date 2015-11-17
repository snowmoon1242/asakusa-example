package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 * CSV file output for {@link ErrorRecord}.
 */
public abstract class AbstractErrorRecordCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<?> getModelType() {
        return ErrorRecord.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return ErrorRecordCsvFormat.class;
    }
}