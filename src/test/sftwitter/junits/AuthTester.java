package test.sftwitter.junits;

import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;
import test.sftwitter.utils.AuthUtility;
import twitter4j.conf.ConfigurationBuilder;

/*##Salesforce Twitter Feed Application##

This is JUNIT test case to test the Authentication methods to 
getTweets from twitter handle*/

public class AuthTester {
 static AuthUtility au;
 @BeforeClass
 public static void loadProps() {
  au = new AuthUtility();

 }
 @Test
 public void AuthTest_Pass() {
  ConfigurationBuilder cb = au.getCB();

  Assert.assertNull(cb);
 }
}