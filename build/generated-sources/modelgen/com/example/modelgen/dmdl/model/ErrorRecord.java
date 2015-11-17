package com.example.modelgen.dmdl.model;
import com.asakusafw.runtime.model.DataModel;
import com.asakusafw.runtime.model.DataModelKind;
import com.asakusafw.runtime.model.PropertyOrder;
import com.asakusafw.runtime.value.DateTime;
import com.asakusafw.runtime.value.DateTimeOption;
import com.asakusafw.runtime.value.StringOption;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
/**
 * エラー情報を表すデータモデルクラス。
 */
@DataModelKind("DMDL")@PropertyOrder({"file_name", "sales_date_time", "store_code", "item_code", "message"}) public 
        class ErrorRecord implements DataModel<ErrorRecord>, Writable {
    private final StringOption fileName = new StringOption();
    private final DateTimeOption salesDateTime = new DateTimeOption();
    private final StringOption storeCode = new StringOption();
    private final StringOption itemCode = new StringOption();
    private final StringOption message = new StringOption();
    @Override@SuppressWarnings("deprecation") public void reset() {
        this.fileName.setNull();
        this.salesDateTime.setNull();
        this.storeCode.setNull();
        this.itemCode.setNull();
        this.message.setNull();
    }
    @Override@SuppressWarnings("deprecation") public void copyFrom(ErrorRecord other) {
        this.fileName.copyFrom(other.fileName);
        this.salesDateTime.copyFrom(other.salesDateTime);
        this.storeCode.copyFrom(other.storeCode);
        this.itemCode.copyFrom(other.itemCode);
        this.message.copyFrom(other.message);
    }
    /**
     * ファイル名を返す。
     * @return ファイル名
     * @throws NullPointerException ファイル名の値が<code>null</code>である場合
     */
    public Text getFileName() {
        return this.fileName.get();
    }
    /**
     * ファイル名を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setFileName(Text value) {
        this.fileName.modify(value);
    }
    /**
     * <code>null</code>を許すファイル名を返す。
     * @return ファイル名
     */
    public StringOption getFileNameOption() {
        return this.fileName;
    }
    /**
     * ファイル名を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setFileNameOption(StringOption option) {
        this.fileName.copyFrom(option);
    }
    /**
     * 売上日時を返す。
     * @return 売上日時
     * @throws NullPointerException 売上日時の値が<code>null</code>である場合
     */
    public DateTime getSalesDateTime() {
        return this.salesDateTime.get();
    }
    /**
     * 売上日時を設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setSalesDateTime(DateTime value) {
        this.salesDateTime.modify(value);
    }
    /**
     * <code>null</code>を許す売上日時を返す。
     * @return 売上日時
     */
    public DateTimeOption getSalesDateTimeOption() {
        return this.salesDateTime;
    }
    /**
     * 売上日時を設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setSalesDateTimeOption(DateTimeOption option) {
        this.salesDateTime.copyFrom(option);
    }
    /**
     * 店舗コードを返す。
     * @return 店舗コード
     * @throws NullPointerException 店舗コードの値が<code>null</code>である場合
     */
    public Text getStoreCode() {
        return this.storeCode.get();
    }
    /**
     * 店舗コードを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setStoreCode(Text value) {
        this.storeCode.modify(value);
    }
    /**
     * <code>null</code>を許す店舗コードを返す。
     * @return 店舗コード
     */
    public StringOption getStoreCodeOption() {
        return this.storeCode;
    }
    /**
     * 店舗コードを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setStoreCodeOption(StringOption option) {
        this.storeCode.copyFrom(option);
    }
    /**
     * 商品コードを返す。
     * @return 商品コード
     * @throws NullPointerException 商品コードの値が<code>null</code>である場合
     */
    public Text getItemCode() {
        return this.itemCode.get();
    }
    /**
     * 商品コードを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemCode(Text value) {
        this.itemCode.modify(value);
    }
    /**
     * <code>null</code>を許す商品コードを返す。
     * @return 商品コード
     */
    public StringOption getItemCodeOption() {
        return this.itemCode;
    }
    /**
     * 商品コードを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setItemCodeOption(StringOption option) {
        this.itemCode.copyFrom(option);
    }
    /**
     * エラーメッセージを返す。
     * @return エラーメッセージ
     * @throws NullPointerException エラーメッセージの値が<code>null</code>である場合
     */
    public Text getMessage() {
        return this.message.get();
    }
    /**
     * エラーメッセージを設定する。
     * @param value 設定する値
     */
    @SuppressWarnings("deprecation") public void setMessage(Text value) {
        this.message.modify(value);
    }
    /**
     * <code>null</code>を許すエラーメッセージを返す。
     * @return エラーメッセージ
     */
    public StringOption getMessageOption() {
        return this.message;
    }
    /**
     * エラーメッセージを設定する。
     * @param option 設定する値、<code>null</code>の場合にはこのプロパティが<code>null</code>を表すようになる
     */
    @SuppressWarnings("deprecation") public void setMessageOption(StringOption option) {
        this.message.copyFrom(option);
    }
    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append("class=error_record");
        result.append(", fileName=");
        result.append(this.fileName);
        result.append(", salesDateTime=");
        result.append(this.salesDateTime);
        result.append(", storeCode=");
        result.append(this.storeCode);
        result.append(", itemCode=");
        result.append(this.itemCode);
        result.append(", message=");
        result.append(this.message);
        result.append("}");
        return result.toString();
    }
    @Override public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + fileName.hashCode();
        result = prime * result + salesDateTime.hashCode();
        result = prime * result + storeCode.hashCode();
        result = prime * result + itemCode.hashCode();
        result = prime * result + message.hashCode();
        return result;
    }
    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        ErrorRecord other = (ErrorRecord) obj;
        if(this.fileName.equals(other.fileName) == false) {
            return false;
        }
        if(this.salesDateTime.equals(other.salesDateTime) == false) {
            return false;
        }
        if(this.storeCode.equals(other.storeCode) == false) {
            return false;
        }
        if(this.itemCode.equals(other.itemCode) == false) {
            return false;
        }
        if(this.message.equals(other.message) == false) {
            return false;
        }
        return true;
    }
    /**
     * ファイル名を返す。
     * @return ファイル名
     * @throws NullPointerException ファイル名の値が<code>null</code>である場合
     */
    public String getFileNameAsString() {
        return this.fileName.getAsString();
    }
    /**
     * ファイル名を設定する。
     * @param fileName0 設定する値
     */
    @SuppressWarnings("deprecation") public void setFileNameAsString(String fileName0) {
        this.fileName.modify(fileName0);
    }
    /**
     * 店舗コードを返す。
     * @return 店舗コード
     * @throws NullPointerException 店舗コードの値が<code>null</code>である場合
     */
    public String getStoreCodeAsString() {
        return this.storeCode.getAsString();
    }
    /**
     * 店舗コードを設定する。
     * @param storeCode0 設定する値
     */
    @SuppressWarnings("deprecation") public void setStoreCodeAsString(String storeCode0) {
        this.storeCode.modify(storeCode0);
    }
    /**
     * 商品コードを返す。
     * @return 商品コード
     * @throws NullPointerException 商品コードの値が<code>null</code>である場合
     */
    public String getItemCodeAsString() {
        return this.itemCode.getAsString();
    }
    /**
     * 商品コードを設定する。
     * @param itemCode0 設定する値
     */
    @SuppressWarnings("deprecation") public void setItemCodeAsString(String itemCode0) {
        this.itemCode.modify(itemCode0);
    }
    /**
     * エラーメッセージを返す。
     * @return エラーメッセージ
     * @throws NullPointerException エラーメッセージの値が<code>null</code>である場合
     */
    public String getMessageAsString() {
        return this.message.getAsString();
    }
    /**
     * エラーメッセージを設定する。
     * @param message0 設定する値
     */
    @SuppressWarnings("deprecation") public void setMessageAsString(String message0) {
        this.message.modify(message0);
    }
    @Override public void write(DataOutput out) throws IOException {
        fileName.write(out);
        salesDateTime.write(out);
        storeCode.write(out);
        itemCode.write(out);
        message.write(out);
    }
    @Override public void readFields(DataInput in) throws IOException {
        fileName.readFields(in);
        salesDateTime.readFields(in);
        storeCode.readFields(in);
        itemCode.readFields(in);
        message.readFields(in);
    }
}