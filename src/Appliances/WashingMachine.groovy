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

/**
 *
 * This is an agent.
 *
 */
public class WashingMachine extends SemiShiftingAppliance  {

    /**
     *
     * This is an agent property.
     * @field mode
     *
     */
    @Parameter (displayName = "Mode", usageName = "mode")
    public Mode getMode() {
        return mode
    }
    public void setMode(Mode newValue) {
        mode = newValue
    }
    public Mode mode = null

    /**
     *
     * This is an agent property.
     * @field reaction
     *
     */
    @Parameter (displayName = "Reaction", usageName = "reaction")
    public Reaction getReaction() {
        return reaction
    }
    public void setReaction(Reaction newValue) {
        reaction = newValue
    }
    public Reaction reaction = null

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
    protected String agentID = "WashingMachine " + (agentIDCounter++)

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
        name = "Washing Machine"
        saturation = (float)hm.get("WashingMachineSaturation")
        Random rand = new Random()
        times = (int)hm.get("WashingMachineWeeklyTimes")
        // This is a task.
        consumptionShare = (float) (0.01 * (0.6 * rand.nextGaussian() + 3.5))
        baseLoadShare = 0.02
        power = (int) (100 * rand.nextGaussian() + 600)
        cycleDuration = 9
        // This is a task.
        od = true
        inUse = false
        probabilitySeason = fillSeason(30,35,35)
        probabilityWeekday = fillDay(14,14,16)
        createWeeklyOperationVector((int)(times + getMemberOf().getMembers().size() / 2))
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
        Vector operation = operationVector.get(weekday)

        // This is a loop.
        for (int l = 0;l < 96; l++) {

            // This is a task.
            loadVector.add(0)
            dailyOperation.add(false)

        }


        // This is a loop.
        for (int i = 0;i < 96;i++) {


            // This is an agent decision.
            if (operation.get(i) == true) {

                // This is a task.
                boolean flag = true

                // This is a loop.
                while (flag && i < 96) {

                    // This is a task.
                    boolean empty = checkHouse(i)

                    // This is an agent decision.
                    if (empty == false) {


                        // This is a loop.
                        for (int k = i;k < i + 9;k++) {

                            // This is a task.
                            //System.out.println("k = " + k)
                            //System.out.println("Empty = " + empty)
                            loadVector.set(k,power)
                            dailyOperation.set(k,true)

                        }

                        // This is a task.
                        i = 96
                        flag = false

                    } else  {

                        // This is a task.
                        i++

                    }

                }


            } else  {


            }

        }

        // This is a task.
        weeklyLoadVector.add(loadVector)
        weeklyOperation.add(dailyOperation)
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method checkHouse
     *
     */
    public boolean checkHouse(int hour) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        boolean empty = true
        int j = hour

        // This is a loop.
        while ((j < hour + 8) && (empty == true) && (j < 96)) {

            // This is a task.
            empty = empty & getMemberOf().isEmpty(j+1)
            j++

        }

        // This is a task.
        returnValue = empty
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
        System.out.println("Saturation = " + saturation)
        System.out.println("Consumption Share = " + consumptionShare)
        System.out.println("Base Load Share = " + baseLoadShare)
        System.out.println("Power = " + power)
        // This is a task.
        System.out.println("Cycle Duration = "+ cycleDuration)
        System.out.println("Occupancy Dependence = "+ od)
        System.out.println("In Use = " + inUse)
        System.out.println("Operation Mode = " + mode)
        // This is a task.
        Set set = probabilitySeason.entrySet();
        Iterator it = set.iterator();
        System.out.println("Probability Season = ")

        // This is a loop.
        while (it.hasNext()) {

            // This is a task.
            Map.Entry me = (Map.Entry)it.next();
            System.out.println(me.getKey() + " : " + me.getValue() );

        }

        // This is a task.
        set = probabilityWeekday.entrySet();
        it = set.iterator();
        System.out.println("Probability Weekday = ")

        // This is a loop.
        while (it.hasNext()) {

            // This is a task.
            Map.Entry me = (Map.Entry)it.next();
            System.out.println(me.getKey() + " : " + me.getValue() );

        }

        // This is a task.
        ListIterator iter = days.listIterator();
        System.out.println("Days Vector = ")

        // This is a loop.
        while (iter.hasNext()) {

            // This is a task.
            System.out.println("Day  " + iter.next())

        }

        // This is a task.
        iter = operationVector.listIterator();
        System.out.println("Operation Vector = ")

        // This is a loop.
        for (int i = 0; i < 7;i++) {

            // This is a task.
            System.out.println("Day " + (i))
            iter =operationVector.get(i).listIterator();

            // This is a loop.
            for (int j = 0;j < 96; j++) {

                // This is a task.
                System.out.println("Quarter : " + (j+1) + "  " + iter.next())

            }


        }

        // This is a task.
        System.out.println("Weekly Operation Vector and Load = ")

        // This is a loop.
        for (int i = 0; i < 7;i++) {

            // This is a task.
            System.out.println("Day " + (i))
             iter = weeklyOperation.get(i).listIterator();
            ListIterator iter2 = weeklyLoadVector.get(i).listIterator();

            // This is a loop.
            for (int j = 0;j < 96; j++) {

                // This is a task.
                System.out.println("Quarter " + (j+1) + " = " + iter.next() + "   Load = " + iter2.next())

            }


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
        createWeeklyOperationVector((int)(times + getMemberOf().getMembers().size() / 2))
        fillWeeklyFunction()
        System.out.println("Washing Machine refreshed")
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

