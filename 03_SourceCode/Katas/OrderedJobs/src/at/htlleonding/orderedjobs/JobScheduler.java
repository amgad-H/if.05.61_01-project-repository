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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JobScheduler {

    private List<Job> mJobs = new LinkedList<>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if(!mJobs.contains(job)){
            mJobs.add(job);
        }
    }

    public void sort() {

    }

    public String getList() {
        return mJobs;
    }

    public void registerJob(String dependent, String independent) {
        Job job = new Job(independent);
        if(!mJobs.contains(job)){
            mJobs.add(job);
        }

        Job job2 = new Job(dependent, job);
        if(!mJobs.contains(job2)){
            mJobs.add(job2);
        }
    }
}
