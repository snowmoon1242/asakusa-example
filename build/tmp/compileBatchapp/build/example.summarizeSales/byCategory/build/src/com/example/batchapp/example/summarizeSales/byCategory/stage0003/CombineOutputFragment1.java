package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ResultOutput;
import com.example.modelgen.dmdl.model.CategorySummary;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * A shuffle fragment for processing{@code info->CategorySummaryOperator.summarizeByCategory(operator#910991883)}.
 */
@SuppressWarnings("deprecation") public final class CombineOutputFragment1 implements Result<CategorySummary> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * Creates a new instance.
     * @param collector output collector
     */
    public CombineOutputFragment1(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(CategorySummary result) {
        this.key.setPort1(result);
        this.value.setPort1(result);
        ResultOutput.write(this.collector, this.key, this.value);
    }
}