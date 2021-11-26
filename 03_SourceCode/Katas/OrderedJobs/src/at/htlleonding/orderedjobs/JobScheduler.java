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

import java.util.*;

public class JobScheduler {

    private List<Job> mJobs = new LinkedList<>();

    public void registerJob(String jobName) {
        Job job = new Job(jobName);
        if(!containsJob(job)){
            mJobs.add(job);
        }
    }

    public void sort() {
        bubbleSort();
    }
    public void bubbleSort() {
        int n = mJobs.size();
        Job temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (mJobs.get(j-1).getName().compareTo(mJobs.get(j).getName()) == 1) {
                    //swap elements
                    temp = mJobs.get(j-1);
                    mJobs.set(j-1, mJobs.get(j));
                    mJobs.set(j, temp);
                }

            }
        }
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
            if(j.getName() == job.getName()) doesContain = true;
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
