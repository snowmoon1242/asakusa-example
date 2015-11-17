package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.flow.SegmentedWritable;
import com.example.modelgen.dmdl.model.CategorySummary;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * The shuffle value class for stage <code>3</code>.
 */
@SuppressWarnings("deprecation") public final class ShuffleValue implements SegmentedWritable {
    /**
     * the shuffle segment ID.
     */
    public int segmentId = -1;
    @Override public int getSegmentId() {
        return this.segmentId;
    }
    /**
     * data model for CategorySummaryOperator.summarizeByCategory#info (1).
     */
    public CategorySummary port0001 = new CategorySummary();
    /**
     * Return a data model object for CategorySummaryOperator.summarizeByCategory#info.
     */
    public CategorySummary getPort1() {
        if(this.segmentId != 1) throw new AssertionError();
        return this.port0001;
    }
    /**
     * 
             * Sets a data model object for the successing operator input <code>CategorySummaryOperator.summarizeByCategory#info</code>.
     * @param model the target data model object
     */
    public void setPort1(CategorySummary model) {
        this.segmentId = 1;
        this.port0001.copyFrom(model);
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.segmentId) {
            case 1:
                out.writeInt(1);
                this.port0001.write(out);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
    @Override public void readFields(DataInput in) throws IOException {
        this.segmentId = in.readInt();
        switch(this.segmentId) {
            case 1:
                this.port0001.readFields(in);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
}