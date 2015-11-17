package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.StringTemplate;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 * A naming output "errorRecord" class for "directio".
 */
@SuppressWarnings("deprecation") public final class Naming0002 extends StringTemplate {
    /**
     * Creates a new instance.
     */
    public Naming0002() {
        super(new StringTemplate.FormatSpec(StringTemplate.Format.PLAIN, "${date}.csv"));
    }
    @Override public void set(Object rawObject) {
        ErrorRecord object = (ErrorRecord) rawObject;
    }
}