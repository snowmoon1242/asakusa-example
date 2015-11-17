package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileOutputDescription;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * CSV file output for {@link CategorySummary}.
 */
public abstract class AbstractCategorySummaryCsvOutputDescription extends DirectFileOutputDescription {
    @Override public Class<?> getModelType() {
        return CategorySummary.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return CategorySummaryCsvFormat.class;
    }
}