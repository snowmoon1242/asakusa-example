package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.trace.TraceLocation;
import com.example.batchapp.example.summarizeSales.byCategory.join.Join1;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.util.List;
/**
 * A mapper fragment for processing{@code [sales->CategorySummaryOperator.checkStore(operator#2124892015)]}.
 */
@TraceLocation(batchId = "example.summarizeSales", flowId = "byCategory", stageId = "stage0002", fragmentId = "1")@
        SuppressWarnings("deprecation") public final class MapFragment1 implements Result<SalesDetail> {
    private final Join1 resource;
    private final Result<SalesDetail> found;
    private final Result<SalesDetail> missed;
    /**
     * Creates a new instance.
     * @param resource 
             * storeInfo(left=DataModelClass(com.example.modelgen.dmdl.model.StoreInfo)[ValueOptionProperty(storeCode:class com.asakusafw.runtime.value.StringOption)], DataModelClass(com.example.modelgen.dmdl.model.SalesDetail)[ValueOptionProperty(storeCode:class com.asakusafw.runtime.value.StringOption)])
     * @param found output for {@code CategorySummaryOperator.checkStore#found}.
     * @param missed output for {@code CategorySummaryOperator.checkStore#missed}.
     */
    public MapFragment1(Join1 resource, Result<SalesDetail> found, Result<SalesDetail> missed) {
        this.resource = resource;
        this.found = found;
        this.missed = missed;
    }
    @Override public void add(SalesDetail result) {
        List<StoreInfo> v = this.resource.find(result);
        if(v.isEmpty() == false) {
            this.found.add(result);
        }
        else {
            this.missed.add(result);
        }
    }
}