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

public class Job{

    private String name;

    private Job dependsOn;

    public Job(String name, Job dependsOn) {
        this.name = name;
        this.dependsOn = dependsOn;
    }

    public Job(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Job getDependency() {
        return dependsOn;
    }

    public boolean isIndependent(){
        return false;
    }
}
