package com.example.batchapp.example.summarizeSales.byCategory.stage0003;
import com.asakusafw.runtime.flow.Rendezvous;
import com.asakusafw.runtime.flow.SegmentedCombiner;
import java.io.IOException;
/**
 * Combiner class for stage <code>3</code>.
 */
@SuppressWarnings("deprecation") public final class StageCombiner extends SegmentedCombiner<ShuffleKey, ShuffleValue> {
    private CombineOutputFragment1 shuffle;
    private ReduceFragment2 combine;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        this.shuffle = new CombineOutputFragment1(context);
        this.combine = new ReduceFragment2(this.shuffle);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.shuffle = null;
        this.combine = null;
    }
    @Override protected Rendezvous<ShuffleValue> getRendezvous(ShuffleKey nextKey) {
        switch(nextKey.getSegmentId()) {
            case 1:
                return this.combine;
            default:
                throw new AssertionError();
        }
    }
}