package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.trace.TraceLocation;
/**
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "epilogue.directio") public final 
        class ShuffleSortComparator extends com.asakusafw.runtime.io.util.ShuffleKey.AbstractOrderComparator {
    /**
     * Creates a new instance.
     */
    public ShuffleSortComparator() {
        super(ShuffleKey.class);
    }
}