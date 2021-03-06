package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractService<E> {
  ObjectInputStream in;
  ObjectOutputStream out;
  
  public void init(ObjectInputStream in, ObjectOutputStream out) { 
    this.in = in;
    this.out = out;
  }
    public abstract void execute(String request) throws Exception;
  }
  
