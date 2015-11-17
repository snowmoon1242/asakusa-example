package com.example.batchapp.example.summarizeSales.byCategory.stage0002;
import com.asakusafw.runtime.flow.SegmentedWritable;
import com.asakusafw.runtime.value.StringOption;
import com.example.modelgen.dmdl.model.ItemInfo;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
/**
 * The shuffle key class for stage <code>2</code>.
 */
@SuppressWarnings("deprecation") public final class ShuffleKey implements SegmentedWritable {
    /**
     * the shuffle segment ID.
     */
    public int portId = -1;
    @Override public int getSegmentId() {
        return this.portId;
    }
    /**
     * shuffle key value for CategorySummaryOperator.joinItemInfo#info (itemCode).
     */
    public StringOption groupElem0Term1 = new StringOption();
    /**
     * 
             * Sets a data model object for the successing operator input <code>CategorySummaryOperator.joinItemInfo#info</code>.
     * @param source the target data model object
     */
    public void setPort1(ItemInfo source) {
        this.portId = 1;
        this.groupElem0Term1.copyFrom(source.getItemCodeOption());
    }
    /**
     * 
             * Sets a data model object for the successing operator input <code>CategorySummaryOperator.joinItemInfo#sales</code>.
     * @param source the target data model object
     */
    public void setPort2(SalesDetail source) {
        this.portId = 2;
        this.groupElem0Term1.copyFrom(source.getItemCodeOption());
    }
    /**
     * Copies the shuffle key information into this object.
     * @param original the source key object
     */
    public void copyGroupFrom(ShuffleKey original) {
        this.portId = original.portId;
        if(this.portId < 0) {
            return;
        }
        switch(this.portId) {
            case 1:
            case 2:
                this.groupElem0Term1.copyFrom(original.groupElem0Term1);
                break;
            default:
                throw new AssertionError(this.portId = original.portId);
        }
    }
    @Override public void write(DataOutput out) throws IOException {
        switch(this.portId) {
            case 1:
                out.writeInt(1);
                this.groupElem0Term1.write(out);
                break;
            case 2:
                out.writeInt(2);
                this.groupElem0Term1.write(out);
                break;
            default:
                throw new AssertionError(this.portId);
        }
    }
    @Override public void readFields(DataInput in) throws IOException {
        this.portId = in.readInt();
        switch(this.portId) {
            case 1:
                this.groupElem0Term1.readFields(in);
                break;
            case 2:
                this.groupElem0Term1.readFields(in);
                break;
            default:
                throw new AssertionError(this.portId);
        }
    }
}