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
public class PeriodicPresentPerson extends WorkingPerson  {

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
    protected String agentID = "PeriodicPresentPerson " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method initialize
     *
     */
    public def initialize(String AgentName, HashMap hm, Vector publicVacationVector) {

        // This is a task.
        float sicknessMean = ((float)hm.get("SicknessMean"))
        float sicknessDev = ((float)hm.get("SicknessDev"))
        float leisureDurationMean = ((int)hm.get("LeisureDurationMean"))
        float leisureDurationDev = ((int)hm.get("LeisureDurationDev"))
        float PPLeisure = ((int)hm.get("PPLeisure"))
        // This is a task.
        name = AgentName
        status = Status.Normal
        // This is a task.
        sicknessVector = createSicknessVector(sicknessMean,sicknessDev)
        pVacationVector = publicVacationVector
        // This is a task.
        Random rand = new Random();
        int x = (int) (rand.nextGaussian() + PPLeisure)
        leisureVector = createLeisureVector(x)
        // This is a task.
        leisureDuration = (int) (leisureDurationDev * rand.nextGaussian() + leisureDurationMean)
        // This is a task.
        workingStartHour = 29
        int work = workingDaysRandomizer(hm)
        workingDays = createWorkingDaysVector(work)
        // This is a task.
        int workingDurationMean = ((int)hm.get("WorkingDurationMean"))
        int workingDurationDev = ((int)hm.get("WorkingDurationDev"))
        workingDuration = (int) (workingDurationDev * rand.nextGaussian() + workingDurationMean)
        // This is a task.
        int vacationDurationMean = ((int)hm.get("VacationDurationMean"))
        int vacationDurationDev = ((int)hm.get("VacationDurationDev"))
        vacationDuration = (int) (vacationDurationDev * rand.nextGaussian() + vacationDurationMean)
        // This is a task.
        vacationVector = createVacationVector(vacationDuration)
    }

    /**
     *
     * This is the step behavior.
     * @method addLeisureWorking
     *
     */
    public def addLeisureWorking(int weekday) {

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
                int start = workingStartHour + workingDuration
                int startq = RandomDraw(start,75)

                // This is a loop.
                for (int i = startq;i < startq +leisureDuration;i++) {

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
     * @method fillWork
     *
     */
    public def fillWork() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        Status st

        // This is a loop.
        for (int i = workingStartHour;i < workingStartHour + workingDuration;i++) {

            // This is a task.
            st = Status.Working
            dailyRoutine.set(i-1,st)

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
    public def refresh(HashMap hm) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        float leisureDurationMean = ((int)hm.get("LeisureDurationMean"))
        float leisureDurationDev = ((int)hm.get("LeisureDurationDev"))
        float PPLeisure = ((int)hm.get("PPLeisure"))
        float vacationAbsence = ((float)hm.get("VacationAbsence"))
        // This is a task.
        Random rand = new Random();
        int x = (int) (rand.nextGaussian() + PPLeisure)
        leisureDuration = (int) (leisureDurationDev * rand.nextGaussian() + leisureDurationMean)
        leisureVector = createLeisureVector(x)
        weeklyRoutine = fillWeeklyRoutine(vacationAbsence)
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

