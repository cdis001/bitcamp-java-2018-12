package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationListener {
  void StartApplication(Map<String, Object> context);
  void endApplication(Map<String, Object> context);
}
