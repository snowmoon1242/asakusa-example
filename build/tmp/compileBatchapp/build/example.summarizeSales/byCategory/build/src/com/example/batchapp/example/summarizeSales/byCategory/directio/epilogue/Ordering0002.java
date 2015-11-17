package com.example.batchapp.example.summarizeSales.byCategory.directio.epilogue;
import com.asakusafw.runtime.stage.directio.DirectOutputOrder;
import com.asakusafw.runtime.value.StringOption;
import com.example.modelgen.dmdl.model.ErrorRecord;
/**
 * An ordering output "errorRecord" class for "directio".
 */
public final class Ordering0002 extends DirectOutputOrder {
    private final StringOption fileName;
    /**
     * Creates a new instance.
     */
    public Ordering0002() {
        super(new StringOption());
        this.fileName = (StringOption) this.get(0);
    }
    @SuppressWarnings("deprecation")@Override public void set(Object rawObject) {
        ErrorRecord object = (ErrorRecord) rawObject;
        this.fileName.copyFrom(object.getFileNameOption());
    }
}