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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JobsScheduler {

    private List<Job> mJobs = new LinkedList<>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);

        if(!mJobs.contains(jobName))
        {
            mJobs.add(job);
        }
    }

    public void sort() {

    }

    public String getList() {
        return "";
    }

    public void registerJob(String dependentJob, String independentJob) {
        Job job = new Job(independentJob);
        if(!mJobs.contains(job))
        {
            mJobs.add(job);
        }

        Job job2 = new Job(dependentJob, job);
        if(!mJobs.contains(job2))
        {
            mJobs.add(job2);
        }
    }
}
