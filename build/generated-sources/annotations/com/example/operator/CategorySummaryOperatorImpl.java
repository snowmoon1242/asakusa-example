package com.example.operator;
import com.example.modelgen.dmdl.model.CategorySummary;
import com.example.modelgen.dmdl.model.ItemInfo;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.modelgen.dmdl.model.StoreInfo;
import javax.annotation.Generated;
/**
 * An operator implementation class for{@link CategorySummaryOperator}.
 */
@Generated("OperatorImplementationClassGenerator:0.1.0") public class CategorySummaryOperatorImpl extends 
        CategorySummaryOperator {
    /**
     * Creates a new instance.
     */
    public CategorySummaryOperatorImpl() {
        return;
    }
    @Override public CategorySummary summarizeByCategory(JoinedSalesInfo info) {
        throw new UnsupportedOperationException("単純集計演算子は組み込みの方法で処理されます");
    }
    @Override public boolean checkStore(StoreInfo info, SalesDetail sales) {
        throw new UnsupportedOperationException("マスタ確認演算子は組み込みの方法で処理されます");
    }
    @Override public JoinedSalesInfo joinItemInfo(ItemInfo info, SalesDetail sales) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
}