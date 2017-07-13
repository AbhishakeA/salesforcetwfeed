package test.sftwitter.beans;
import java.util.ArrayList;

import java.util.List;

import test.sftwitter.utils.AuthUtility;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/** ##Salesforce Twitter Feed Application##

 * The TwitterBean class acts as Model object in this MVC pattern application
 * This is createdin controller and returns tweets for given user.
 * 
 * We may add more functionalities on this bean for search.
 *
 * @author  Abhishake A
 * @version 1.0
 * @since   2017/7/12
 */
public class TwitterBean {

 /**
  * This method is used to get the twitter object which connects to 
  * Twitter handle of the user and retrieve statuses using Twitter4J API* 
  *
  * @author  Abhishake A
  * @version 1.0
  * @since   2017/7/12
  */
 public Twitter getTwitter(ConfigurationBuilder cb) {

   TwitterFactory tf = new TwitterFactory(cb.build());
   twitter4j.Twitter twitter = tf.getInstance();
   return twitter;

  }
  /**
   * This method is used to get the topten statuses list  using Twitter4J API
   * for given user* 
   *THis establishes authentication with twitter and retrieve list
   * @author  Abhishake A
   * @version 1.0
   * @since   2017/7/12
   */
 public List < Status > getTweets(String user) {
   // TODO Auto-generated method stubs
   AuthUtility au = new AuthUtility();
   ConfigurationBuilder cb = au.getCB();
   Twitter twitter = getTwitter(cb);
   return getTopTenStatuses(twitter, user);


  }
  /**
   * This method is used to loop over list and get the topten statuses list  using Twitter4J API
   * for given user* 
   *
   * @author  Abhishake A
   * @version 1.0
   * @since   2017/7/12
   */
 public List < Status > getTopTenStatuses(Twitter twitter, String user) {
  // TODO Auto-generated method stub
  List < Status > statusList = null;
  List < Status > statuses = new ArrayList < Status > ();
  /*Loop through the list of all and get the latest 10 status*/
  try {
   statusList = twitter.getUserTimeline(user);
   for (int i = 0; i < 10; i++) {
    statuses.add(statusList.get(i));
   }
  } catch (TwitterException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  return statuses;
 }

}