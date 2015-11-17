package com.example.batchapp.example.summarizeSales.byCategory.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.operator.CategorySummaryOperatorImpl;
/**
 * A mapper fragment for processing{@code [in->restructure(operator#1518054007)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0001", fragmentId = "2")@
        SuppressWarnings("deprecation") public final class MapFragment2 implements Result<SalesDetail> {
    private final Result<ErrorRecord> out;
    private ErrorRecord cache = new ErrorRecord();
    private CategorySummaryOperatorImpl op = new CategorySummaryOperatorImpl();
    /**
     * Creates a new instance.
     * @param out output for {@code CategorySummaryOperator.setErrorMessage#out}.
     */
    public MapFragment2(Result<ErrorRecord> out) {
        this.out = out;
    }
    @Override public void add(SalesDetail result) {
        this.cache.reset();
        this.cache.setFileNameOption(result.getFileNameOption());
        this.cache.setStoreCodeOption(result.getStoreCodeOption());
        this.cache.setItemCodeOption(result.getItemCodeOption());
        this.cache.setSalesDateTimeOption(result.getSalesDateTimeOption());
        this.op.setErrorMessage(this.cache, "店舗不明");
        this.out.add(this.cache);
    }
}