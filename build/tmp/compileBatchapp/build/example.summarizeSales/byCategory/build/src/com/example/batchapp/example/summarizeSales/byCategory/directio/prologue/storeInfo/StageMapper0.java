package com.example.batchapp.example.summarizeSales.byCategory.directio.prologue.storeInfo;
import com.asakusafw.runtime.stage.preparator.PreparatorMapper;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.StoreInfo;
/**
 * Mapper for input "storeInfo" in prologue phase.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "prologue.directio") public class 
        StageMapper0 extends PreparatorMapper<StoreInfo> {
    @Override public String getOutputName() {
        return "storeInfo";
    }
}