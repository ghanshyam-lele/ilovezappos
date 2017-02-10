package com.ghanshyam.ilovezappos.models;


import java.util.List;




public class APIResponse {
    private String originalTerm;
    private String currentResultCount;
    private String totalResultCount;
    private String term;
    private List<Result> results;
    private String statusCode;

    public String getOriginalTerm(){
        return originalTerm;
    }
    public void setOriginalTerm(String input){
        this.originalTerm = input;
    }
    public String getCurrentResultCount(){
        return currentResultCount;
    }
    public void setCurrentResultCount(String input){
        this.currentResultCount = input;
    }
    public String getTotalResultCount(){
        return totalResultCount;
    }
    public void setTotalResultCount(String input){
        this.totalResultCount = input;
    }
    public String getTerm(){
        return term;
    }
    public void setTerm(String input){
        this.term = input;
    }
    public List<Result> getResults(){
        return results;
    }
    public void setResults(List<Result> input){
        this.results = input;
    }
    public String getStatusCode(){
        return statusCode;
    }
    public void setStatusCode(String input){
        this.statusCode = input;
    }
}




/*
import java.util.HashMap;
import java.util.Map;

public class APIResponse {

    private String brandName;
    private String thumbnailImageUrl;
    private String productId;
    private String originalPrice;
    private String styleId;
    private String colorId;
    private String price;
    private String percentOff;
    private String productUrl;
    private String productName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
*/
