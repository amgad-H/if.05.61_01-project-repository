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

public class Job{
    private String mName;
    private Job mDependsOn;

    public Job(String name, Job dependsOn) {
        mName = name;
        mDependsOn = dependsOn;
    }

    public Job(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public Job getDependency() {
        return mDependsOn;
    }
}
