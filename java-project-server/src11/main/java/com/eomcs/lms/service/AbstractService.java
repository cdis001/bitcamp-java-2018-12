package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<E> {
  List<E> list;
  ObjectInputStream in;
  ObjectOutputStream out;
  String filepath;
  
  public void init(ObjectInputStream in, ObjectOutputStream out) { 
    this.in = in;
    this.out = out;
  }
  
  @SuppressWarnings("unchecked")
  public void loadData(String filepath) {
    this.filepath = filepath;
    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
        new FileInputStream(this.filepath)))) {
      
      list = (List<E>) in.readObject();
      
    } catch (Exception e) {
      list = new ArrayList<>();
      throw new RuntimeException("게시글 파일 로딩중 오류 발생: ", e);
    } 
  }

  public void saveData() throws Exception {
    try(ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
        new FileOutputStream(this.filepath)))) {
      
      out.writeObject(list);
      
    } catch (Exception e) {
      throw new Exception("게시글 파일 저장중 오류 발생: ", e);
    }
  }
    
    public abstract void execute(String request) throws Exception;
  }
  
