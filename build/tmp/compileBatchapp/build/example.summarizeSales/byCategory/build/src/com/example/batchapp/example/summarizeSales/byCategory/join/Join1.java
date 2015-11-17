package com.example.batchapp.example.summarizeSales.byCategory.join;
import com.asakusafw.runtime.flow.join.JoinResource;
import com.asakusafw.runtime.flow.join.LookUpKey;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.io.IOException;
/**
 * Represents side-data join action between {@link StoreInfo}and{@link SalesDetail}.
 */
public class Join1 extends JoinResource<StoreInfo, SalesDetail> {
    protected String getCacheName() {
        return "storeInfo";
    }
    protected StoreInfo createValueObject() {
        return new StoreInfo();
    }
    protected LookUpKey buildLeftKey(StoreInfo value, LookUpKey key) throws IOException {
        key.add(value.getStoreCodeOption());
        return key;
    }
    protected LookUpKey buildRightKey(SalesDetail value, LookUpKey key) throws IOException {
        key.add(value.getStoreCodeOption());
        return key;
    }
}