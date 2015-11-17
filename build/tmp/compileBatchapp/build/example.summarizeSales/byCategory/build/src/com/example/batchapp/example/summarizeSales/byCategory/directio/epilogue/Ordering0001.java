package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.io.util.InvertOrder;
import com.asakusafw.runtime.stage.directio.DirectOutputOrder;
import com.asakusafw.runtime.value.LongOption;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * An ordering output "categorySummary" class for "directio".
 */
public final class Ordering0001 extends DirectOutputOrder {
    private final LongOption sellingPriceTotal;
    /**
     * Creates a new instance.
     */
    public Ordering0001() {
        super(new InvertOrder(new LongOption()));
        this.sellingPriceTotal = (LongOption)((InvertOrder) this.get(0)).getEntity();
    }
    @SuppressWarnings("deprecation")@Override public void set(Object rawObject) {
        CategorySummary object = (CategorySummary) rawObject;
        this.sellingPriceTotal.copyFrom(object.getSellingPriceTotalOption());
    }
}