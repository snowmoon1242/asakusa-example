package com.example.modelgen.dmdl.csv;
import com.asakusafw.runtime.directio.BinaryStreamFormat;
import com.asakusafw.runtime.directio.util.DelimiterRangeInputStream;
import com.asakusafw.runtime.io.ModelInput;
import com.asakusafw.runtime.io.ModelOutput;
import com.asakusafw.runtime.io.csv.CsvConfiguration;
import com.asakusafw.runtime.io.csv.CsvEmitter;
import com.asakusafw.runtime.io.csv.CsvParser;
import com.example.modelgen.dmdl.model.ErrorRecord;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * CSV format for {@link ErrorRecord}.
 */
public class ErrorRecordCsvFormat extends BinaryStreamFormat<ErrorRecord> {
    /**
     * Returns this CSV format configuration.
     * @param head whether configure for head of file or not
     * @return CSV format configuration
     */
    protected CsvConfiguration getConfiguration(boolean head) {
        List<String> headers = new ArrayList<String>();
        if(head) {
            headers.add("ファイル名");
            headers.add("日時");
            headers.add("店舗コード");
            headers.add("商品コード");
            headers.add("メッセージ");
        }
        CsvConfiguration config = new CsvConfiguration(Charset.forName("UTF-8"), headers, "true", "false", "yyyy-MM-dd", 
                "yyyy-MM-dd HH:mm:ss");
        config.setLineBreakInValue(false);
        return config;
    }
    @Override public Class<ErrorRecord> getSupportedType() {
        return ErrorRecord.class;
    }
    @Override public long getPreferredFragmentSize() {
        return -1L;
    }
    @Override public long getMinimumFragmentSize() {
        return Long.MAX_VALUE;
    }
    @Override public ModelInput<ErrorRecord> createInput(Class<? extends ErrorRecord> dataType, String path, InputStream 
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
    @Override public ModelOutput<ErrorRecord> createOutput(Class<? extends ErrorRecord> dataType, String path, 
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
    private static final class Reader implements ModelInput<ErrorRecord> {
        private final CsvParser parser;
        Reader(CsvParser parser) {
            this.parser = parser;
        }
        @Override public boolean readTo(ErrorRecord object) throws IOException {
            if(parser.next() == false) {
                return false;
            }
            parser.fill(object.getFileNameOption());
            parser.fill(object.getSalesDateTimeOption());
            parser.fill(object.getStoreCodeOption());
            parser.fill(object.getItemCodeOption());
            parser.fill(object.getMessageOption());
            parser.endRecord();
            return true;
        }
        @Override public void close() throws IOException {
            parser.close();
        }
    }
    private static final class Writer implements ModelOutput<ErrorRecord> {
        private final CsvEmitter emitter;
        Writer(CsvEmitter emitter) {
            this.emitter = emitter;
        }
        @Override public void write(ErrorRecord object) throws IOException {
            emitter.emit(object.getFileNameOption());
            emitter.emit(object.getSalesDateTimeOption());
            emitter.emit(object.getStoreCodeOption());
            emitter.emit(object.getItemCodeOption());
            emitter.emit(object.getMessageOption());
            emitter.endRecord();
        }
        @Override public void close() throws IOException {
            emitter.close();
        }
    }
}