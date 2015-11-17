package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.BinaryStreamFormat;
import com.asakusafw.runtime.directio.util.DelimiterRangeInputStream;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.csv.CsvConfiguration;
import com.asakusafw.runtime.io.csv.CsvEmitter;
import com.asakusafw.runtime.io.csv.CsvParser;
import com.example.modelgen.dmdl.model.ItemInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * CSV format for {@link ItemInfo}.
 */
public class ItemInfoCsvFormat extends BinaryStreamFormat<ItemInfo> {
    /**
     * Returns this CSV format configuration.
     * @param head whether configure for head of file or not
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration(boolean head) {
        List<String> headers = new ArrayList<String>();
        if(head) {
            headers.add("商品コード");
            headers.add("商品名");
            headers.add("部門コード");
            headers.add("部門名");
            headers.add("カテゴリコード");
            headers.add("カテゴリ名");
            headers.add("単価");
            headers.add("登録日");
            headers.add("適用開始日");
            headers.add("適用終了日");
        }
        CsvConfiguration config = new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
        config.setLineBreakInValue(false);
        return config;
    }
    @Override public Class<ItemInfo> getSupportedType() {
        return ItemInfo.class;
    }
    @Override public long getPreferredFragmentSize() {
        return -1L;
    }
    @Override public long getMinimumFragmentSize() {
        return Long.MAX_VALUE;
    }
    @Override public ModelInput<ItemInfo> createInput(Class<? extends ItemInfo> dataType, String path, InputStream 
            stream, long offset, long fragmentSize) throws IOException {
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
    @Override public ModelOutput<ItemInfo> createOutput(Class<? extends ItemInfo> dataType, String path, OutputStream 
            stream) throws IOException {
        if(path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if(stream == null) {
            throw new IllegalArgumentException("stream must not be null");
        }
        CsvEmitter emitter = new CsvEmitter(stream, path, this.getConfiguration(true));
        return new Writer(emitter);
    }
    private static final class Reader implements ModelInput<ItemInfo> {
        private final CsvParser parser;
        Reader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(ItemInfo object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getItemCodeOption());
            parser.fill(object.getItemNameOption());
            parser.fill(object.getDepartmentCodeOption());
            parser.fill(object.getDepartmentNameOption());
            parser.fill(object.getCategoryCodeOption());
            parser.fill(object.getCategoryNameOption());
            parser.fill(object.getUnitSellingPriceOption());
            parser.fill(object.getRegisteredDateOption());
            parser.fill(object.getBeginDateOption());
            parser.fill(object.getEndDateOption());
            parser.endRecord();
            return true;
        }
        @Override public void close() throws IOException {
            parser.close();
        }
    }
    private static final class Writer implements ModelOutput<ItemInfo> {
        private final CsvEmitter emitter;
        Writer(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(ItemInfo object) throws IOException {
            emitter.emit(object.getItemCodeOption());
            emitter.emit(object.getItemNameOption());
            emitter.emit(object.getDepartmentCodeOption());
            emitter.emit(object.getDepartmentNameOption());
            emitter.emit(object.getCategoryCodeOption());
            emitter.emit(object.getCategoryNameOption());
            emitter.emit(object.getUnitSellingPriceOption());
            emitter.emit(object.getRegisteredDateOption());
            emitter.emit(object.getBeginDateOption());
            emitter.emit(object.getEndDateOption());
            emitter.endRecord();
        }
        @Override public void close() throws IOException {
            emitter.close();
        }
    }
}