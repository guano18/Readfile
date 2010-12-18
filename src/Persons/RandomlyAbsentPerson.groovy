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
import java.util.Vector

/**
 *
 * This is an agent.
 *
 */
public class RandomlyAbsentPerson extends WorkingPerson  {

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
    protected String agentID = "RandomlyAbsentPerson " + (agentIDCounter++)

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
        float RALeisure = ((int)hm.get("RALeisure"))
        // This is a task.
        name = AgentName
        status = Status.Normal
        // This is a task.
        sicknessVector = createSicknessVector(sicknessMean,sicknessDev)
        pVacationVector = publicVacationVector
        // This is a task.
        Random rand = new Random();
        int x = (int) (rand.nextGaussian() + RALeisure)
        leisureVector = createLeisureVector(x)
        // This is a task.
        leisureDuration = (int) (leisureDurationDev * rand.nextGaussian() + leisureDurationMean)
        // This is a task.
        int work = workingDaysRandomizer(hm)
        workingDays = createWorkingDaysVector(work)
        workingStartHour = createWorkingStartHour()
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
     * @method createWorkingStartHour
     *
     */
    public int createWorkingStartHour() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int x = (int) RandomDraw(0.0,3.0)
        returnValue = (x * 8 * 4) + 1
        // Return the results.
        return returnValue

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

                // This is an agent decision.
                if (workingStartHour == 1) {

                    // This is a task.
                    int startq = RandomDraw(start + 33, 80)

                    // This is a loop.
                    for (int i = startq;i < startq + leisureDuration;i++) {

                        // This is a task.
                        st = Status.Leisure
                        dailyRoutine.set(i-1,st)

                    }


                } else  {


                    // This is an agent decision.
                    if (workingStartHour == 33) {

                        // This is a task.
                        int startq = RandomDraw(start, 80)

                        // This is a loop.
                        for (int i = startq;i < startq + leisureDuration;i++) {

                            // This is a task.
                            st = Status.Leisure
                            dailyRoutine.set(i-1,st)

                        }


                    } else  {

                        // This is a task.
                        int startq = RandomDraw(33, workingStartHour - 12)

                        // This is a loop.
                        for (int i = startq;i < startq +leisureDuration;i++) {

                            // This is a task.
                            st = Status.Leisure
                            dailyRoutine.set(i-1,st)

                        }


                    }

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

        // This is an agent decision.
        if (workingStartHour == 1) {


            // This is a loop.
            for (int i = 1;i < workingDuration + 1;i++) {

                // This is a task.
                st = Status.Working
                dailyRoutine.set(i-1,st)

            }


            // This is a loop.
            for (int i = workingDuration + 1;i < workingDuration + 33 ;i++) {

                // This is a task.
                st = Status.Sleeping
                dailyRoutine.set(i-1,st)

            }


            // This is a loop.
            for (int i = workingDuration + 33;i < 97;i++) {

                // This is a task.
                st = Status.Normal
                dailyRoutine.set(i-1,st)

            }


        } else  {


            // This is an agent decision.
            if (workingStartHour == 33) {


                // This is a loop.
                for (int i = 1;i < 25;i++) {

                    // This is a task.
                    st = Status.Sleeping
                    dailyRoutine.set(i-1,st)

                }


                // This is a loop.
                for (int i = 25;i < 33;i++) {

                    // This is a task.
                    st = Status.Normal
                    dailyRoutine.set(i-1,st)

                }


                // This is a loop.
                for (int i = 33;i < workingDuration + 33 ;i++) {

                    // This is a task.
                    st = Status.Working
                    dailyRoutine.set(i-1,st)

                }


                // This is a loop.
                for (int i = workingDuration + 33;i < 91;i++) {

                    // This is a task.
                    st = Status.Normal
                    dailyRoutine.set(i-1,st)

                }


                // This is a loop.
                for (int i = 91;i < 97;i++) {

                    // This is a task.
                    st = Status.Sleeping
                    dailyRoutine.set(i-1,st)

                }


            } else  {


                // This is a loop.
                for (int i = 1;i < 29;i++) {

                    // This is a task.
                    st = Status.Sleeping
                    dailyRoutine.set(i-1,st)

                }


                // This is a loop.
                for (int i = 33;i < 65 ;i++) {

                    // This is a task.
                    st = Status.Normal
                    dailyRoutine.set(i-1,st)

                }


                // This is an agent decision.
                if (workingDuration > 32) {


                    // This is a loop.
                    for (int i = 65;i < 97;i++) {

                        // This is a task.
                        st = Status.Working
                        dailyRoutine.set(i-1,st)

                    }


                } else  {


                    // This is a loop.
                    for (int i = 65;i < 65 + workingDuration;i++) {

                        // This is a task.
                        st = Status.Working
                        dailyRoutine.set(i-1,st)

                    }


                    // This is a loop.
                    for (int i =  65 + workingDuration;i < 97;i++) {

                        // This is a task.
                        st = Status.Sleeping
                        dailyRoutine.set(i-1,st)

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
        float RALeisure = ((int)hm.get("RALeisure"))
        float vacationAbsence = ((float)hm.get("VacationAbsence"))
        // This is a task.
        int work = workingDaysRandomizer(hm)
        workingDays = createWorkingDaysVector(work)
        workingStartHour = createWorkingStartHour()
        // This is a task.
        Random rand = new Random();
        int x = (int) (rand.nextGaussian() + RALeisure)
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

