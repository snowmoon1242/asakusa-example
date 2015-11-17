package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ResultOutput;
import com.example.modelgen.dmdl.model.CategorySummary;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * A shuffle fragment for processing{@code info->CategorySummaryOperator.summarizeByCategory(operator#910991883)}.
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment1 implements Result<JoinedSalesInfo> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    private CategorySummary cache = new CategorySummary();
    /**
     * Creates a new instance.
     * @param collector output collector
     */
    public MapOutputFragment1(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(JoinedSalesInfo result) {
        this.cache.setCategoryCodeOption(result.getCategoryCodeOption());
        this.cache.getAmountTotalOption().modify(result.getAmountOption().get());
        this.cache.getSellingPriceTotalOption().modify(result.getSellingPriceOption().get());
        this.key.setPort1(this.cache);
        this.value.setPort1(this.cache);
        ResultOutput.write(this.collector, this.key, this.value);
    }
}