/*----------------------------------------------------------
 *				HTBLA-Leonding / Class: < 3CHIF >
 * ---------------------------------------------------------
 * Exercise Number: 0
 * Title:
 * Author:			Herolind Hajredini
 * ----------------------------------------------------------
 * Description:
 * ----------------------------------------------------------
 */
package at.htlleonding.orderedJobs;

public class JobsScheduler {
    
    private String mJobs = "";

    public void registerJob(String jobName) {
        mJobs += jobName;
    }

    public void sort() {
    }

    public String getList() {
        return mJobs;
    }

    public void registerJob(String dependentJob, String independentJob) {
        
    }
}
