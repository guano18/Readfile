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
package Persons

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
import Consumers.*
import java.util.Vector

/**
 *
 * This is an agent.
 *
 */
public class Person  {

    /**
     *
     * The person's Name
     * @field name
     *
     */
    @Parameter (displayName = "Person Name", usageName = "name")
    public String getName() {
        return name
    }
    public void setName(String newValue) {
        name = newValue
    }
    public String name = ""

    /**
     *
     * The person's status
     * @field status
     *
     */
    @Parameter (displayName = "Person Status", usageName = "status")
    public Status getStatus() {
        return status
    }
    public void setStatus(Status newValue) {
        status = newValue
    }
    public Status status = null

    /**
     *
     * Vector containing the days of public vacation
     * @field pVacationVector
     *
     */
    @Parameter (displayName = "Public Vacation Vector", usageName = "pVacationVector")
    public Vector getPVacationVector() {
        return pVacationVector
    }
    public void setPVacationVector(Vector newValue) {
        pVacationVector = newValue
    }
    public Vector pVacationVector = new Vector()

    /**
     *
     * Vector containing the days of sickness
     * @field sicknessVector
     *
     */
    @Parameter (displayName = "Sickness Vector", usageName = "sicknessVector")
    public Vector getSicknessVector() {
        return sicknessVector
    }
    public void setSicknessVector(Vector newValue) {
        sicknessVector = newValue
    }
    public Vector sicknessVector = new Vector()

    /**
     *
     * Duration of leisure activities
     * @field leisureDuration
     *
     */
    @Parameter (displayName = "Leisure Duration", usageName = "leisureDuration")
    public int getLeisureDuration() {
        return leisureDuration
    }
    public void setLeisureDuration(int newValue) {
        leisureDuration = newValue
    }
    public int leisureDuration = 0

    /**
     *
     * Vector containing the daily program of the person
     * @field dailyRoutine
     *
     */
    @Parameter (displayName = "Daily Routine", usageName = "dailyRoutine")
    public Vector getDailyRoutine() {
        return dailyRoutine
    }
    public void setDailyRoutine(Vector newValue) {
        dailyRoutine = newValue
    }
    public Vector dailyRoutine = new Vector()

    /**
     *
     * Vector containing the days of leisure activities
     * @field leisureVector
     *
     */
    @Parameter (displayName = "Leisure Vector", usageName = "leisureVector")
    public Vector getLeisureVector() {
        return leisureVector
    }
    public void setLeisureVector(Vector newValue) {
        leisureVector = newValue
    }
    public Vector leisureVector = new Vector()

    /**
     *
     * Household the person is member of
     * @field memberOf
     *
     */
    @Parameter (displayName = "Member Of", usageName = "memberOf")
    public HouseHold getMemberOf() {
        return memberOf
    }
    public void setMemberOf(HouseHold newValue) {
        memberOf = newValue
    }
    public HouseHold memberOf = null

    /**
     *
     * Vector containing the weekly program of the person
     * @field weeklyRoutine
     *
     */
    @Parameter (displayName = "Weekly Routine", usageName = "weeklyRoutine")
    public Vector getWeeklyRoutine() {
        return weeklyRoutine
    }
    public void setWeeklyRoutine(Vector newValue) {
        weeklyRoutine = newValue
    }
    public Vector weeklyRoutine = new Vector()

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
    protected String agentID = "Person " + (agentIDCounter++)

    /**
     *
     * The initialization behavior of the person agent
     * @method initialize
     *
     */
    public def initialize() {

    }

    /**
     *
     * This is the step behavior.
     * @method isSleeping
     *
     */
    public boolean isSleeping() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (status == Status.Sleeping) {

            // This is a task.
            returnValue = 1

        } else  {

            // This is a task.
            returnValue = 0

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method isAtWork
     *
     */
    public boolean isAtWork() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (status == Status.Working) {

            // This is a task.
            returnValue = 1

        } else  {

            // This is a task.
            returnValue = 0

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method isLeisure
     *
     */
    public boolean isLeisure() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (status == Status.Leisure) {

            // This is a task.
            returnValue = 1

        } else  {

            // This is a task.
            returnValue = 0

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method isVacation
     *
     */
    public boolean isVacation() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (status == Status.Vacation) {

            // This is a task.
            returnValue = 1

        } else  {

            // This is a task.
            returnValue = 0

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method isSick
     *
     */
    public boolean isSick() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (status == Status.Sick) {

            // This is a task.
            returnValue = 1

        } else  {

            // This is a task.
            returnValue = 0

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method createLeisureVector
     *
     */
    public Vector createLeisureVector(int counter) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Vector v = new Vector()

        // This is a loop.
        for (int i = 0; i < counter; i++) {

            // This is a task.
            int day = (int) (RandomDraw(0.0, 7.0))
            v.add(day)

        }

        // This is a task.
        java.util.Collections.sort(v);
        returnValue = v
        // Return the results.
        return returnValue

    }

    /**
     *
     * Filling the daily program of a person
     * @method fillDailyRoutine
     *
     */
    public def fillDailyRoutine(int day, float vacationAbsence) {

        // This is a task.
        Vector v = new Vector(96)
        int weekday = day % 7
        setDailyRoutine(new Vector())
        Status st
        //System.out.println("Day = " + day + " WeekDay = " + weekday)

        // This is an agent decision.
        if (sicknessVector.contains(day)) {

            // This is a task.
            fillSick()

        } else  {


            // This is an agent decision.
            if (pVacationVector.contains(day) || (this instanceof WorkingPerson && vacationVector.contains(day))) {


                // This is an agent decision.
                if (RandomDrawAgainstThreshold(vacationAbsence)) {


                    // This is a loop.
                    for (int i = 1;i < 97; i++) {

                        // This is a task.
                        st = Status.Vacation
                        dailyRoutine.add(st)

                    }


                } else  {

                    // This is a task.
                    normalFill()
                    addLeisure(weekday)

                }

            } else  {

                // This is a task.
                normalFill()

                // This is an agent decision.
                if (this instanceof WorkingPerson) {

                    // This is a task.
                    int index = workingDays.indexOf(weekday)

                    // This is an agent decision.
                    if (index > -1) {

                        // This is a task.
                        fillWork()
                        addLeisureWorking(weekday)

                    } else  {

                        // This is a task.
                        addLeisure(weekday)

                    }

                } else  {

                    // This is a task.
                    addLeisure(weekday)

                }

            }

        }
    }

    /**
     *
     * This is the step behavior.
     * @method createSicknessVector
     *
     */
    public Vector createSicknessVector(float mean, float dev) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Random rand = new Random()
        int days = (int) (dev * rand.nextGaussian() + mean)
        Vector v = new Vector(days)

        // This is a loop.
        for (int i = 0; i < days; i++) {

            // This is a task.
            int x = (int) (RandomDraw(0.0,364.0) + 1)
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
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addLeisure
     *
     */
    public Object addLeisure(int weekday) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        ListIterator iter = leisureVector.listIterator();
        Status st

        // This is a loop.
        while (iter.hasNext()) {


            // This is an agent decision.
            if (iter.next() == weekday) {

                // This is a task.
                int start = RandomDraw(29.0,75.0)

                // This is a loop.
                for (int i = start;i < start +leisureDuration;i++) {

                    // This is a task.
                    st = Status.Leisure
                    dailyRoutine.set(i-1,st)

                }


            } else  {


            }

        }

        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method normalFill
     *
     */
    public def normalFill() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Status st

        // This is a loop.
        for (int i = 1;i < 25;i++) {

            // This is a task.
            st = Status.Sleeping
            dailyRoutine.add(st)

        }


        // This is a loop.
        for (int i = 25;i < 91;i++) {

            // This is a task.
            st = Status.Normal
            dailyRoutine.add(st)

        }


        // This is a loop.
        for (int i = 91;i < 97;i++) {

            // This is a task.
            st = Status.Sleeping
            dailyRoutine.add(st)

        }

        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method fillSick
     *
     */
    public def fillSick() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Status st

        // This is a loop.
        for (int i = 1;i < 25;i++) {

            // This is a task.
            st = Status.Sleeping
            dailyRoutine.add(st)

        }


        // This is a loop.
        for (int i = 25;i < 91; i++) {

            // This is a task.
            st = Status.Sick
            dailyRoutine.add(st)

        }


        // This is a loop.
        for (int i = 91;i < 97;i++) {

            // This is a task.
            st = Status.Sleeping
            dailyRoutine.add(st)

        }

        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method fillWeeklyRoutine
     *
     */
    public Vector fillWeeklyRoutine(float vacationAbsence) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Vector v = new Vector()

        // This is a loop.
        for (int i = 0;i < 7;i++) {

            // This is a task.
            fillDailyRoutine(i,vacationAbsence)
            v.add(dailyRoutine)

        }

        // This is a task.
        returnValue = v
        // Return the results.
        return returnValue

    }

    /**
     *
     * Refreshing weekly program
     * @method refresh
     *
     */
    public def refresh() {

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
