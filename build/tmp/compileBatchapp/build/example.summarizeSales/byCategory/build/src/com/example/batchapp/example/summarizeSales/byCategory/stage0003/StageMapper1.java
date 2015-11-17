package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.flow.MapperWithRuntimeResource;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A mapper class for processing{@code [in->padding(pseud#1629658118){owner=FlowBlock&#64;422546775}]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0003", stageUnitId = "m1")@
        SuppressWarnings("deprecation") public final class StageMapper1 extends MapperWithRuntimeResource<NullWritable, 
        JoinedSalesInfo, ShuffleKey, ShuffleValue> {
    private JoinedSalesInfo cache = new JoinedSalesInfo();
    private MapFragment1 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line = new MapFragment1(shuffle);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.line = null;
    }
    @Override public void runInternal(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
        }
        this.cleanup(context);
    }
}