package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.DataFormat;
import com.asakusafw.vocabulary.directio.DirectFileInputDescription;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * CSV file input for {@link CategorySummary}.
 */
public abstract class AbstractCategorySummaryCsvInputDescription extends DirectFileInputDescription {
    @Override public Class<?> getModelType() {
        return CategorySummary.class;
    }
    @Override public Class<? extends DataFormat<?>> getFormat() {
        return CategorySummaryCsvFormat.class;
    }
}