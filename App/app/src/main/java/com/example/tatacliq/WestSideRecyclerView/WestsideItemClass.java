package com.example.tatacliq.WestSideRecyclerView;

public class WestsideItemClass {

  private String categoryText;
  private int image;

  public WestsideItemClass(String categoryText, int image) {
    this.categoryText = categoryText;
    this.image = image;
  }

  public String getCategoryText() {
    return categoryText;
  }

  public int getImage() {
    return image;
  }
}
