package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.flow.MapperWithRuntimeResource;
import com.asakusafw.runtime.flow.VoidResult;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.batchapp.example.summarizeSales.byCategory.join.Join1;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
/**
 * A mapper class for processing{@code 
         * [sales->CategorySummaryOperator.checkStore(operator#2124892015){owner=FlowBlock&#64;1192608590}]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", stageUnitId = "m1")@
        SuppressWarnings("deprecation") public final class StageMapper1 extends MapperWithRuntimeResource<NullWritable, 
        SalesDetail, ShuffleKey, ShuffleValue> {
    private SalesDetail cache = new SalesDetail();
    private Join1 resource;
    private MapFragment1 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.resource = new Join1();
        this.resource.setup(context.getConfiguration());
        final MapOutputFragment2 shuffle0 = new MapOutputFragment2(context);
        this.line = new MapFragment1(resource, shuffle0, new VoidResult<SalesDetail>());
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
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