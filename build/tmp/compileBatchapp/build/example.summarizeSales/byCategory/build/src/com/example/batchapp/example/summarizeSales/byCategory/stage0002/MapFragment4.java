package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.operator.CategorySummaryOperatorImpl;
/**
 * A mapper fragment for processing{@code [in->restructure(operator#1379621106)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", fragmentId = "4")@
        SuppressWarnings("deprecation") public final class MapFragment4 implements Result<SalesDetail> {
    private final Result<ErrorRecord> out;
    private ErrorRecord cache = new ErrorRecord();
    private CategorySummaryOperatorImpl op = new CategorySummaryOperatorImpl();
    /**
     * Creates a new instance.
     * @param out output for {@code CategorySummaryOperator.setErrorMessage#out}.
     */
    public MapFragment4(Result<ErrorRecord> out) {
        this.out = out;
    }
    @Override public void add(SalesDetail result) {
        this.cache.reset();
        this.cache.setFileNameOption(result.getFileNameOption());
        this.cache.setStoreCodeOption(result.getStoreCodeOption());
        this.cache.setItemCodeOption(result.getItemCodeOption());
        this.cache.setSalesDateTimeOption(result.getSalesDateTimeOption());
        this.op.setErrorMessage(this.cache, "商品不明");
        this.out.add(this.cache);
    }
}