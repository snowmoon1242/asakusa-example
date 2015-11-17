package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
/**
 * A mapper fragment for processing{@code [in->padding(pseud#1629658118)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0003", fragmentId = "1")@
        SuppressWarnings("deprecation") public final class MapFragment1 implements Result<JoinedSalesInfo> {
    private final Result<JoinedSalesInfo> out;
    /**
     * Creates a new instance.
     * @param out output for {@code padding#out}.
     */
    public MapFragment1(Result<JoinedSalesInfo> out) {
        this.out = out;
    }
    @Override public void add(JoinedSalesInfo result) {
        this.out.add(result);
    }
}