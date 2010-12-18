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
package bin.Appliances

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

/**
 *
 * This is an agent.
 *
 */
public class SpaceHeater extends FullyShiftingAppliance  {

    /**
     *
     * This is an agent property.
     * @field percentage
     *
     */
    @Parameter (displayName = "Usage Percentage", usageName = "percentage")
    public float getPercentage() {
        return percentage
    }
    public void setPercentage(float newValue) {
        percentage = newValue
    }
    public float percentage = 0

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
    protected String agentID = "SpaceHeater " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method initialize
     *
     */
    public def initialize(HashMap hm) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        name = "SpaceHeater"
        saturation = (float)hm.get("SpaceHeaterSaturation")
        float percentage = (float)hm.get("SpaceHeaterPercentage")
        Random rand = new Random()
        // This is a task.
        consumptionShare = (float) (0.01 * (2.8 * rand.nextGaussian() + 17))
        baseLoadShare = 0
        power = (int) (300 * rand.nextGaussian() + 7000)
        cycleDuration = 14
        // This is a task.
        od = false
        inUse = false
        probabilitySeason = fillSeason(21,42,37)
        probabilityWeekday = fillDay(15,14,15)
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method fillDailyFunction
     *
     */
    public def fillDailyFunction(int weekday) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        loadVector = new Vector()
        dailyOperation = new Vector()

        // This is an agent decision.
        if (getMemberOf().isOnVacation(1) || RandomDrawAgainstThreshold(percentage)) {


            // This is a loop.
            for (int i = 0;i < 96;i++) {

                // This is a task.
                loadVector.add(0)
                dailyOperation.add(false)

            }

            // This is a task.
            weeklyLoadVector.add(loadVector)
            weeklyOperation.add(dailyOperation)
            operationVector.add(dailyOperation)

        } else  {


            // This is a loop.
            for (int i = 0;i < 96;i++) {

                // This is a task.
                loadVector.add(0)
                dailyOperation.add(true)

            }


            // This is a loop.
            for (int i = 0;i < 9;i++) {

                // This is a task.
                loadVector.set(i,power)

            }


            // This is a loop.
            for (int i = 9;i < 16;i++) {

                // This is a task.
                loadVector.set(i,power - 750*(i - 8))

            }


            // This is a loop.
            for (int i = 16;i < 86; i++) {

                // This is a task.
                loadVector.set(i,power - 750*8)

            }


            // This is a loop.
            for (int i=86;i < 90;i++) {

                // This is a task.
                loadVector.set(i, power - 1500*(89 - i))

            }


            // This is a loop.
            for (int i= 90;i < 96;i++) {

                // This is a task.
                loadVector.set(i,power)

            }

            // This is a task.
            weeklyLoadVector.add(loadVector)
            weeklyOperation.add(dailyOperation)
            operationVector.add(dailyOperation)

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method refresh
     *
     */
    public def refresh() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        fillWeeklyFunction()
        System.out.println("Space Heater refreshed")
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

