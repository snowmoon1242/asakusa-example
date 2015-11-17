package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 * CSV file input for {@link ErrorRecord}.
 */
public abstract class AbstractErrorRecordCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<?> getModelType() {
        return ErrorRecord.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return ErrorRecordCsvFormat.class;
    }
}