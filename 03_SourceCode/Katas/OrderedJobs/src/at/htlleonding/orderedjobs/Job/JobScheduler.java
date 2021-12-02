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
package at.htlleonding.orderedjobs.Job;

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
            if(job.getDependency() != null){
                for(Job inJob : job.getDependency()){
                    jobs += inJob.getName();
                }
            }
        }
        return jobs;
    }

    public boolean containsJob(Job job){
        boolean doesContain = false;

        for(Job j : mJobs){
            if(j.getName() == job.getName()) doesContain = true;
            if(job.getDependency() != null){
                for(Job inJob : job.getDependency()){
                   if(inJob.getName() == job.getName()) doesContain = true;
                }
            }
        }
        return doesContain;
    }

    public void registerJob(String dependent, String independent) {
        Job job = new Job(independent);
        if(!containsJob(job)){
            for(Job j : mJobs){
                if(j.containsDepJob(job)){
                    j.changeDependantIntoIndependant(job);
                }
            }
            mJobs.add(job);
        }
        else {
            for(Job j : mJobs){
                if(job.getName() == j.getName()){
                    job = j;
                }
            }
        }

        Job job2 = new Job(dependent);
        job.addDependantJob(job2);
        for(Job j : mJobs){
            if(j.getName() == job2.getName()){
                job.addDependantJob(j);
                mJobs.remove(j);
            }
        }
    }
}
