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

import java.util.LinkedList;
import java.util.List;

public class Job {
    private String mName;
    private List<Job> listOfDependants;

    public Job(String name) {
        mName = name;
        listOfDependants = null;
    }

    public String getName() {
        return mName;
    }

    public List<Job> getDependency() {
        return listOfDependants;
    }

    public boolean addDependantJob(Job dependantJob){
        boolean added = false;

        if(listOfDependants == null) listOfDependants = new LinkedList<>();
        if(!containsDepJob(dependantJob)){
            listOfDependants.add(dependantJob);
        }
        if(dependantJob.getDependency() != null){
            int depJobsSize = dependantJob.getDependency().size();
            for(int i = 0; i < depJobsSize; i++){ //Job j : dependantJob.getDependency()

                listOfDependants.add(dependantJob.getDependency().get(0));
                dependantJob.listOfDependants.remove(dependantJob.getDependency().get(0));
            }
        }

        return added;
    }

    public boolean containsDepJob(Job job){
        boolean doesContain = false;
        if(listOfDependants != null){
            for(Job j : listOfDependants){
                if(j.getName() == job.getName()) doesContain = true;
            }
        }
        return doesContain;
    }

    public boolean changeDependantIntoIndependant(Job job){
        boolean changed = false;

        for (Job j : listOfDependants){
            if(j.getName() == job.getName()) {
                listOfDependants.remove(j);
                changed = true;
            }
        }

        return changed;
    }

    public void bubbleSort() {
        if(listOfDependants != null){
            int n = listOfDependants.size();
            Job temp = null;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (listOfDependants.get(j-1).getName().compareTo(listOfDependants.get(j).getName()) == 1) {
                        //swap elements
                        temp = listOfDependants.get(j-1);
                        listOfDependants.set(j-1, listOfDependants.get(j));
                        listOfDependants.set(j, temp);
                    }

                }
            }
        }
    }
}
