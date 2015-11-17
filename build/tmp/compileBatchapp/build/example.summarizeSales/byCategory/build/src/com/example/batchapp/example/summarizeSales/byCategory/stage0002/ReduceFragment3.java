package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ArrayListBuffer;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ItemInfo;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.operator.CategorySummaryOperatorImpl;
/**
 * A reducer fragment for processing{@code 
         * [info->CategorySummaryOperator.joinItemInfo(operator#2089940034), sales->CategorySummaryOperator.joinItemInfo(operator#2089940034)]
         * }.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", fragmentId = "3")@
        SuppressWarnings("deprecation") public final class ReduceFragment3 extends com.asakusafw.runtime.flow.Rendezvous
        <ShuffleValue> {
    private final Result<JoinedSalesInfo> joined;
    private final Result<SalesDetail> missed;
    private ArrayListBuffer<ItemInfo> list = new ArrayListBuffer<ItemInfo>();
    private CategorySummaryOperatorImpl op = new CategorySummaryOperatorImpl();
    private JoinedSalesInfo cache = new JoinedSalesInfo();
    /**
     * Creates a new instance.
     * @param joined output for {@code CategorySummaryOperator.joinItemInfo#joined}.
     * @param missed output for {@code CategorySummaryOperator.joinItemInfo#missed}.
     */
    public ReduceFragment3(Result<JoinedSalesInfo> joined, Result<SalesDetail> missed) {
        this.joined = joined;
        this.missed = missed;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.list.begin();
    }
    @Override public void end() {
        this.list.end();
        this.list.shrink();
    }
    private void process0001(ItemInfo value) {
        if(this.list.isExpandRequired()) {
            this.list.expand(new ItemInfo());
            this.list.advance().copyFrom(value);
        }
        else {
            this.list.advance().copyFrom(value);
        }
    }
    private void process0002(SalesDetail value) {
        this.list.end();
        ItemInfo selected = this.op.selectAvailableItem(this.list, value);
        if(selected != null) {
            this.cache.reset();
            this.cache.setItemCodeOption(value.getItemCodeOption());
            this.cache.setAmountOption(value.getAmountOption());
            this.cache.setSellingPriceOption(value.getSellingPriceOption());
            this.cache.setCategoryCodeOption(selected.getCategoryCodeOption());
            this.joined.add(this.cache);
        }
        else {
            this.missed.add(value);
        }
    }
}