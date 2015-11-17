package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.flow.MapperWithRuntimeResource;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ItemInfo;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A mapper class for processing{@code [in->padding(pseud#1526876238){owner=FlowBlock&#64;1192608590}]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", stageUnitId = "m2")@
        SuppressWarnings("deprecation") public final class StageMapper2 extends MapperWithRuntimeResource<NullWritable, 
        ItemInfo, ShuffleKey, ShuffleValue> {
    private ItemInfo cache = new ItemInfo();
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        final MapOutputFragment1 shuffle = new MapOutputFragment1(context);
        this.line = new MapFragment2(shuffle);
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