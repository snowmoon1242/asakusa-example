package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ItemInfo;
/**
 * A mapper fragment for processing{@code [in->padding(pseud#1526876238)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", fragmentId = "2")@
        SuppressWarnings("deprecation") public final class MapFragment2 implements Result<ItemInfo> {
    private final Result<ItemInfo> out;
    /**
     * Creates a new instance.
     * @param out output for {@code padding#out}.
     */
    public MapFragment2(Result<ItemInfo> out) {
        this.out = out;
    }
    @Override public void add(ItemInfo result) {
        this.out.add(result);
    }
}