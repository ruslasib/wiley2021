package models;

public class ProductItem {

  private String productTitle;
  private String searchHighLightText;
  private boolean isEbookTabExists;
  private boolean isPrintTabExists;
  private boolean isObookTabExists;
  private boolean isPrintBookAvailable;

  public String productTitle() {
    return productTitle;
  }

  public ProductItem withTitle(String productTitle) {
    this.productTitle = productTitle;
    return this;
  }

  public String searchHighLightText() {
    return searchHighLightText;
  }

  public ProductItem withSearchHighlightText(String searchHighlightText) {
    this.searchHighLightText = searchHighlightText;
    return this;
  }

  public boolean isEbookTabExists() {
    return isEbookTabExists;
  }

  public ProductItem withEbookTab(boolean isEbookTabExists) {
    this.isEbookTabExists = isEbookTabExists;
    return this;
  }

  public boolean isPrintTabExists() {
    return isPrintTabExists;
  }

  public ProductItem withPrintTab(boolean isPrintTabExists) {
    this.isPrintTabExists = isPrintTabExists;
    return this;
  }

  public boolean isObookTabExists() {
    return isObookTabExists;
  }

  public ProductItem withObookTab(boolean isObookTabExists) {
    this.isObookTabExists = isObookTabExists;
    return this;
  }

  public boolean isPrintBookAvailable() {
    return isPrintBookAvailable;
  }

  public ProductItem printBookAvailable(boolean isPrintBookAvailable) {
    this.isPrintBookAvailable = isPrintBookAvailable;
    return this;
  }

  @Override
  public String toString() {
    return "productTitle: " + productTitle +
            "\nsearchHighLightText: " + searchHighLightText +
            "\nisEbookTabExists: " + isEbookTabExists +
            "\nisPrintTabExists: " + isPrintTabExists +
            "\nisObookTabExists: " + isObookTabExists;
  }
}
