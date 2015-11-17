package com.example.batchapp.example.summarizeSales.byCategory.directio.prologue;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.input.BridgeInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.batchapp.example.summarizeSales.byCategory.directio.prologue.storeInfo.StageMapper0;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
/**
 * A client class for "directio".
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "prologue.directio") public final 
        class StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "example.summarizeSales";
    }
    @Override protected String getFlowId() {
        return "byCategory";
    }
    @Override protected String getStageId() {
        return "prologue.directio";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/prologue/directio";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        attributes.put("basePath", "master");
        attributes.put("resourcePath", "store_info.csv");
        attributes.put("optional", "false");
        attributes.put("dataClass", "com.example.modelgen.dmdl.model.StoreInfo");
        attributes.put("formatClass", "com.example.modelgen.dmdl.csv.StoreInfoCsvFormat");
        results.add(new StageInput("__DIRECTIO__/storeInfo/master", BridgeInputFormat.class, StageMapper0.class, 
                attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("storeInfo", NullWritable.class, StoreInfo.class, TemporaryOutputFormat.class));
        return results;
    }
}