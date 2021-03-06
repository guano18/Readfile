/**
 * 
 * This file was automatically generated by the Repast Simphony Agent Editor.
 * Please see http://repast.sourceforge.net/ for details.
 * 
 */

/**
 *
 * Set the package name.
 *
 */
package bin.Persons

/**
 *
 * Import the needed packages.
 *
 */
import java.io.*
import java.math.*
import java.util.*
import javax.measure.unit.*
import org.jscience.mathematics.number.*
import org.jscience.mathematics.vector.*
import org.jscience.physics.amount.*
import repast.simphony.adaptation.neural.*
import repast.simphony.adaptation.regression.*
import repast.simphony.context.*
import repast.simphony.context.space.continuous.*
import repast.simphony.context.space.gis.*
import repast.simphony.context.space.graph.*
import repast.simphony.context.space.grid.*
import repast.simphony.engine.environment.*
import repast.simphony.engine.schedule.*
import repast.simphony.engine.watcher.*
import repast.simphony.groovy.math.*
import repast.simphony.integration.*
import repast.simphony.matlab.link.*
import repast.simphony.query.*
import repast.simphony.query.space.continuous.*
import repast.simphony.query.space.gis.*
import repast.simphony.query.space.graph.*
import repast.simphony.query.space.grid.*
import repast.simphony.query.space.projection.*
import repast.simphony.parameter.*
import repast.simphony.random.*
import repast.simphony.space.continuous.*
import repast.simphony.space.gis.*
import repast.simphony.space.graph.*
import repast.simphony.space.grid.*
import repast.simphony.space.projection.*
import repast.simphony.ui.probe.*
import repast.simphony.util.*
import simphony.util.messages.*
import static java.lang.Math.*
import static repast.simphony.essentials.RepastEssentials.*
import java.util.Vector

/**
 *
 * This is an agent.
 *
 */
public class WorkingPerson extends Person  {

    /**
     *
     * This is an agent property.
     * @field workingDays
     *
     */
    @Parameter (displayName = "Working Days", usageName = "workingDays")
    public Vector getWorkingDays() {
        return workingDays
    }
    public void setWorkingDays(Vector newValue) {
        workingDays = newValue
    }
    public Vector workingDays = null

    /**
     *
     * This is an agent property.
     * @field workingDuration
     *
     */
    @Parameter (displayName = "Working Duration", usageName = "workingDuration")
    public int getWorkingDuration() {
        return workingDuration
    }
    public void setWorkingDuration(int newValue) {
        workingDuration = newValue
    }
    public int workingDuration = 0

    /**
     *
     * This is an agent property.
     * @field vacationDuration
     *
     */
    @Parameter (displayName = "Vacation Duration", usageName = "vacationDuration")
    public int getVacationDuration() {
        return vacationDuration
    }
    public void setVacationDuration(int newValue) {
        vacationDuration = newValue
    }
    public int vacationDuration = 0

    /**
     *
     * This is an agent property.
     * @field vacationVector
     *
     */
    @Parameter (displayName = "Vacation Vector", usageName = "vacationVector")
    public Vector getVacationVector() {
        return vacationVector
    }
    public void setVacationVector(Vector newValue) {
        vacationVector = newValue
    }
    public Vector vacationVector = null

    /**
     *
     * This is an agent property.
     * @field workingStartHour
     *
     */
    @Parameter (displayName = "Working Start Hour", usageName = "workingStartHour")
    public int getWorkingStartHour() {
        return workingStartHour
    }
    public void setWorkingStartHour(int newValue) {
        workingStartHour = newValue
    }
    public int workingStartHour = 0

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field serialVersionUID
     *
     */
    private static final long serialVersionUID = 1L

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field agentIDCounter
     *
     */
    protected static long agentIDCounter = 1

    /**
     *
     * This value is the agent's identifier.
     * @field agentID
     *
     */
    protected String agentID = "WorkingPerson " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method initialize
     *
     */
    public def initialize(String AgentName) {

        // This is a task.
    }

    /**
     *
     * This is the step behavior.
     * @method createWorkingDaysVector
     *
     */
    public Vector createWorkingDaysVector(int days) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Vector v = new Vector(days)

        // This is an agent decision.
        if (days < 5) {


            // This is a loop.
            for (int i = 0; i < days; i++) {

                // This is a task.
                int x = (int) (RandomDraw() * 4 + 1)
                ListIterator iter = v.listIterator();

                // This is a loop.
                while (iter.hasNext()) {

                    // This is a task.
                    int temp = (int)iter.next()

                    // This is an agent decision.
                    if (x == temp) {

                        // This is a task.
                        x = x + 1
                        iter = v.listIterator();

                    } else  {


                    }

                }

                // This is a task.
                v.add(x)

            }

            // This is a task.
            java.util.Collections.sort(v);
            returnValue = v

        } else  {

            // This is a task.
            v.add(1)
            v.add(2)
            v.add(3)
            v.add(4)
            v.add(5)

            // This is an agent decision.
            if (days == 5) {


            } else  {


                // This is an agent decision.
                if (days == 7) {

                    // This is a task.
                    v.add(6)
                    v.add(0)

                } else  {


                    // This is an agent decision.
                    if (RandomDrawAgainstThreshold(0.5)) {

                        // This is a task.
                        v.add(6)

                    } else  {

                        // This is a task.
                        v.add(0)

                    }

                }

            }
            // This is a task.
            java.util.Collections.sort(v);
            returnValue = v

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method createVacationVector
     *
     */
    public Vector createVacationVector(int duration) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Vector v = new Vector(duration)
        int counter = duration
        int counter2 = 0

        // This is a loop.
        while (counter > 0) {

            // This is a task.
            int x = (int) (RandomDraw(0.0,364.0) + 1)
            counter2 = (int)(RandomDraw(1.0,counter))
            ListIterator iter = v.listIterator()

            // This is a loop.
            while (counter2 > 0) {

                // This is a task.
                v.add(x)
                counter = counter - 1
                counter2 = counter2 - 1
                x = x + 1

            }


        }

        // This is a task.
        java.util.Collections.sort(v);
        returnValue = v
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method workingDaysRandomizer
     *
     */
    public int workingDaysRandomizer(HashMap hm) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int oneDay = ((int)hm.get("OneDay"))
        int twoDays = ((int)hm.get("TwoDays"))
        int threeDays = ((int)hm.get("ThreeDays"))
        int fourDays = ((int)hm.get("FourDays"))
        int fiveDays = ((int)hm.get("FiveDays"))
        // This is a task.
        int sixDays = ((int)hm.get("SixDays"))
        int sevenDays = ((int)hm.get("SevenDays"))
        int x = (int) RandomDraw(0.0,100.0)

        // This is an agent decision.
        if (x < fiveDays) {

            // This is a task.
            returnValue = 5

        } else  {


            // This is an agent decision.
            if (x >= fiveDays & x < (fiveDays + sixDays)) {

                // This is a task.
                returnValue = 6

            } else  {


                // This is an agent decision.
                if (x >= (fiveDays + sixDays) & x < (fiveDays + sixDays + fourDays)) {

                    // This is a task.
                    returnValue = 4

                } else  {


                    // This is an agent decision.
                    if (x >= (fiveDays + sixDays + fourDays) & x < (fiveDays + sixDays + fourDays + threeDays)) {

                        // This is a task.
                        returnValue = 3

                    } else  {


                        // This is an agent decision.
                        if (x >= (fiveDays + sixDays + fourDays + threeDays) & x < (fiveDays + sixDays + fourDays + threeDays+twoDays)) {

                            // This is a task.
                            returnValue = 2

                        } else  {


                            // This is an agent decision.
                            if (x >= (fiveDays + sixDays + fourDays + threeDays+twoDays) & x < (fiveDays + sixDays + fourDays + threeDays+twoDays+sevenDays)) {

                                // This is a task.
                                returnValue  = 7

                            } else  {

                                // This is a task.
                                returnValue = 1

                            }

                        }

                    }

                }

            }

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method showStatus
     *
     */
    public def showStatus() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        System.out.println("Name = " + name)
        System.out.println("Member Of = " + getMemberOf().getName())
        System.out.println("Sickness Days = ")
        ListIterator iter = sicknessVector.listIterator();

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println(iter.next());

        }

        // This is a task.
        System.out.println("Leisure Days of Week = ");
        iter = leisureVector.listIterator();

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println(iter.next());

        }

        // This is a task.
        System.out.println("Leisure Duration = " + leisureDuration);
        System.out.println("Working Days = ");
        iter = workingDays.listIterator();

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println(iter.next());

        }

        // This is a task.
        System.out.println("Working Duration = " + workingDuration);
        System.out.println("Working Starting Hour = " + workingStartHour)
        System.out.println("Vacation Duration = " + vacationDuration);
        System.out.println("Vacation Days = ");
        iter = vacationVector.listIterator();

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println(iter.next());

        }

        // This is a task.
        System.out.println("Public Vacation of Year = ");
        iter = pVacationVector.listIterator();

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println(iter.next());

        }

        // This is a task.
        System.out.println("Weekly Routine : ")
        iter = weeklyRoutine.get(0).listIterator();

        // This is a loop.
        for (int i = 0; i < 7;i++) {

            // This is a task.
            System.out.println("Day " + (i))
            iter = weeklyRoutine.get(i).listIterator();

            // This is a loop.
            for (int j =0;j < 96;j++) {

                // This is a task.
                System.out.println("Quarter : " + (j+1) + " Status : " + iter.next())

            }


        }

        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method fillWork
     *
     */
    public def fillWork() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        // Return the results.
        return returnValue

    }

    /**
     *
     * This method provides a human-readable name for the agent.
     * @method toString
     *
     */
    @ProbeID()
    public String toString() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Set the default agent identifier.
        returnValue = this.agentID
        // Return the results.
        return returnValue

    }


}

