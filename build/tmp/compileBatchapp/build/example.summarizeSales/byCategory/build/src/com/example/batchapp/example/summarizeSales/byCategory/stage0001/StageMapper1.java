package com.example.batchapp.example.summarizeSales.byCategory.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.MapperWithRuntimeResource;
import com.asakusafw.runtime.flow.VoidResult;
import com.asakusafw.runtime.stage.output.StageOutputDriver;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.batchapp.example.summarizeSales.byCategory.join.Join1;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A mapper class for processing{@code 
         * [sales->CategorySummaryOperator.checkStore(operator#1827969289){owner=FlowBlock&#64;366206379}]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0001", stageUnitId = "m1")@
        SuppressWarnings("deprecation") public final class StageMapper1 extends MapperWithRuntimeResource<NullWritable, 
        SalesDetail, NullWritable, NullWritable> {
    private SalesDetail cache = new SalesDetail();
    private StageOutputDriver outputs;
    private Join1 resource;
    private MapFragment1 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.outputs = new StageOutputDriver(context);
        this.resource = new Join1();
        this.resource.setup(context.getConfiguration());
        final Result<ErrorRecord> output = outputs.getResultSink("result0");
        final MapFragment2 line0 = new MapFragment2(output);
        this.line = new MapFragment1(resource, new VoidResult<SalesDetail>(), line0);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.outputs.close();
        this.outputs = null;
        if(this.resource != null) {
            this.resource.cleanup(context.getConfiguration());
            this.resource = null;
        }
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