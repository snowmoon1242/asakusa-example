package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.AbstractDirectOutputMapper;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "epilogue.directio") public final 
        class StageMapper0 extends AbstractDirectOutputMapper<CategorySummary> {
    /**
     * Creates a new instance.
     */
    public StageMapper0() {
        super(0, ShuffleKey.class, ShuffleValue.class);
    }
}