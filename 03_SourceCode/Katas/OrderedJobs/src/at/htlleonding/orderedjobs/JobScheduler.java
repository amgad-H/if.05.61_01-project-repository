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
        if(!containsJob(job)){
            mJobs.add(job);
        }
    }

    public void sort() {

    }

    public String getList() {
        String jobs = "";
        for(Job job : mJobs){
            jobs += job.getName();
        }
        return jobs;
    }

    public boolean containsJob(Job job){
        boolean doesContain = false;

        for(Job j : mJobs){
            doesContain = j.getName() == job.getName() ? true : false;
        }
        return doesContain;
    }

    public void registerJob(String dependent, String independent) {
        Job job = new Job(independent);
        if(!containsJob(job)){
            mJobs.add(job);
        }

        Job job2 = new Job(dependent, job);
        if(!containsJob(job2)){
            mJobs.add(job2);
        }
    }
}
