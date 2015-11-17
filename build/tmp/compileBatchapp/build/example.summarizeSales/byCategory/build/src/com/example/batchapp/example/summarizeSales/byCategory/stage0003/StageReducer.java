package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.Rendezvous;
import com.asakusafw.runtime.flow.SegmentedReducer;
import com.asakusafw.runtime.stage.output.StageOutputDriver;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.CategorySummary;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A reducer class for processing stage <code>3</code>.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0003", stageUnitId = "r")@
        SuppressWarnings("deprecation") public final class StageReducer extends SegmentedReducer<ShuffleKey, 
        ShuffleValue, NullWritable, NullWritable> {
    private StageOutputDriver outputs;
    private ReduceFragment2 rendezvous;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.outputs = new StageOutputDriver(context);
        final Result<CategorySummary> output = outputs.getResultSink("result0");
        this.rendezvous = new ReduceFragment2(output);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.outputs.close();
        this.outputs = null;
        this.rendezvous = null;
    }
    @Override protected Rendezvous<ShuffleValue> getRendezvous(ShuffleKey nextKey) {
        switch(nextKey.getSegmentId()) {
            case 1:
                return this.rendezvous;
            default:
                throw new AssertionError();
        }
    }
}