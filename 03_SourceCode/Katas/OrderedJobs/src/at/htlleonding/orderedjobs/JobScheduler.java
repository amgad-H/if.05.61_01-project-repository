/*----------------------------------------------------------
 *                HTBLA-Leonding / Class: < 3CHIF >
 * ---------------------------------------------------------
 * Exercise Number: 0
 * Title:
 * Author: Amgad Hammash
 * ----------------------------------------------------------
 * Description:
 * ----------------------------------------------------------
 */
package at.htlleonding.orderedjobs;

public class JobScheduler {

    private String mJobs = "";
    public void registerJob(String jobName) {
        mJobs += jobName;
    }

    public void sort() {
        
    }

    public String getList() {
        return mJobs;
    }

    public void registerJob(String dependent, String independent) {
        mJobs += dependent + independent;
    }
}
