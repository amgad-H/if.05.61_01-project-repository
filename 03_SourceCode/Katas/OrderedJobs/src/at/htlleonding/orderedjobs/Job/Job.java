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

        if(!containsDepJob(dependantJob)){
            if(listOfDependants == null) listOfDependants = new LinkedList<>();
            listOfDependants.add(dependantJob);
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
}
