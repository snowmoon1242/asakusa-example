package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.AbstractDirectOutputValue;
import com.asakusafw.runtime.stage.directio.DirectOutputSpec;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.csv.CategorySummaryCsvFormat;
import com.example.modelgen.dmdl.csv.ErrorRecordCsvFormat;
import com.example.modelgen.dmdl.model.CategorySummary;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "epilogue.directio") public final 
        class ShuffleValue extends AbstractDirectOutputValue {
    /**
     * Creates a new instance.
     */
    public ShuffleValue() {
        super(new DirectOutputSpec[]{new DirectOutputSpec(CategorySummary.class, "result/category", 
                    CategorySummaryCsvFormat.class, Naming0001.class, Ordering0001.class), new DirectOutputSpec(
                    ErrorRecord.class, "result/error", ErrorRecordCsvFormat.class, Naming0002.class, Ordering0002.class)
                });
    }
}