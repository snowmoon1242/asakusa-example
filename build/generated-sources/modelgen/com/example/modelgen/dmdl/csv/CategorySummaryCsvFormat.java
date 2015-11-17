package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.BinaryStreamFormat;
import com.asakusafw.runtime.directio.util.DelimiterRangeInputStream;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.csv.CsvConfiguration;
import com.asakusafw.runtime.io.csv.CsvEmitter;
import com.asakusafw.runtime.io.csv.CsvParser;
import com.example.modelgen.dmdl.model.CategorySummary;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * CSV format for {@link CategorySummary}.
 */
public class CategorySummaryCsvFormat extends BinaryStreamFormat<CategorySummary> {
    /**
     * Returns this CSV format configuration.
     * @param head whether configure for head of file or not
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration(boolean head) {
        List<String> headers = new ArrayList<String>();
        if(head) {
            headers.add("カテゴリコード");
            headers.add("販売数量");
            headers.add("売上合計");
        }
        CsvConfiguration config = new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
        config.setLineBreakInValue(false);
        return config;
    }
    @Override public Class<CategorySummary> getSupportedType() {
        return CategorySummary.class;
    }
    @Override public long getPreferredFragmentSize() {
        return -1L;
    }
    @Override public long getMinimumFragmentSize() {
        return Long.MAX_VALUE;
    }
    @Override public ModelInput<CategorySummary> createInput(Class<? extends CategorySummary> dataType, String path, 
            InputStream stream, long offset, long fragmentSize) throws IOException {
        if(dataType == null) {
            throw new IllegalArgumentException("dataType must not be null");
        }
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        InputStream fragmentInput;
        fragmentInput = new DelimiterRangeInputStream(stream, '\n', fragmentSize, offset > 0L);
        CsvParser parser = new CsvParser(fragmentInput, path, this.getConfiguration(offset == 0L));
        return new Reader(parser);
    }
    @Override public ModelOutput<CategorySummary> createOutput(Class<? extends CategorySummary> dataType, String path, 
            OutputStream stream) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvEmitter emitter = new CsvEmitter(stream, path, this.getConfiguration(true));
        return new Writer(emitter);
    }
    private static final class Reader implements ModelInput<CategorySummary> {
        private final CsvParser parser;
        Reader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(CategorySummary object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getCategoryCodeOption());
            parser.fill(object.getAmountTotalOption());
            parser.fill(object.getSellingPriceTotalOption());
            parser.endRecord();
            return true;
        }
        @Override public void close() throws IOException {
            parser.close();
        }
    }
    private static final class Writer implements ModelOutput<CategorySummary> {
        private final CsvEmitter emitter;
        Writer(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(CategorySummary object) throws IOException {
            emitter.emit(object.getCategoryCodeOption());
            emitter.emit(object.getAmountTotalOption());
            emitter.emit(object.getSellingPriceTotalOption());
            emitter.endRecord();
        }
        @Override public void close() throws IOException {
            emitter.close();
        }
    }
}