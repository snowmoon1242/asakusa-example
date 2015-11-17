package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ResultOutput;
import com.example.modelgen.dmdl.model.ItemInfo;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
/**
 * A shuffle fragment for processing{@code info->CategorySummaryOperator.joinItemInfo(operator#2089940034)}.
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment1 implements Result<ItemInfo> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * Creates a new instance.
     * @param collector output collector
     */
    public MapOutputFragment1(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(ItemInfo result) {
        this.key.setPort1(result);
        this.value.setPort1(result);
        ResultOutput.write(this.collector, this.key, this.value);
    }
}