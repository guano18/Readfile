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
package Appliances

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
public class SemiShiftingAppliance extends Appliance  {

    /**
     *
     * This is an agent property.
     * @field days
     *
     */
    @Parameter (displayName = "Days", usageName = "days")
    public Vector getDays() {
        return days
    }
    public void setDays(Vector newValue) {
        days = newValue
    }
    public Vector days = new Vector()

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
    protected String agentID = "SemiShiftingAppliance " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method createDailyOperationVector
     *
     */
    public Vector createDailyOperationVector(int weekday) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Vector v = new Vector(96)

        // This is a loop.
        for (int i = 0;i < 96;i++) {

            // This is a task.
            v.add(false)

        }


        // This is an agent decision.
        if (days.contains(weekday) && ((this instanceof Dryer) == false)) {

            // This is a task.
            int quarter = (int) RandomDraw(1,84)
            v.set(quarter-1,true)
            // This is a task.
            returnValue = v

        } else  {

            // This is a task.
            returnValue = v

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method createWeeklyOperationVector
     *
     */
    public def createWeeklyOperationVector(int times) {

        // This is a task.
        fillDays(times)

        // This is a loop.
        for (int i=0;i < 7;i++) {

            // This is a task.
            operationVector.add(createDailyOperationVector(i))

        }

    }

    /**
     *
     * This is the step behavior.
     * @method fillWeeklyFunction
     *
     */
    public def fillWeeklyFunction() {


        // This is a loop.
        for (int i = 0;i < 7; i++) {

            // This is a task.
            fillDailyFunction(i)

        }

    }

    /**
     *
     * This is the step behavior.
     * @method fillDays
     *
     */
    public def fillDays(int times) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (int i=0; i < times; i++) {

            // This is a task.
            int day = (int) (RandomDraw(0.0, 6.0))
            ListIterator iter = days.listIterator();

            // This is a loop.
            while (iter.hasNext()) {

                // This is a task.
                int temp = (int)iter.next()

                // This is an agent decision.
                if (day == temp) {

                    // This is a task.
                    day = day + 1
                    iter = days.listIterator();

                } else  {


                }

            }

            // This is a task.
            days.add(day)
            java.util.Collections.sort(days);

        }

        // This is a task.
        java.util.Collections.sort(days);
        ListIterator iter = days.listIterator();
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

