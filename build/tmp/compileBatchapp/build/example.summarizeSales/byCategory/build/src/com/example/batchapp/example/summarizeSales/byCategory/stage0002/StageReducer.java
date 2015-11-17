package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.Rendezvous;
import com.asakusafw.runtime.flow.SegmentedReducer;
import com.asakusafw.runtime.stage.output.StageOutputDriver;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A reducer class for processing stage <code>2</code>.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", stageUnitId = "r")@
        SuppressWarnings("deprecation") public final class StageReducer extends SegmentedReducer<ShuffleKey, 
        ShuffleValue, NullWritable, NullWritable> {
    private StageOutputDriver outputs;
    private ReduceFragment3 rendezvous;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.outputs = new StageOutputDriver(context);
        final Result<ErrorRecord> output0 = outputs.getResultSink("result10");
        final MapFragment4 line = new MapFragment4(output0);
        final Result<JoinedSalesInfo> output = outputs.getResultSink("result0");
        this.rendezvous = new ReduceFragment3(output, line);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.outputs.close();
        this.outputs = null;
        this.rendezvous = null;
    }
    @Override protected Rendezvous<ShuffleValue> getRendezvous(ShuffleKey nextKey) {
        switch(nextKey.getSegmentId()) {
            case 1:
            case 2:
                return this.rendezvous;
            default:
                throw new AssertionError();
        }
    }
}