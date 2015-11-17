package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.AbstractDirectOutputMapper;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "epilogue.directio") public final 
        class StageMapper1 extends AbstractDirectOutputMapper<ErrorRecord> {
    /**
     * Creates a new instance.
     */
    public StageMapper1() {
        super(1, ShuffleKey.class, ShuffleValue.class);
    }
}