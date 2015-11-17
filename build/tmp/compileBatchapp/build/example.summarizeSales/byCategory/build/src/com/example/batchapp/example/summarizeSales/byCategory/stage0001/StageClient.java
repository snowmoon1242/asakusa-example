package com.example.batchapp.example.summarizeSales.byCategory.stage0001;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.StageResource;
import com.asakusafw.runtime.stage.input.BridgeInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
/**
 * Hadoop job client for stage <code>1</code>.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0001") public final class 
        StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "example.summarizeSales";
    }
    @Override protected String getFlowId() {
        return "byCategory";
    }
    @Override protected String getStageId() {
        return "stage0001";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/stage0001";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        attributes.put("basePath", "sales");
        attributes.put("resourcePath", "**/*.csv");
        attributes.put("optional", "false");
        attributes.put("dataClass", "com.example.modelgen.dmdl.model.SalesDetail");
        attributes.put("formatClass", "com.example.modelgen.dmdl.csv.SalesDetailCsvFormat");
        results.add(new StageInput("__DIRECTIO__/salesDetail/sales", BridgeInputFormat.class, StageMapper1.class, 
                attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("result0", NullWritable.class, ErrorRecord.class, TemporaryOutputFormat.class));
        return results;
    }
    @Override protected List<StageResource> getStageResources() {
        List<StageResource> results = new ArrayList<StageResource>();
        results.add(new StageResource(
                "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/prologue/directio/storeInfo-*", 
                "storeInfo"));
        return results;
    }
}