package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.flow.SegmentedWritable;
import com.example.modelgen.dmdl.model.ItemInfo;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * The shuffle value class for stage <code>2</code>.
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
     * data model for CategorySummaryOperator.joinItemInfo#info (1).
     */
    public ItemInfo port0001 = new ItemInfo();
    /**
     * data model for CategorySummaryOperator.joinItemInfo#sales (2).
     */
    public SalesDetail port0002 = new SalesDetail();
    /**
     * Return a data model object for CategorySummaryOperator.joinItemInfo#info.
     */
    public ItemInfo getPort1() {
        if(this.segmentId != 1) throw new AssertionError();
        return this.port0001;
    }
    /**
     * 
             * Sets a data model object for the successing operator input <code>CategorySummaryOperator.joinItemInfo#info</code>.
     * @param model the target data model object
     */
    public void setPort1(ItemInfo model) {
        this.segmentId = 1;
        this.port0001.copyFrom(model);
    }
    /**
     * Return a data model object for CategorySummaryOperator.joinItemInfo#sales.
     */
    public SalesDetail getPort2() {
        if(this.segmentId != 2) throw new AssertionError();
        return this.port0002;
    }
    /**
     * 
             * Sets a data model object for the successing operator input <code>CategorySummaryOperator.joinItemInfo#sales</code>.
     * @param model the target data model object
     */
    public void setPort2(SalesDetail model) {
        this.segmentId = 2;
        this.port0002.copyFrom(model);
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.segmentId) {
            case 1:
                out.writeInt(1);
                this.port0001.write(out);
                break;
            case 2:
                out.writeInt(2);
                this.port0002.write(out);
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
            case 2:
                this.port0002.readFields(in);
                break;
            default:
                throw new AssertionError(this.segmentId);
        }
    }
}