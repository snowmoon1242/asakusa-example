package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.AbstractStageClient;
import com.asakusafw.runtime.stage.StageInput;
import com.asakusafw.runtime.stage.StageOutput;
import com.asakusafw.runtime.stage.directio.DirectOutputReducer;
import com.asakusafw.runtime.stage.input.TemporaryInputFormat;
import com.asakusafw.runtime.stage.output.BridgeOutputFormat;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.modelgen.dmdl.model.CategorySummary;
import com.example.modelgen.dmdl.model.ErrorRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.io.NullWritable;
/**
 * A client class for "directio".
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "epilogue.directio") public final 
        class StageClient extends AbstractStageClient {
    @Override protected String getBatchId() {
        return "example.summarizeSales";
    }
    @Override protected String getFlowId() {
        return "byCategory";
    }
    @Override protected String getStageId() {
        return "epilogue.directio";
    }
    @Override protected String getStageOutputPath() {
        return "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/epilogue/directio";
    }
    @Override protected List<StageInput> getStageInputs() {
        List<StageInput> results = new ArrayList<StageInput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        results.add(new StageInput(
                "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/stage0003/result0-*", 
                TemporaryInputFormat.class, StageMapper0.class, attributes));
        attributes = new HashMap<String, String>();
        results.add(new StageInput(
                "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/stage0001/result0-*", 
                TemporaryInputFormat.class, StageMapper1.class, attributes));
        attributes = new HashMap<String, String>();
        results.add(new StageInput(
                "target/hadoopwork/${execution_id}/example.summarizeSales/byCategory/stage0002/result10-*", 
                TemporaryInputFormat.class, StageMapper1.class, attributes));
        return results;
    }
    @Override protected List<StageOutput> getStageOutputs() {
        List<StageOutput> results = new ArrayList<StageOutput>();
        Map<String, String> attributes = null;
        attributes = new HashMap<String, String>();
        results.add(new StageOutput("result/category", NullWritable.class, CategorySummary.class, BridgeOutputFormat.
                class, attributes));
        attributes = new HashMap<String, String>();
        results.add(new StageOutput("result/error", NullWritable.class, ErrorRecord.class, BridgeOutputFormat.class, 
                attributes));
        return results;
    }
    @Override protected Class<ShuffleKey> getShuffleKeyClassOrNull() {
        return ShuffleKey.class;
    }
    @Override protected Class<ShuffleValue> getShuffleValueClassOrNull() {
        return ShuffleValue.class;
    }
    @Override protected Class<ShuffleGroupingComparator> getGroupingComparatorClassOrNull() {
        return ShuffleGroupingComparator.class;
    }
    @Override protected Class<ShuffleSortComparator> getSortComparatorClassOrNull() {
        return ShuffleSortComparator.class;
    }
    @Override protected Class<com.asakusafw.runtime.io.util.ShuffleKey.Partitioner> getPartitionerClassOrNull() {
        return com.asakusafw.runtime.io.util.ShuffleKey.Partitioner.class;
    }
    @Override protected Class<DirectOutputReducer> getReducerClassOrNull() {
        return DirectOutputReducer.class;
    }
}