package com.example.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.OperatorHelper;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.flow.processor.PartialAggregation;
import com.asakusafw.vocabulary.operator.KeyInfo;
import com.asakusafw.vocabulary.operator.MasterCheck;
import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.OperatorFactory;
import com.asakusafw.vocabulary.operator.OperatorInfo;
import com.asakusafw.vocabulary.operator.Summarize;
import com.asakusafw.vocabulary.operator.Update;
import com.example.modelgen.dmdl.model.CategorySummary;
import com.example.modelgen.dmdl.model.ErrorRecord;
import com.example.modelgen.dmdl.model.ItemInfo;
import com.example.modelgen.dmdl.model.JoinedSalesInfo;
import com.example.modelgen.dmdl.model.SalesDetail;
import com.example.modelgen.dmdl.model.StoreInfo;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
/**
 * {@link CategorySummaryOperator}に関する演算子ファクトリークラス。
 * @see CategorySummaryOperator
 */
@Generated("OperatorFactoryClassGenerator:0.1.0")@OperatorFactory(CategorySummaryOperator.class) public class 
        CategorySummaryOperatorFactory {
    /**
     * 売上情報をカテゴリ別に集計する。
     */
    public static final class SummarizeByCategory implements Operator {
        private final FlowElementResolver $;
        /**
         *  集計結果
         */
        public final Source<CategorySummary> out;
        SummarizeByCategory(Source<JoinedSalesInfo> info) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(Summarize.class);
            builder.declare(CategorySummaryOperator.class, CategorySummaryOperatorImpl.class, "summarizeByCategory");
            builder.declareParameter(JoinedSalesInfo.class);
            builder.addInput("info", info, new ShuffleKey(Arrays.asList(new String[]{"categoryCode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addOutput("out", CategorySummary.class);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            builder.addAttribute(PartialAggregation.PARTIAL);
            this.$ = builder.toResolver();
            this.$.resolveInput("info", info);
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public CategorySummaryOperatorFactory.SummarizeByCategory as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * 売上情報をカテゴリ別に集計する。
     * @param info  売上情報
     * @return 生成した演算子オブジェクト
     * @see CategorySummaryOperator#summarizeByCategory(JoinedSalesInfo)
     */
    @OperatorInfo(kind = Summarize.class, input = {@OperatorInfo.Input(name = "info", type = JoinedSalesInfo.class, 
                position = 0)}, output = {@OperatorInfo.Output(name = "out", type = CategorySummary.class)}, parameter = 
            {}) public CategorySummaryOperatorFactory.SummarizeByCategory summarizeByCategory(@KeyInfo(group = {@KeyInfo
                .Group(expression = "categoryCode")}, order = {}) Source<JoinedSalesInfo> info) {
        return new CategorySummaryOperatorFactory.SummarizeByCategory(info);
    }
    /**
     * 売上明細の店舗コードに対応する店舗マスタが存在するかチェックする。
     */
    public static final class CheckStore implements Operator {
        private final FlowElementResolver $;
        /**
         * infoの引き当てに成功したsales
         */
        public final Source<SalesDetail> found;
        /**
         * infoの引き当てに失敗したsales
         */
        public final Source<SalesDetail> missed;
        CheckStore(Source<StoreInfo> info, Source<SalesDetail> sales) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(MasterCheck.class);
            builder0.declare(CategorySummaryOperator.class, CategorySummaryOperatorImpl.class, "checkStore");
            builder0.declareParameter(StoreInfo.class);
            builder0.declareParameter(SalesDetail.class);
            builder0.addInput("info", info, new ShuffleKey(Arrays.asList(new String[]{"store_code"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder0.addInput("sales", sales, new ShuffleKey(Arrays.asList(new String[]{"store_code"}), Arrays.asList(
                    new ShuffleKey.Order[]{})));
            builder0.addOutput("found", sales);
            builder0.addOutput("missed", sales);
            builder0.addAttribute(FlowBoundary.SHUFFLE);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("info", info);
            this.$.resolveInput("sales", sales);
            this.found = this.$.resolveOutput("found");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public CategorySummaryOperatorFactory.CheckStore as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * 売上明細の店舗コードに対応する店舗マスタが存在するかチェックする。
     * @param info  店舗マスタ
     * @param sales  売上明細
     * @return 生成した演算子オブジェクト
     * @see CategorySummaryOperator#checkStore(StoreInfo, SalesDetail)
     */
    @OperatorInfo(kind = MasterCheck.class, input = {@OperatorInfo.Input(name = "info", type = StoreInfo.class, position 
                = 0),@OperatorInfo.Input(name = "sales", type = SalesDetail.class, position = 1)}, output = {@
                OperatorInfo.Output(name = "found", type = SalesDetail.class),@OperatorInfo.Output(name = "missed", type 
                = SalesDetail.class)}, parameter = {}) public CategorySummaryOperatorFactory.CheckStore checkStore(@
            KeyInfo(group = {@KeyInfo.Group(expression = "store_code")}, order = {}) Source<StoreInfo> info,@KeyInfo(
            group = {@KeyInfo.Group(expression = "store_code")}, order = {}) Source<SalesDetail> sales) {
        return new CategorySummaryOperatorFactory.CheckStore(info, sales);
    }
    /**
     * 商品マスタと売上明細を結合する。 結合時にはマスタの適用期間がチェックされる。
     */
    public static final class JoinItemInfo implements Operator {
        private final FlowElementResolver $;
        /**
         *  結合結果
         */
        public final Source<JoinedSalesInfo> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<SalesDetail> missed;
        JoinItemInfo(Source<ItemInfo> info, Source<SalesDetail> sales) {
            OperatorDescription.Builder builder1 = new OperatorDescription.Builder(MasterJoin.class);
            builder1.declare(CategorySummaryOperator.class, CategorySummaryOperatorImpl.class, "joinItemInfo");
            builder1.declareParameter(ItemInfo.class);
            builder1.declareParameter(SalesDetail.class);
            builder1.addInput("info", info, new ShuffleKey(Arrays.asList(new String[]{"itemCode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder1.addInput("sales", sales, new ShuffleKey(Arrays.asList(new String[]{"itemCode"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder1.addOutput("joined", JoinedSalesInfo.class);
            builder1.addOutput("missed", sales);
            builder1.addAttribute(FlowBoundary.SHUFFLE);
            builder1.addAttribute(ObservationCount.DONT_CARE);
            builder1.addAttribute(new OperatorHelper("selectAvailableItem", Arrays.asList(new Class<?>[]{List.class, 
                        SalesDetail.class})));
            this.$ = builder1.toResolver();
            this.$.resolveInput("info", info);
            this.$.resolveInput("sales", sales);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName1 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public CategorySummaryOperatorFactory.JoinItemInfo as(String newName1) {
            this.$.setName(newName1);
            return this;
        }
    }
    /**
     * 商品マスタと売上明細を結合する。 結合時にはマスタの適用期間がチェックされる。
     * @param info  商品マスタ
     * @param sales  売上明細
     * @return 生成した演算子オブジェクト
     * @see CategorySummaryOperator#joinItemInfo(ItemInfo, SalesDetail)
     */
    @OperatorInfo(kind = MasterJoin.class, input = {@OperatorInfo.Input(name = "info", type = ItemInfo.class, position = 
                0),@OperatorInfo.Input(name = "sales", type = SalesDetail.class, position = 1)}, output = {@OperatorInfo
                .Output(name = "joined", type = JoinedSalesInfo.class),@OperatorInfo.Output(name = "missed", type = 
                SalesDetail.class)}, parameter = {}) public CategorySummaryOperatorFactory.JoinItemInfo joinItemInfo(@
            KeyInfo(group = {@KeyInfo.Group(expression = "itemCode")}, order = {}) Source<ItemInfo> info,@KeyInfo(group 
            = {@KeyInfo.Group(expression = "itemCode")}, order = {}) Source<SalesDetail> sales) {
        return new CategorySummaryOperatorFactory.JoinItemInfo(info, sales);
    }
    /**
     * エラーレコードにエラーメッセージを設定する。
     */
    public static final class SetErrorMessage implements Operator {
        private final FlowElementResolver $;
        /**
         * 結果
         */
        public final Source<ErrorRecord> out;
        SetErrorMessage(Source<ErrorRecord> record, String message) {
            OperatorDescription.Builder builder2 = new OperatorDescription.Builder(Update.class);
            builder2.declare(CategorySummaryOperator.class, CategorySummaryOperatorImpl.class, "setErrorMessage");
            builder2.declareParameter(ErrorRecord.class);
            builder2.declareParameter(String.class);
            builder2.addInput("record", record);
            builder2.addOutput("out", record);
            builder2.addParameter("message", String.class, message);
            builder2.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder2.toResolver();
            this.$.resolveInput("record", record);
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName2 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public CategorySummaryOperatorFactory.SetErrorMessage as(String newName2) {
            this.$.setName(newName2);
            return this;
        }
    }
    /**
     * エラーレコードにエラーメッセージを設定する。
     * @param record  エラーレコード
     * @param message  エラーメッセージ
     * @return 生成した演算子オブジェクト
     * @see CategorySummaryOperator#setErrorMessage(ErrorRecord, String)
     */
    @OperatorInfo(kind = Update.class, input = {@OperatorInfo.Input(name = "record", type = ErrorRecord.class, position 
                = 0)}, output = {@OperatorInfo.Output(name = "out", type = ErrorRecord.class)}, parameter = {@
                OperatorInfo.Parameter(name = "message", type = String.class, position = 1)}) public 
            CategorySummaryOperatorFactory.SetErrorMessage setErrorMessage(Source<ErrorRecord> record, String message) {
        return new CategorySummaryOperatorFactory.SetErrorMessage(record, message);
    }
}