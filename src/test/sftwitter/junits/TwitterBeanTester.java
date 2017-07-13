package test.sftwitter.junits;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import test.sftwitter.beans.TwitterBean;
import test.sftwitter.utils.AuthUtility;
import twitter4j.Status;
import twitter4j.conf.ConfigurationBuilder;

/*##Salesforce Twitter Feed Application##
*
*This Junit Test case will test all the methods in 
* TwitterBean to make all API calls Twitter and fetch the latest tweets*/

public class TwitterBeanTester {



 static TwitterBean tb;
 static ConfigurationBuilder cb;
 @BeforeClass
 public static void loadProps() {
  tb = new TwitterBean();
  cb = new AuthUtility().getCB();

 }
 @Test
 public void testgetTweets() {
  List < Status > sts = tb.getTweets("@salesforce");
  assertEquals(10, sts.size());
 }

 @Test
 public void testgetTwitter() {

  assertNotNull(tb.getTwitter(cb));
 }

 @Test
 public void gettoptentweets() {

  assertEquals(10, tb.getTopTenStatuses(tb.getTwitter(cb), "@salesforce").size());
 }

}