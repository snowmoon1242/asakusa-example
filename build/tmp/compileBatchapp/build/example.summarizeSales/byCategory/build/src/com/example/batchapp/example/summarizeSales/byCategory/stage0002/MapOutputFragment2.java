package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ResultOutput;
import com.example.modelgen.dmdl.model.SalesDetail;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * A shuffle fragment for processing{@code sales->CategorySummaryOperator.joinItemInfo(operator#2089940034)}.
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment2 implements Result<SalesDetail> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * Creates a new instance.
     * @param collector output collector
     */
    public MapOutputFragment2(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(SalesDetail result) {
        this.key.setPort2(result);
        this.value.setPort2(result);
        ResultOutput.write(this.collector, this.key, this.value);
    }
}