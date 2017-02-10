package com.ghanshyam.ilovezappos.models;

/**
 * Created by GHANSHYAM on 05-Feb-17.
 */

/*
public class Result {
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

    public String getBrandName(){
        return brandName;
    }
    public void setBrandName(String input){
        this.brandName = input;
    }
    public String getThumbnailImageUrl(){
        return thumbnailImageUrl;
    }
    public void setThumbnailImageUrl(String input){
        this.thumbnailImageUrl = input;
    }
    public String getProductId(){
        return productId;
    }
    public void setProductId(String input){
        this.productId = input;
    }
    public String getOriginalPrice(){
        return originalPrice;
    }
    public void setOriginalPrice(String input){
        this.originalPrice = input;
    }
    public String getStyleId(){
        return styleId;
    }
    public void setStyleId(String input){
        this.styleId = input;
    }
    public String getColorId(){
        return colorId;
    }
    public void setColorId(String input){
        this.colorId = input;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String input){
        this.price = input;
    }
    public String getPercentOff(){
        return percentOff;
    }
    public void setPercentOff(String input){
        this.percentOff = input;
    }
    public String getProductUrl(){
        return productUrl;
    }
    public void setProductUrl(String input){
        this.productUrl = input;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String input){
        this.productName = input;
    }
}*/

import java.util.Map;


        import java.util.HashMap;
        import java.util.Map;

public class Result {

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