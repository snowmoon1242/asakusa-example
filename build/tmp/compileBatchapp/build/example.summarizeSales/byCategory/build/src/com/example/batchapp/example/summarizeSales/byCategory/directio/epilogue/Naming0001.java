package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.StringTemplate;
import com.example.modelgen.dmdl.model.CategorySummary;
/**
 * A naming output "categorySummary" class for "directio".
 */
@SuppressWarnings("deprecation") public final class Naming0001 extends StringTemplate {
    /**
     * Creates a new instance.
     */
    public Naming0001() {
        super(new StringTemplate.FormatSpec(StringTemplate.Format.PLAIN, "result.csv"));
    }
    @Override public void set(Object rawObject) {
        CategorySummary object = (CategorySummary) rawObject;
    }
}