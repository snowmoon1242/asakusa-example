package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.StageResource;
import com.asakusafw.runtime.stage.input.BridgeInputFormat;
import com.asakusafw.runtime.stage.output.TemporaryOutputFormat;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
/**
 * Hadoop job client for stage <code>2</code>.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002") public final class 
        StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "example.summarizeSales";
    }
    @Override protected String getFlowId() {
        return "byCategory";
    }
    @Override protected String getStageId() {
        return "stage0002";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/stage0002";
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
        attributes = new HashMap<String, String>();
        attributes.put("basePath", "master");
        attributes.put("resourcePath", "item_info.csv");
        attributes.put("optional", "false");
        attributes.put("dataClass", "com.example.modelgen.dmdl.model.ItemInfo");
        attributes.put("formatClass", "com.example.modelgen.dmdl.csv.ItemInfoCsvFormat");
        results.add(new StageInput("__DIRECTIO__/itemInfo/master", BridgeInputFormat.class, StageMapper2.class, 
                attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        results.add(new StageOutput("result0", NullWritable.class, JoinedSalesInfo.class, TemporaryOutputFormat.class));
        results.add(new StageOutput("result10", NullWritable.class, ErrorRecord.class, TemporaryOutputFormat.class));
        return results;
    }
    @Override protected List<StageResource> getStageResources() {
        List<StageResource> results = new ArrayList<StageResource>();
        results.add(new StageResource(
                "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/prologue/directio/storeInfo-*", 
                "storeInfo"));
        return results;
    }
    @Override protected Class<ShuffleKey> getShuffleKeyClassOrNull() {
        return ShuffleKey.class;
    }
    @Override protected Class<ShuffleValue> getShuffleValueClassOrNull() {
        return ShuffleValue.class;
    }
    @Override protected Class<ShufflePartitioner> getPartitionerClassOrNull() {
        return ShufflePartitioner.class;
    }
    @Override protected Class<ShuffleSortComparator> getSortComparatorClassOrNull() {
        return ShuffleSortComparator.class;
    }
    @Override protected Class<ShuffleGroupingComparator> getGroupingComparatorClassOrNull() {
        return ShuffleGroupingComparator.class;
    }
    @Override protected Class<StageReducer> getReducerClassOrNull() {
        return StageReducer.class;
    }
}