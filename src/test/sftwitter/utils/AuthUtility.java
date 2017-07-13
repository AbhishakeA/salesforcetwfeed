package test.sftwitter.utils;

import twitter4j.conf.ConfigurationBuilder;

/**##Salesforce Twitter Feed Application##
 *
 * The AuthUtility can be used to get authentication with twitter account and return back Configuration Object.
 * 
 * 
 * We may add more functionalities on this bean for different kinds of utilities for logging or DB connection later.
 *
 * @author  Abhishake A
 * @version 1.0
 * @since   2017/7/12
 */
public class AuthUtility {
 /*This returns the configuration builder*/
 public ConfigurationBuilder getCB() {
  ConfigurationBuilder cb = new ConfigurationBuilder();
  cb.setOAuthConsumerKey(Constants.CKey);
  cb.setOAuthConsumerSecret(Constants.CSecret);
  cb.setOAuthAccessToken(Constants.Atoken);
  cb.setOAuthAccessTokenSecret(Constants.AtokenSecret);
  return cb;

 }
}