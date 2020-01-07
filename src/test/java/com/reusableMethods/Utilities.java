package com.reusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class Utilities {
  static File file = new File("src/main/resources/config.Properties");

  public static String readConfig(String key) {
    Properties prop = null;
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      Assert.fail(e.getMessage());
    }
    prop = new Properties();
    try {
      prop.load(fis);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
    return prop.getProperty(key);
  }

  public static String setValue(String property) {
    return System.getProperty(property) == null ? readConfig(property) : System.getProperty(property);
  }
}
