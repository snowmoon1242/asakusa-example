package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * A reducer fragment for processing{@code [info->CategorySummaryOperator.summarizeByCategory(operator#910991883)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0003", fragmentId = "2")@
        SuppressWarnings("deprecation") public final class ReduceFragment2 extends com.asakusafw.runtime.flow.Rendezvous
        <ShuffleValue> {
    private final Result<CategorySummary> out;
    private boolean initialized;
    private CategorySummary cache = new CategorySummary();
    /**
     * Creates a new instance.
     * @param out output for {@code CategorySummaryOperator.summarizeByCategory#out}.
     */
    public ReduceFragment2(Result<CategorySummary> out) {
        this.out = out;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.initialized = false;
    }
    @Override public void end() {
        this.out.add(this.cache);
    }
    private void process0001(CategorySummary value) {
        if(this.initialized) {
            this.cache.getAmountTotalOption().add(value.getAmountTotalOption());
            this.cache.getSellingPriceTotalOption().add(value.getSellingPriceTotalOption());
        }
        else {
            this.cache.copyFrom(value);
            this.initialized = true;
        }
    }
}