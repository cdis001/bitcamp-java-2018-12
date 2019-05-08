package bitcamp.app2;

import java.util.Date;

public class Board {
  protected int no;
  protected String title;
  protected String content;
  protected String writer;
  protected int viewCount;
  protected Date createdDate;

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
        + ", viewCount=" + viewCount + ", createdDate=" + createdDate + "]";
  }

  public Board() {

  }

  public Board(int no, String title, String content, String writer, int viewCount,
      Date createdDate) {
    this.no = no;
    this.title = title;
    this.content = content;
    this.writer = writer;
    this.viewCount = viewCount;
    this.createdDate = createdDate;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewConut) {
    this.viewCount = viewConut;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }


}